package com.feuji.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.feuji.page.BasePage;

public class GoToStorePage extends BasePage {

	private final By favIcon = By.xpath("//android.widget.ImageView[@resource-id='com.letyshops:id/shop_final_float_favorite_img']");
	private final By storeBtn = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/go_to_shop_btn']");
	private final By conditionsTxt = By.xpath("//android.widget.LinearLayout[@content-desc='CONDITIONS']");
	private final By reviewTxt = By.xpath("//android.widget.LinearLayout[@content-desc='REVIEWS']");
	private final By cashBackStatusTxt = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/cashbackStatusTxt']");
	private final By closeWebBtn = By.xpath("//android.widget.ImageView[@resource-id='com.letyshops:id/close_btn']");
	private final By closeWebConfirmTxt = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/md_title']");
	private final By closeWebConfirmBtn = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/md_buttonDefaultPositive']");
	private final By storeBackBtn = By.xpath("(//android.widget.ImageButton)[1]");
	
	public GoToStorePage(WebDriver driver) {
		super(driver);
	}
	
	public void closeStoreBtn() {
		WebElement storeBackBtnElement = driver.findElement(storeBackBtn);
		storeBackBtnElement.click();
	}
	
	public WebElement getCloseWebConfirmTxt() {
		WebElement closeWebConfirmTxtElement = driver.findElement(closeWebConfirmTxt);
		return closeWebConfirmTxtElement;
	}
	
	public void closeWebConfirmBtn() {
		WebElement closeWebConfirmBtnElement = driver.findElement(closeWebConfirmBtn);
		closeWebConfirmBtnElement.click();
	}
	
	public WebElement getCashBackStatusTxt() {
		WebElement cashBackStatusTxtElement = driver.findElement(cashBackStatusTxt);
		return cashBackStatusTxtElement;
	}
	
	public void closeWebBtn() {
		WebElement closeWebBtnElement = driver.findElement(closeWebBtn);
		closeWebBtnElement.click();
	}
	
	public WebElement getConditionTxt() {
		WebElement conditionTxtElement = driver.findElement(conditionsTxt);
		return conditionTxtElement;
	}
	
	public WebElement getreviewTxt() {
		WebElement reviewTxtElement = driver.findElement(reviewTxt);
		return reviewTxtElement;
	}
	
	public void clickFavIcon() {
		WebElement favIconElement = driver.findElement(favIcon);
		favIconElement.click();
	}
	
	public void clickStoreBtn() {
		WebElement storeBtnElement = driver.findElement(storeBtn);
		storeBtnElement.click();
	}
	
}
