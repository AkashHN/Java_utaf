package com.feuji.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.feuji.page.BasePage;

public class LanguageSelectPage extends BasePage  {
	
	private final By languageRadioButton = By.xpath("//android.widget.RadioButton[@resource-id='com.letyshops:id/radio_button']");
	private final By selectLanguageHeading = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/tv_choose_country_title']");
	private final By applyButton = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/btn_apply']");
	
	public LanguageSelectPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSelectLanguage() {
		WebElement selectButton = driver.findElement(languageRadioButton);
		selectButton.click();
	}
	
	public WebElement getHeading() {
		WebElement headingElement = driver.findElement(selectLanguageHeading);
		return headingElement;
	}
	
	public void clickApplyButton() {
		WebElement applyElement = driver.findElement(applyButton);
		applyElement.click();
	}
}
