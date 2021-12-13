package com.backbase.ta.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.backbase.ta.utils.RestAssuredFactory;



public class BackBaseSteps {
	
	private String username = "candidatex";
	private String password = "qa-is-cool";
	
	RequestSpecification request;
	Response response;
	

	@Given("User authenticates the API request with USERNAME and PASSWORD")
	public void user_authenticates_the_API_request() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON);
                
		response = request.get();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@When("User create a new article")
	public void user_create_a_new_article() {
		RestAssuredFactory.createNewArticle();
	}
	
	@Then("User read the new article")
	public void user_read_the_new_article() {
		RestAssuredFactory.readArticle();
	}
	
	@When("User update the new article")
	public void User_update_the_new_article() {
		RestAssuredFactory.updateArticle();
	}
	
	@Then("User delete the new article")
	public void User_delete_the_new_article() {
		RestAssuredFactory.deleteArticle();
	}


	@Then("User add comments to an article")
	public void user_add_comments_to_an_article() {
		RestAssuredFactory.addComment();
	}

	@Then("User read comments from an article")
	public void user_read_comments_from_an_article() {
		RestAssuredFactory.readComment();
	}

	@Then("User delete comments for an article")
	public void user_delete_comments_for_an_article() {
		RestAssuredFactory.deleteComment();
	}
	
	
	@Then("User opted for favourite article")
	public void User_opted_for_favourite_article() {
		RestAssuredFactory.favouriteArticle();
	}
	
	@Then("User opted for unfavourite article")
	public void User_opted_for_unfavourite_article() {
		RestAssuredFactory.unfavouriteArticle();
	}
	
	
	
	@Given("Get User Profile")
	public void get_User_Profile() {
		RestAssuredFactory.getUserProfile();
	}

	@Then("Follow User")
	public void follow_User() {
		RestAssuredFactory.followUserProfile();
	}

	@Then("Unfollow User")
	public void unfollow_User() {
		RestAssuredFactory.unFollowUserProfile();
	}


}
