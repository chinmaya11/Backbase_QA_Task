package com.backbase.ta.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.backbase.ta.utils.WebDriverFactory;

public class BackbaseArticlePage extends WebDriverFactory {
	
	private final static By  userProfileName = By.xpath("//a[contains(text(),'chinmaya28')]");	
	private final static By  newArticleLink = By.xpath("//app-layout-header/nav[1]/div[1]/ul[1]/li[2]/a[1]");
	private final static By  titleField = By.xpath("//input[@formcontrolname='title']");
	private final static By  titleDescriptionField = By.xpath("//input[@formcontrolname='description']");
	private final static By  titleBodyField = By.xpath("//textarea[@formcontrolname='body']");
	private final static By  titleTagsField = By.xpath("//input[@placeholder='Enter tags']");
	private final static By  publishArticleBtn = By.xpath("//button[contains(text(),'Publish Article')]");
	private final static By  newArticleTitleCreated = By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/h1");	
	private final static By  homeLink = By.xpath("//a[contains(text(),'Home')]");
	private final static By  globalFeed = By.xpath("//a[contains(text(),'Global Feed')]");
	private static String relXpath=null;
	private final static By  editArticle = By.xpath("//body/app-root[1]/app-article-page[1]/div[1]/div[2]/div[2]/app-article-meta[1]/div[1]/span[1]/a[1]");
	private final static By  deleteArticle = By.xpath("//body/app-root[1]/app-article-page[1]/div[1]/div[1]/div[1]/app-article-meta[1]/div[1]/span[1]/button[1]");
	
	
	
	
	

	/**
	 * Navigate to Hilti Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void verifyUserLandingPage(final String profileName) {
		try {
			Assert.assertEquals(WebDriverFactory.verifyText(userProfileName), profileName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Navigate to Hilti Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public static void createNewArticle(final String title, final String about, final String description, final String tag) {
		try {
			WebDriverFactory.getDriver().findElement(newArticleLink).click();
			WebDriverFactory.getDriver().findElement(titleField).sendKeys(title);
			WebDriverFactory.getDriver().findElement(titleDescriptionField).sendKeys(about);
			WebDriverFactory.getDriver().findElement(titleBodyField).sendKeys(description);
			WebDriverFactory.getDriver().findElement(titleTagsField).sendKeys(tag);
			WebDriverFactory.getDriver().findElement(publishArticleBtn).click();
			Assert.assertEquals(WebDriverFactory.verifyText(newArticleTitleCreated), title);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void readArticle(final String profileName, final String title, final String about) {
		try {
			relXpath=title;
			By  dynamicxpathArticle = By.xpath("//a[@class='preview-link']/h1[contains(text(),'"+relXpath+"')]");
			WebDriverFactory.getDriver().findElement(homeLink).click();
			WebDriverFactory.getDriver().findElement(globalFeed).click();
			Assert.assertEquals(WebDriverFactory.verifyText(dynamicxpathArticle), title);
			WebDriverFactory.getDriver().findElement(dynamicxpathArticle).click();
			Assert.assertEquals(WebDriverFactory.verifyText(newArticleTitleCreated), title);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void editArticle(final String profileName, final String UpdateTitle) {
		try {

			WebDriverFactory.getDriver().findElement(editArticle).click();
			WebDriverFactory.getDriver().findElement(titleField).clear();
			WebDriverFactory.getDriver().findElement(titleField).sendKeys(UpdateTitle);
			WebDriverFactory.getDriver().findElement(publishArticleBtn).click();
			Assert.assertEquals(WebDriverFactory.verifyText(newArticleTitleCreated), UpdateTitle);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void deleteArticle(final String profileName, final String UpdateTitle) {
		try {
			WebDriverFactory.getDriver().findElement(deleteArticle).click();
			WebDriverFactory.getDriver().findElement(userProfileName).click();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
