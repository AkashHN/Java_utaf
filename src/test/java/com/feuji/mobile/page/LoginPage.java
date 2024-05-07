package com.feuji.mobile.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.feuji.page.BasePage;

public class LoginPage extends BasePage  {

	private final By logInTitle = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/screen_title']");
	private final By usernameField = By.xpath("//android.widget.EditText[@resource-id='com.letyshops:id/login_screen_email']");
	private final By passwordField = By.xpath("//android.widget.EditText[@resource-id='com.letyshops:id/login_screen_password']");
	private final By loginButton = By.xpath("//android.widget.Button[@resource-id='com.letyshops:id/login_screen_button_enter']");
	private final By inputTextError = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/textinput_error']");
	private final By forgotPassword = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/forgot_pass']");
	private final By navigateButton = By.xpath("//android.view.ViewGroup[@resource-id='com.letyshops:id/toolbar']/android.widget.ImageButton");
	private final By passwordRecoveryTitle = By.xpath("//android.widget.TextView[@resource-id='com.letyshops:id/toolbar_title']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterLoginCredentials(String username, String password) {
		WebElement usernameInput = driver.findElement(usernameField);
		usernameInput.sendKeys(username);
		WebElement passwordInput = driver.findElement(passwordField);
		passwordInput.sendKeys(password);
		clickLoginButton();
	}
	
	public void clickLoginButton() {
		WebElement loginBtn = driver.findElement(loginButton);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginBtn.click();
	}
	
	public WebElement getLogInTitle() {
		WebElement titleLogIn = driver.findElement(logInTitle);
		return titleLogIn;
	}
	
	public WebElement getErrorMessage() {
		WebElement  errorMessage = driver.findElement(inputTextError);
		return errorMessage;
	}
	
	public void clickNavigateButton() {
		WebElement navigateBtn = driver.findElement(navigateButton);
		navigateBtn.click();
	}
	
	public WebElement getForgotPassword() {
		WebElement forgotPasswordText = driver.findElement(forgotPassword);
		return forgotPasswordText;
	}
	
	public void clickForgotPassword() {
		WebElement forgotPasswordText = driver.findElement(forgotPassword);
		forgotPasswordText.click();
	}
	
	public WebElement getTitlePasswordRecovery() {
		WebElement  title= driver.findElement(passwordRecoveryTitle);
		return title;
	}

}
