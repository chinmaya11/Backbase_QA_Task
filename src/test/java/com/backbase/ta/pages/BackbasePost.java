package com.backbase.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.backbase.ta.utils.WebDriverFactory;

public class BackbasePost extends WebDriverFactory{
	
	private final static By  userProfileName = By.xpath("//a[contains(text(),'chinmaya28')]");
	private final static By  posts = By.xpath("/html[1]/body[1]/app-root[1]/app-profile-page[1]/div[1]/div[2]/div[1]/div[1]/app-profile-articles[1]/app-article-list[1]/app-article-preview[1]");
	private final static By  writeComment = By.xpath("//textarea[@placeholder='Write a comment...']");
	private final static By  postCommentBtn = By.xpath("//button[contains(text(),'Post Comment')]");
	private final static By  newPostCommentField = By.xpath("//div[@class='card']//div[@class='card-block']");
	private final static By  newPostCommentText = By.xpath("//p[@class='card-text']");
	private final static By  deleteCommentBtn = By.xpath("//span[@class='mod-options']//i[@class='ion-trash-a']");
	

	
	public static void createPost(final String post) {
		try {
			WebDriverFactory.getDriver().findElement(userProfileName).click();
			WebDriverFactory.getDriver().findElement(posts).click();
			WebDriverFactory.getDriver().findElement(writeComment).sendKeys(post);
			WebDriverFactory.getDriver().findElement(postCommentBtn).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readPost(final String post) {
		try {
			WebDriverFactory.getDriver().findElement(newPostCommentField).isDisplayed();
			WebDriverFactory.getDriver().findElement(newPostCommentText).getText();
			Assert.assertEquals(WebDriverFactory.getDriver().findElement(newPostCommentText).getText(), post);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deletePost(final String post) {
		try {
			WebDriverFactory.getDriver().findElement(deleteCommentBtn).click();
			//Assert.assertEquals(WebDriverFactory.isDisplayed(dynamicxpathArticle), false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void noSuchElementException(final String post) {
		try {
			Assert.assertEquals(WebDriverFactory.noSuchElement(newPostCommentText), false);
			
		}
		catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		//return eleDisplay;
	}


	
	
	
	
	

}
