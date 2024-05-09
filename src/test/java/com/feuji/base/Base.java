package com.feuji.base;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import com.feuji.context.Constants;
import com.feuji.context.WebDriverContext;
import com.feuji.utils.FileReader;
import com.feuji.utils.GetProperties;
import com.feuji.utils.LoggerUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Base class for setting up the test environment and providing common
 * functionalities.
 */
public class Base {
	public ChromiumDriver driver;
	public JSONObject uiData;
	public JSONObject mobileData;
	public SoftAssert softAssert;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public AppiumDriver appiumDriver;
	public DesiredCapabilities capabilities;

	/**
	 * Method to set up the UI test environment based on the specified browser or
	 * platform.
	 * 
	 * @param browser  The browser on which the test should run.
	 * @param platform The platform for mobile automation (optional).
	 * @throws Exception If an exception occurs during setup.
	 */
	@BeforeTest(groups = { "UIAutomation", "chrome", "edge" })
	@Parameters({ "browser", "platform" })
	public void setUpUI(@Optional String browser, @Optional String platform) throws Exception {
		LoggerUtil.log("Suite Setup started");
		try {
			if (browser != null) {
				if (browser.equalsIgnoreCase("chrome")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--headless");
					driver = new ChromeDriver(options);
					driver = new ChromeDriver();
					WebDriverContext.setDriver(driver);
				} else if (browser.equalsIgnoreCase("edge")) {
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--headless");
					driver = new EdgeDriver(options);
					WebDriverContext.setDriver(driver);
				}
				WebDriverContext.getDriver().manage().window().maximize();
				WebDriverContext.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				WebDriverContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				uiData = FileReader.getData(Constants.UI_JSON_DATA);
			} else if (platform != null) {
				mobileData = FileReader.getData(Constants.MOBILE_JSON_DATA);
				System.err.println(mobileData);
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						GetProperties.getProperty("platformName"));
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, GetProperties.getProperty("deviceName"));
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
						GetProperties.getProperty("automationName"));
				capabilities.setCapability(MobileCapabilityType.APP,
						System.getProperty("user.dir") + GetProperties.getProperty("appPath"));
				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
						GetProperties.getProperty("timeout"));
				capabilities.setCapability("appium:autoAcceptAlerts", GetProperties.getProperty("autoAcceptAlerts"));
				capabilities.setCapability("appium:noReset", GetProperties.getProperty("noReset"));
				capabilities.setCapability("appium:appPackage", GetProperties.getProperty("appPackage"));
				capabilities.setCapability("appium:appActivity", GetProperties.getProperty("appActivity"));
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						GetProperties.getProperty("platformVersion"));
				appiumDriver = new AndroidDriver(new URL(GetProperties.getProperty("appiumServerUrl")), capabilities);
				appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				WebDriverContext.setDriver(appiumDriver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger().fatal("Could not send mail : " + e.getMessage());
		}
	}

	/**
	 * Method to launch the URL before each test method execution.
	 * 
	 * @param browser  The browser on which the test should run.
	 * @param platform The platform for mobile automation (optional).
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "platform" })
	public void launchUrl(@Optional String browser, @Optional String platform) {
		LoggerUtil.log("URL Launch started");
		softAssert = new SoftAssert();
		try {
			if (browser != null && platform == null) {
				WebDriverContext.getDriver().get(GetProperties.getProperty("baseUrl"));
			}
		} catch (IllegalStateException illegalStateException) {
			LoggerUtil.log(illegalStateException.getMessage());
		}
	}

	/**
	 * Method to capture a screenshot during test execution.
	 * 
	 * @param testName      The name of the test method.
	 * @param directoryPath The directory path to save the screenshot.
	 * @param driver        The WebDriver instance.
	 * @return The path to the saved screenshot.
	 */
	public synchronized String captureScreenshot(String testName, String directoryPath, WebDriver driver) {
		LoggerUtil.log("Screenshot started");
//		String screenshotPath = null;
		String base64Screenshot = null;
//		LocalDateTime currentTime = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//		String formattedTime = currentTime.format(formatter);
		try {
//			RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
//			Capabilities capabilities = remoteDriver.getCapabilities();
//			String browserName = capabilities.getBrowserName();
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
			base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			ReportPortal.emitLog("Screenshot captured of "+ testName, LogLevel.INFO.name(), new Date(), screenshotFile);
//			File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
//			File directory = new File(directoryPath);
//			if (!directory.exists()) {
//				directory.mkdirs();
//			}
//			screenshotPath = directoryPath + "/" + testName + formattedTime + browserName + ".png";
//			System.err.println(screenshotPath);
//			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger().fatal("Could not send mail : " + e.getMessage());
		}
		return base64Screenshot;
	}

	/**
	 * Method to tear down the UI test environment after test execution.
	 */
	@AfterTest(groups = { "UIAutomation", "chrome", "edge" })
	public void tearDownUI() {
		LoggerUtil.log("tear started");
		try {
			WebDriverContext.getDriver().quit();
		} catch (IllegalStateException illegalStateException) {
			LoggerUtil.log(illegalStateException.getMessage());
		}
	}
}