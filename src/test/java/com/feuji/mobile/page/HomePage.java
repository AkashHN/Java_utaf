package com.feuji.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.feuji.page.BasePage;

public class HomePage extends BasePage {

	private final By searchBarElement = By
			.xpath("(//android.widget.TextView[@resource-id='com.letyshops:id/toolbar_title'])[1]");
	private final By notificationIcon = By.xpath("//android.widget.TextView[@content-desc='Notifications']");
	private final By notificationBackIcon = By.xpath("//android.widget.ImageButton");
	private final By noticationHeading = By
			.xpath("(//android.widget.TextView[@resource-id='com.letyshops:id/toolbar_title'])[2]");
	private final By searchElement1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout");
	private final By selectItem1 = By
			.xpath("(//android.widget.FrameLayout[@resource-id='com.letyshops:id/foreground_view'])[1]");
	private final By enterSearch = By.xpath("//android.widget.EditText[@resource-id='com.letyshops:id/edit_text_search']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void searchItem(String itemName) {
		WebElement searchElement = driver.findElement(searchBarElement);
		searchElement.click();
		WebElement entersearchElement = driver.findElement(enterSearch);
		entersearchElement.sendKeys(itemName);
		WebElement findSearchElement = driver.findElement(searchElement1);
		System.out.println(findSearchElement);
		findSearchElement.click();
	}

	public void clickNotification() {
		WebElement notificationElement = driver.findElement(notificationIcon);
		notificationElement.click();
	}

	public void clickNotificationBack() {
		WebElement clickBack = driver.findElement(notificationBackIcon);
		clickBack.click();
	}

	public WebElement getNotificationHeading() {
		WebElement headingElement = driver.findElement(noticationHeading);
		return headingElement;
	}

	public void clickItem() {
		WebElement itemElement = driver.findElement(selectItem1);
		itemElement.click();
	}
}
