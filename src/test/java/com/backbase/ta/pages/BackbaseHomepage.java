package com.backbase.ta.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import com.backbase.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */
public class BackbaseHomepage extends WebDriverFactory {

	private static String current_URL;
	
	
	private final static  By  home_Link = By.xpath("//a[contains(text(),'Home')]");
	private final static By  signIn_Link = By.xpath("//a[contains(text(),'Sign in')]");
	private final static By  signUp_Link = By.xpath("//a[contains(text(),'Sign up')]");

	private final static By  signIn_Email = By.xpath("//input[@placeholder='Email']");
	private final static By  signIn_Password = By.xpath("//input[@placeholder='Password']");
	private final static By  signIn_btn = By.xpath("//button[contains(text(),'Sign in')]");
	private final static By  userProfileName = By.xpath("//a[contains(text(),'chinmaya28')]");
	private final static By  logo = By.xpath("//a[@class='navbar-brand']");
	private final static By  tags = By.xpath("//p[contains(text(),'Popular Tags')]");
	private final static By  globalFeed = By.xpath("//a[contains(text(),'Global Feed')]");
	private final static By  yourFeed = By.xpath("//a[contains(text(),'Your Feed')]");
	private final static By  articlePagination = By.xpath("//ul[@class='pagination']");
	
	private final static By  signupLabel = By.xpath("//h1[contains(text(),'Sign up')]");
	private final static By  usernameField = By.xpath("//input[@placeholder='Username']");
	private final static By  emailField = By.xpath("//input[@placeholder='Email']");
	private final static By  passworrdField = By.xpath("//input[@placeholder='Password']");
	private final static By  signupBtn = By.xpath("//button[contains(text(),'Sign up')]");
	
	private final static By  signinLabel = By.xpath("//h1[contains(text(),'Sign in')]");
	private final static By  settingsLink = By.xpath("//a[@href='/settings']");
	private final static By  logoutBtn = By.xpath("//button[contains(text(),'Or click here to logout.')]");

	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void verifyHomePageTitle() {
		try {
			Assert.assertEquals(WebDriverFactory.getDriver().getTitle(), "Conduit");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void verifyHomePageLogo() {
		try {
			Assert.assertEquals(WebDriverFactory.verifyText(logo), "conduit");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void taskHomePageHeader() {
		try {
			Assert.assertEquals(WebDriverFactory.verifyText(home_Link), "Home");
			Assert.assertEquals(WebDriverFactory.verifyText(signIn_Link), "Sign in");
			Assert.assertEquals(WebDriverFactory.verifyText(signUp_Link), "Sign up");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void homePageTags() {
		try {
			Assert.assertEquals(WebDriverFactory.verifyText(tags), "Popular Tags");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void homePageFeed() {
		try {
			Assert.assertEquals(WebDriverFactory.verifyText(globalFeed), "Global Feed");
			Assert.assertEquals(WebDriverFactory.verifyText(yourFeed), "Your Feed");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void articlePagination() {
		try {
			Assert.assertEquals(WebDriverFactory.isDisplayed(articlePagination), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void signupFunctionality() {
		try {
			WebDriverFactory.getDriver().findElement(signUp_Link).click();
			Assert.assertEquals(WebDriverFactory.verifyText(signupLabel), "Sign up");
			Assert.assertEquals(WebDriverFactory.isDisplayed(usernameField), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(emailField), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(passworrdField), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signupBtn), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void logoutFunc() {
		try {
			WebDriverFactory.getDriver().findElement(settingsLink).click();
			WebDriverFactory.getDriver().findElement(logoutBtn).click();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void signinFunctionality() {
		try {
			WebDriverFactory.getDriver().findElement(signIn_Link).click();			
			Assert.assertEquals(WebDriverFactory.verifyText(signinLabel), "Sign in");
			Assert.assertEquals(WebDriverFactory.isDisplayed(signIn_Email), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signIn_Password), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signIn_btn), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void taskHomePage() {
		try {
			Assert.assertEquals(WebDriverFactory.isDisplayed(home_Link), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signIn_Link), true);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signUp_Link), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void userSignin(final String email, final String pwd) {
		try {
			WebDriverFactory.getDriver().findElement(signIn_Link).click();
			WebDriverFactory.getDriver().findElement(signIn_Email).sendKeys(email);
			WebDriverFactory.getDriver().findElement(signIn_Password).sendKeys(pwd);
			WebDriverFactory.getDriver().findElement(signIn_btn).click();
			Assert.assertEquals(WebDriverFactory.getDriver().findElement(userProfileName).getText(), "chinmaya28");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void signinSuccessful(final String profileName) {
		try {
			Assert.assertEquals(WebDriverFactory.getDriver().findElement(userProfileName).getText(), profileName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Navigate to Backbase QA task Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public void navigateToURL(final String url) throws InterruptedException {
		try {
			current_URL = WebDriverFactory.getDriver().getCurrentUrl();
			WebDriverFactory.getDriver().get(current_URL + "c" + url);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}




}
