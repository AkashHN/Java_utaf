package com.feuji.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.feuji.page.BasePage;

import io.appium.java_client.AppiumBy;

public class AccountPage extends BasePage {
	private final By accountIcon = By.xpath("//android.widget.FrameLayout[@content-desc=\"Account\"]/android.view.ViewGroup/android.widget.TextView");
	private final By settingsOption = By.xpath("//android.widget.TextView[@text='Settings']");
	private final By editProfileTitle = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/toolbar_title_edit_profile']");
	private final By userIdField = By.xpath("//android.widget.EditText[@resource-id='com.letyshops:id/edit_profile_edit_text']");
	private final By userMailIdField = By.xpath("(//android.widget.TextView[@resource-id='com.letyshops:id/edit_profile_edit_text'])[2]");
	private final By genderDropdown = By.xpath("//android.widget.RelativeLayout[@resource-id='com.letyshops:id/edit_profile_chose_sex']//android.widget.ImageView");
	private final By genderFemale = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/popup_title_2']");
	private final By closeEditProfileIcon = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	private final By exitOption = By.xpath("//android.widget.TextView[@text='EXIT']");
	private final By clsReferalDialog = By.xpath("//android.widget.ImageView[@content-desc='close']");
	private By logOutOption = By.xpath("//android.widget.TextView[@text='Logout']");
	private By okOption = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/md_buttonDefaultPositive']");

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAccountIcon() {
		WebElement icon = driver.findElement(accountIcon);
		icon.click();
	}
	
	public void clickClsReferalDialog() {
		WebElement clsReferalDialogEle = driver.findElement(clsReferalDialog);
		clsReferalDialogEle.click();
	}
	 
	
	public void clickSettings() {
		WebElement option = driver.findElement(settingsOption);
		option.click();
	}
	
	public WebElement getTitleEditProfile() {
		WebElement title = driver.findElement(editProfileTitle);
		return title;
	}
	
	public WebElement getUserId() {
		WebElement id = driver.findElement(userIdField);
		return id;
	}
	
	public WebElement getUserMailId() {
		WebElement mailId = driver.findElement(userMailIdField);
		return mailId;
	}
	
	public void chooseGender() {
		WebElement dropdown = driver.findElement(genderDropdown);
		dropdown.click();
		WebElement gender = driver.findElement(genderFemale);
		gender.click();
			
	}
	
	public void closeEditingProfile() {
		WebElement closeIcon = driver.findElement(closeEditProfileIcon);
		closeIcon.click();
		WebElement option = driver.findElement(exitOption);
		option.click();
	}
	
	public void logOut() {
		WebElement optionLogOut = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Logout\"));"));
		//WebElement optionLogOut = driver.findElement(logOutOption);
		optionLogOut.click();
		WebElement confirmation = driver.findElement(okOption);
		confirmation.click();
	}
	
	
}