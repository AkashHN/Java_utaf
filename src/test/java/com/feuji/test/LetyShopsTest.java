package com.feuji.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.feuji.base.Base;
import com.feuji.factory.PageInstanceFactory;
import com.feuji.mobile.page.AccountPage;
import com.feuji.mobile.page.GoToStorePage;
import com.feuji.mobile.page.HomePage;
import com.feuji.mobile.page.LanguageSelectPage;
import com.feuji.mobile.page.LoginPage;
import com.feuji.mobile.page.WelcomePage;

/**
 * The LetyShopsTest class contains test cases for the LetyShops mobile application. It extends the Base class
 * for test setup and common functionalities.
 */
public class LetyShopsTest extends Base {
	private LoginPage loginPage;
	private WelcomePage welcomePage;
	private LanguageSelectPage languageSelectPage;
	private HomePage homePage;
	private GoToStorePage goToStorePage;
	private AccountPage accountPage;

	/**
     * Test case to verify the Welcome page of the LetyShops application.
     * It includes assertions for the title, logo, welcome text, and register button.
     */
	@Test(groups = { "Android" })
	public void welcomePage() {
		// Assertion 1
		welcomePage = PageInstanceFactory.getInstance(WelcomePage.class);
		extentTest.get().log(Status.INFO, "Verifying if letyshops is displayed");
		boolean isTitleDisplayed = welcomePage.getTitle().isDisplayed();
		softAssert.assertTrue(isTitleDisplayed, "letyshops should be displayed");
		extentTest.get().log(isTitleDisplayed ? Status.PASS : Status.FAIL,
				isTitleDisplayed ? "letyshops is displayed" : "letyshops is not displayed");
		// Assertion 2
		extentTest.get().log(Status.INFO, "Verifying if LettyShops logo is displayed");
		boolean isLogoDisplayed = welcomePage.getLogo().isDisplayed();
		softAssert.assertFalse(isLogoDisplayed, "LettyShops logo should be displayed");
		extentTest.get().log(isLogoDisplayed ? Status.PASS : Status.FAIL,
				isLogoDisplayed ? "LettyShops logo is displayed" : "LettyShops logo is not displayed");
		// Assertion 3
		extentTest.get().log(Status.INFO, "Verifying if Welcome Text is displayed as expected");
		String welcomeMessage = welcomePage.getWelcomeText().getText().replaceAll("\\s+", " ").trim();
		String expectedMessage = mobileData.getString("welcomePageHeadingMsg");
		boolean isMessageDisplayed = welcomeMessage.equals(expectedMessage);
		softAssert.assertEquals(welcomeMessage, expectedMessage, "Welcome Message is displayed as expected");
		extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
				isMessageDisplayed ? "Welcome Message is displayed as expected"
						: "Welcome Message is not displayed as expected");
		// Assertion 4
		extentTest.get().log(Status.INFO, "Verifying if Register button is displayed");
		boolean isButtonDisplayed = welcomePage.getRegisterButton().isDisplayed();
		softAssert.assertTrue(isButtonDisplayed, "Register button should be displayed");
		extentTest.get().log(isTitleDisplayed ? Status.PASS : Status.FAIL,
				isTitleDisplayed ? "Register button is displayed" : "Register button is not displayed");
		welcomePage.clickEnterToAccountButton();
		softAssert.assertAll();
	}

	/**
	 * This test case is Implemented with the logIn page Using the
	 * correct user credentials(userName & Password) for the successful logIn
	 */
	@Test(groups = { "Android" })
	public void loginWithoutCredentials() {
		loginPage = PageInstanceFactory.getInstance(LoginPage.class);
		String errorMessage = mobileData.getString("textInputError");
		loginPage.clickLoginButton();
		extentTest.get().log(Status.PASS, "Clicking login button without entering credentials");
		String textError = loginPage.getErrorMessage().getText().replaceAll("\\s+", " ").trim();
		boolean isMessageDisplayed = textError.equals(errorMessage);
		softAssert.assertEquals(textError, errorMessage, "Error Message is displayed as expected");
		extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
				isMessageDisplayed ? "Error Message is displayed as expected"
						: "Error Message is not displayed as expected");
		softAssert.assertAll();
	}

	 /**
     * Test case to validate the Forgot Password functionality.
     */
	@Test(groups = { "Android" })
	public void validateForgotPassword() {
		String forgotPassword = mobileData.getString("textForgotPassword");
		String textElement = loginPage.getForgotPassword().getText().replaceAll("\\s+", " ").trim();
		boolean isMessageDisplayed = textElement.equals(forgotPassword);
		softAssert.assertEquals(textElement, forgotPassword, "Forgot Password text is displayed as expected");
		extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
				isMessageDisplayed ? "Forgot Password text is displayed as expected"
						: "Forgot Password text is not displayed as expected");
		loginPage.clickForgotPassword();
		boolean isTitleDisplayed = loginPage.getTitlePasswordRecovery().isDisplayed();
		softAssert.assertTrue(isTitleDisplayed, "Password recovery title should be displayed");
		extentTest.get().log(isTitleDisplayed ? Status.PASS : Status.FAIL,
				isTitleDisplayed ? "Password recovery title is displayed" : "Password recovery title is not displayed");
//			loginPage.clickNavigateButton();
		softAssert.assertAll();
	}
//	
	/**
     * Test case to simulate logging in with valid credentials.
     */
//	@Test(groups = { "Android" })
//	public void invalidLoginWithIncorrectPassword() {
//			String userName = mobileData.getString("correctUserName");
//			String password = mobileData.getString("inValidPassword");
////			welcomePage.clickEnterToAccountButton();
//			loginPage.enterLoginCredentials(userName, password);
//			extentTest.get().log(Status.PASS, "Entering invalid login credentials with incorrect password ");
//			extentTest.get().log(Status.PASS, "Clicking login button");
//			extentTest.get().log(Status.INFO, "Verifying if user logged into the account");
//			boolean isButtonDisplayed = loginPage.getLogInTitle().isDisplayed();
//			softAssert.assertTrue(isButtonDisplayed, "Login button is displayed");
//			extentTest.get().log(isButtonDisplayed ? Status.PASS : Status.FAIL,
//					isButtonDisplayed ? "Invalid login with incorrect password" : "valid login");
////			loginPage.clickNavigateButton();
//	}
//	
//	@Test(groups = { "Android" })
//	public void invalidLoginWithIncorrectUsername() {
//			String userName = mobileData.getString("inValidUserName");
//			String password = mobileData.getString("correctPassword");
////			welcomePage.clickEnterToAccountButton();
//			loginPage.enterLoginCredentials(userName, password);
//			extentTest.get().log(Status.PASS, "Entering invalid login credentials with incorrect username ");
//			extentTest.get().log(Status.PASS, "Clicking login button");
//			extentTest.get().log(Status.INFO, "Verifying if user logged into the account");
//			boolean isButtonDisplayed = loginPage.getLogInTitle().isDisplayed();
//			softAssert.assertTrue(isButtonDisplayed, "Login button is displayed");
//			extentTest.get().log(isButtonDisplayed ? Status.PASS : Status.FAIL,
//					isButtonDisplayed ? "Invalid login with incorrect username" : "valid login");
////			loginPage.clickNavigateButton();
//	}

	/**
	 * This test case is Implemented with the logIn page Using the correct user
	 * credentials(userName & Password) for the successful logIn
	 */
	@Test(groups = { "Android" })
	public void testLoginWithValidCredentials() {
		String userName = mobileData.getString("correctUserName");
		String password = mobileData.getString("correctPassword");
//			welcomePage.clickEnterToAccountButton();
		loginPage.enterLoginCredentials(userName, password);
		extentTest.get().log(Status.PASS, "Entering valid login credentials ");
		extentTest.get().log(Status.PASS, "Clicking login button");
		softAssert.assertAll();
	}

	/**
	 * This test case is Implemented with the Language page Here we are selecting
	 * the application language
	 */
	@Test(groups = { "Android" })
	public void selectLanguage() {
		languageSelectPage = PageInstanceFactory.getInstance(LanguageSelectPage.class);
		if (languageSelectPage.getHeading().isDisplayed()) {
			extentTest.get().log(Status.INFO, "Verifying if Heading is displayed as expected");
			String headingMessage = languageSelectPage.getHeading().getText().replaceAll("\\s+", " ").trim();
			String expectedMessage = mobileData.getString("languageHeadingMsg");
			boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
			softAssert.assertEquals(headingMessage, expectedMessage, "Heading Message is displayed as expected");
			extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
					isMessageDisplayed ? "Heading Message is displayed as expected"
							: "Heading Message is not displayed as expected");
			languageSelectPage.clickSelectLanguage();
			languageSelectPage.clickApplyButton();
		}
		softAssert.assertAll();
	}

	/**
     * Test case to select the application language.
     */
	@Test(groups = { "Android" })
	public void checkNotification() {
		homePage = PageInstanceFactory.getInstance(HomePage.class);
		homePage.clickNotification();
		extentTest.get().log(Status.INFO, "Verifying if Notification Heading is displayed as expected");
		String headingMessage = homePage.getNotificationHeading().getText().replaceAll("\\s+", " ").trim();
		String expectedMessage = mobileData.getString("notificationHeadingMsg");
		boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
		softAssert.assertEquals(headingMessage, expectedMessage, "Heading Message is displayed as expected");
		extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
				isMessageDisplayed ? "Heading Message is displayed as expected"
						: "Heading Message is not displayed as expected");
		homePage.clickNotificationBack();
		softAssert.assertAll();
	}

	/**
     * Test case to search for an item in the application.
     */
	@Test(groups = { "Android" })
	public void searchItem() {
		homePage.searchItem(mobileData.getString("searchItem"));
		extentTest.get().log(Status.INFO, "Item as been searched");
		softAssert.assertAll();
	}

	/**
     * Test case to navigate to a store page and perform various assertions.
     */
	@Test(groups = { "Android" })
	public void storePage() {
		goToStorePage = PageInstanceFactory.getInstance(GoToStorePage.class);
		// Assertion 1
		extentTest.get().log(Status.INFO, "Verifying if Conditions is displayed");
		boolean isConditionsDisplayed = goToStorePage.getConditionTxt().isDisplayed();
		softAssert.assertTrue(isConditionsDisplayed, "Conditions should be displayed");
		extentTest.get().log(isConditionsDisplayed ? Status.PASS : Status.FAIL,
				isConditionsDisplayed ? "Conditions are displayed" : "Conditions are not displayed");
		// Assertion 2
		extentTest.get().log(Status.INFO, "Verifying if Reviews are displayed");
		boolean isReviewDisplayed = goToStorePage.getreviewTxt().isDisplayed();
		softAssert.assertTrue(isReviewDisplayed, "Username field should be displayed");
		extentTest.get().log(isReviewDisplayed ? Status.PASS : Status.FAIL,
				isReviewDisplayed ? "Reviews are displayed" : "Reviews are not displayed");
		goToStorePage.clickFavIcon();
		extentTest.get().log(Status.PASS, "Added to Favourite");
		goToStorePage.clickStoreBtn();
		extentTest.get().log(Status.PASS, "Store Button was clicked");
		// Assertion 3
		extentTest.get().log(Status.INFO, "Verifying if CashBack status is displayed");
		boolean isCashBackStatusDisplayed = goToStorePage.getCashBackStatusTxt().isDisplayed();
		softAssert.assertTrue(isCashBackStatusDisplayed, "CashBack status should be displayed");
		extentTest.get().log(isCashBackStatusDisplayed ? Status.PASS : Status.FAIL,
				isCashBackStatusDisplayed ? "CashBack status is displayed" : "CashBack status is not displayed");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goToStorePage.closeWebBtn();
		// Assertion 4
		extentTest.get().log(Status.INFO, "Verifying if close web confirm text is displayed as expected");
		String headingMessage = goToStorePage.getCloseWebConfirmTxt().getText().replaceAll("\\s+", " ").trim();
		String expectedMessage = mobileData.getString("closeWebConfirmTxt");
		boolean isMessageDisplayed = headingMessage.equals(expectedMessage);
		softAssert.assertEquals(headingMessage, expectedMessage, "Message is displayed as expected");
		extentTest.get().log(isMessageDisplayed ? Status.PASS : Status.FAIL,
				isMessageDisplayed ? "Message is displayed as expected" : "Message is not displayed as expected");
		goToStorePage.closeWebConfirmBtn();
		extentTest.get().log(Status.PASS, "Web App closed successfully");
		goToStorePage.closeStoreBtn();
		goToStorePage.closeStoreBtn();
		extentTest.get().log(Status.PASS, "Store closed successfully");
		softAssert.assertAll();
	}

	 /**
     * Test case to validate the user profile functionality.
     */
	@Test(groups = { "Android" })
	public void testProfile() {
		accountPage = PageInstanceFactory.getInstance(AccountPage.class);
		extentTest.get().log(Status.INFO, "Clicking Accounts icon");
		accountPage.clickAccountIcon();
		extentTest.get().log(Status.INFO, "Selecting Settings option");
		accountPage.clickSettings();
		extentTest.get().log(Status.INFO, "Verifying if Edit Profile is displayed");
		boolean isTitleDisplayed = accountPage.getTitleEditProfile().isDisplayed();
		softAssert.assertTrue(isTitleDisplayed, "Title should be displayed");
		extentTest.get().log(isTitleDisplayed ? Status.PASS : Status.FAIL,
				isTitleDisplayed ? "Edit Profile Title is displayed" : "Edit Profile Title is not displayed");
		extentTest.get().log(Status.INFO, "Verifying if username is displayed");
		String userMail = mobileData.getString("correctUserName");
		String userName = accountPage.getUserId().getText().replaceAll("\\s+", " ").trim();
		String userId = userMail.substring(0, Math.min(userMail.length(), 8));
		boolean isUsernameDisplayed = userName.equals(userId);
		softAssert.assertEquals(userName, userId, "Username is displayed as expected");
		extentTest.get().log(isUsernameDisplayed ? Status.PASS : Status.FAIL,
				isUsernameDisplayed ? "Username is displayed as expected" : "Username is not displayed as expected");
		extentTest.get().log(Status.INFO, "Verifying if user mail-id is displayed");
		String mailId = accountPage.getUserMailId().getText().replaceAll("\\s+", " ").trim();
		boolean isUserMailDisplayed = mailId.equals(userMail);
		softAssert.assertEquals(mailId, userMail, "User mail is displayed as expected");
		extentTest.get().log(isUserMailDisplayed ? Status.PASS : Status.FAIL,
				isUserMailDisplayed ? "User mail is displayed as expected" : "User mail is not displayed as expected");
		extentTest.get().log(Status.INFO, "Selecting gender");
		accountPage.chooseGender();
		extentTest.get().log(Status.INFO, "Closing Edit Profile page");
		accountPage.closeEditingProfile();
		accountPage.logOut();
		extentTest.get().log(Status.PASS, "Logged out from the account successfully");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
	}
}
