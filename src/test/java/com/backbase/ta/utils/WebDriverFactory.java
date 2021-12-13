package com.backbase.ta.utils;

import java.awt.Toolkit;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Provides methods for managing the {@link WebDriver} instances.
 */
public class WebDriverFactory {

	private static final Integer IMPLICITLY_WAIT_TIME = 10;
	private static final Integer SCRIPT_LOAD_TIME = 15;
	private static final Integer PAGE_LOAD_TIME = 60;
	private static final Integer DEFAULT_WEBDRIVER_WAIT_TIME = 10;
	private static WebDriverWait wait;
	private static WebElement element;
	private static boolean eleDisplay;
	private static String actualText;
	private static ThreadLocal<WebDriver> webDrivers = new ThreadLocal<>();
	static HashSet<String> performanceSet=new HashSet<String>();

	/**
	 * Prevent from initialization of the WebDriverFactory
	 */	
	public WebDriverFactory() {
		
	}

	/**
	 * Initializes {@link ChromeDriver} for current thread.
	 */
	public static void initialize(String runMode) {
		BrowserTypes browser=BrowserTypes.CHROME;
		switch(browser) {
		case CHROME: {
			WebDriverManager.chromedriver().setup();
			final ChromeOptions options = new ChromeOptions();
			if (runMode!= null) {
				options.addArguments(runMode);
				options.addArguments("window-size=1400,800");
			}
			final WebDriver webDriver = new ChromeDriver(options);
			webDrivers.set(webDriver);
			setupBrowser(webDriver);
			setupWaits(webDriver);
			break;
		}
		case FIREFOX: {
			WebDriverManager.firefoxdriver().setup();
			break;
		}
		}
	}
	
		


	/**
	 * Retrieves an instance of {@link WebDriver} for current thread. May return {@code null} in case the
	 * {@link WebDriverFactory#initialize()} method is not called before for the current thread.
	 * 
	 * @return WebDriver instance {@link WebDriver}
	 */
	public static WebDriver getDriver() {
		return webDrivers.get();
	}



	/**
	 * Retrieves an instance of {@link WebDriver} for current thread. May return {@code null} in case the
	 * {@link WebDriverFactory#initialize()} method is not called before for the current thread.
	 * 
	 * @return WebDriver instance {@link WebDriver}
	 */
	public static WebDriver driverNavigateTo() {
		return webDrivers.get();
	}

	public static boolean isDisplayed(final By locator) {
		try {
			eleDisplay = WebDriverFactory.getDriver().findElement(locator).isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return eleDisplay;
	}
	
	public static boolean noSuchElement(final By locator) {
		try {
			eleDisplay = WebDriverFactory.getDriver().findElement(locator).isDisplayed();
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
		//return eleDisplay;
	}
	
	
	/**
	 * Retrieves an instance of {@link WebDriver} for current thread. May return {@code null} in case the
	 * {@link WebDriverFactory#initialize()} method is not called before for the current thread.
	 * 
	 * @return WebDriver instance {@link WebDriver}
	 */
	public static boolean isEnable(final By locator) {
		try {
			eleDisplay = WebDriverFactory.getDriver().findElement(locator).isEnabled();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return eleDisplay;
	}
	
	
	
	public static String verifyText(final By locator) {
		try {
			actualText = WebDriverFactory.getDriver().findElement(locator).getText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return actualText;
	}
	
	

	/**
	 * Wait for the element to be clickable
	 * 
	 * Click on the element using javascript executor
	 * 
	 */
	public static void driverClickJSE(By performanceType) {
		try {
			wait = WebDriverFactory.getWebDriverWait();
			element = wait.until(ExpectedConditions.elementToBeClickable(performanceType));
			((JavascriptExecutor)WebDriverFactory.getDriver()).executeScript("arguments[0].click();", element);
			//Thread.sleep(1000);
		}
		catch (final TimeoutException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	/**
	 * Wait for the element to be located and displayed in the DOM
	 * 
	 */
	public static boolean waitUntilLocatorDLocated(By performanceType) {
		try {
			final WebElement uiLocator = WebDriverFactory.getWebDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(performanceType));
			return uiLocator.isDisplayed();
		} catch (final TimeoutException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	
	/**
	 * Function for handling stale element.
	 */
	public static void waitForProductNavigationToAppear(By locator) {
		try {
		new WebDriverWait(webDrivers.get(), 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	} catch(StaleElementReferenceException ex)
		{
		new WebDriverWait(webDrivers.get(), 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
	}
		
	
	/**
	 * Function for handling stale element to be displayed in DOM.
	 */
	public static boolean waitUntilLocatorDisplayedStaleElement(By performanceType) {
		for (int retry = 0; retry <20; retry++) {
		try {
			final WebElement uiLocator = WebDriverFactory.getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable(performanceType));
			return uiLocator.isDisplayed();	
			}
		 catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
		}
		return false;
	}
	

	/**
	 * Quits driver for current thread, if present.
	 */
	public static void quitCurrentDriver() {
		final WebDriver webDriver = webDrivers.get();
		if (webDriver != null) {
			webDriver.quit();
			webDrivers.remove();
		}
	}

	/**
	 * Gets default {@link WebDriverWait} instance with default wait of 10 seconds and 50 milliseconds retry interval.
	 * 
	 * @return {@link WebDriverWait}
	 */
	public static WebDriverWait getWebDriverWait() {
		return getWebDriverWait(5);
	}

	/**
	 * Gets customized {@link WebDriverWait} instance. The default retry interval is 50 milliseconds
	 * 
	 * @param seconds
	 *            wait time in seconds
	 * @return {@link WebDriverWait}
	 */
	public static WebDriverWait getWebDriverWait(final int seconds) {
		final int wait = seconds > 0 ? seconds : DEFAULT_WEBDRIVER_WAIT_TIME;
		return new WebDriverWait(webDrivers.get(), wait, 50);
	}

	private static void setupBrowser(final WebDriver webDriver) {

		final Dimension screenResolution = getScreenResolution();
		final Dimension targetResolution = new Dimension(1920, 1080);
		final OSEnum os = OSEnum.getOS();

		switch (os) {
		case MACOS:
			if (screenResolution.getWidth() > targetResolution.getWidth()) {
				webDriver.manage().window().setSize(targetResolution);
			} else {
				webDriver.manage().window().setSize(screenResolution);
			}
			break;
		case WINDOWS:
			if (screenResolution.getWidth() > targetResolution.getWidth()) {
				webDriver.manage().window().setSize(targetResolution);
			} else {
				webDriver.manage().window().maximize();
			}
			break;
		default:
			throw new RuntimeException("Unsupported operating system: " + os);
		}

		webDriver.manage().deleteAllCookies();
	}

	private static void setupWaits(final WebDriver webDriver) {
		webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(SCRIPT_LOAD_TIME, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
	}

	private static Dimension getScreenResolution() {
		final java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width = (int) screenSize.getWidth();
		final int height = (int) screenSize.getHeight();
		return new Dimension(width, height);
	}
}
