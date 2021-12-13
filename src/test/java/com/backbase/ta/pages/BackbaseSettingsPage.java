package com.backbase.ta.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.backbase.ta.utils.WebDriverFactory;

public class BackbaseSettingsPage extends WebDriverFactory{

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
	private final static By  yourSetingsLabel = By.xpath("//h1[contains(text(),'Your Settings')]");
	private final static By  urlProfilePic = By.xpath("//input[@placeholder='URL of profile picture']");
	private final static By  userNameTextField = By.xpath("//input[@placeholder='Username']");
	private final static By  bioTextField = By.xpath("//textarea[@placeholder='Short bio about you']");
	private final static By  emailTextField = By.xpath("//input[@placeholder='Email']");
	private final static By  newPasswordTextField = By.xpath("//input[@placeholder='New Password']");
	private final static By  updateSettingBtn = By.xpath("//button[normalize-space()='Update Settings']");
	
	
	
	
	
	
	
	//button[normalize-space()='Update Settings']
	
	/**
	 * Opens BackBase Login for given country.
	 * 
	 * @param url
	 *            {@link URL} https://qa-task.backbasecloud.com
	 */
	public static void clickSettingsLink() {
		try {			
			WebDriverFactory.getDriver().findElement(settingsLink).click();
		}
		catch (Exception e) {
			e.getMessage();
		}
}
	

	public static void verifyYourSettingLabel() {
		try {			
			Assert.assertEquals(WebDriverFactory.verifyText(yourSetingsLabel), "Your Settings");
		}
		catch (Exception e) {
			e.getMessage();
		}
}
	
	public static void verifySettingComponentTextField() {
		try {			
			Assert.assertEquals(WebDriverFactory.isEnable(urlProfilePic), true);
			Assert.assertEquals(WebDriverFactory.isEnable(userNameTextField), true);
			Assert.assertEquals(WebDriverFactory.isEnable(bioTextField), true);
			Assert.assertEquals(WebDriverFactory.isEnable(emailTextField), true);
			Assert.assertEquals(WebDriverFactory.isEnable(newPasswordTextField), true);
		}
		catch (Exception e) {
			e.getMessage();
		}
}
	
	
	
	public static void verifySettingComponentBtn() {
		try {			
			Assert.assertEquals(WebDriverFactory.isEnable(updateSettingBtn), true);
			Assert.assertEquals(WebDriverFactory.isEnable(logoutBtn), true);
		}
		catch (Exception e) {
			e.getMessage();
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
	public static void logoutFuncSuccess() {
		try {
			Assert.assertEquals(WebDriverFactory.noSuchElement(logoutBtn), false);
			Assert.assertEquals(WebDriverFactory.isDisplayed(signIn_Link), true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
