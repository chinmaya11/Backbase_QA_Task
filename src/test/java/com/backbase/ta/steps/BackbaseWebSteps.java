package com.backbase.ta.steps;

import com.backbase.ta.pages.BackbaseLoginPage;
import com.backbase.ta.pages.BackbasePost;
import com.backbase.ta.pages.BackbaseSettingsPage;

import java.util.List;

import com.backbase.ta.pages.BackbaseArticlePage;
import com.backbase.ta.pages.BackbaseHomepage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackbaseWebSteps {
	
	
	@Given("User opens backbase qa task website URL and then enter Username and Password")
	public void user_opens_backbase_qa_task_website_url_and_enter_username_and_password(DataTable dataTable) {
		List<String> data = dataTable.asList();
		BackbaseLoginPage.get(data.get(0)  , data.get(1), data.get(2));
	}
	
	@When("User verify title on task home page")
	public void user_verify_title_on_task_home_page() {
		BackbaseHomepage.verifyHomePageTitle();
	}

	@Given("User verify task home page logo")
	public void user_verify_task_home_page_logo() {
		BackbaseHomepage.verifyHomePageLogo();
	}

	@Then("User verify Home, Signin and signup link in header section")
	public void user_verify_Home_Signin_and_signup_link_in_header_section() {
		BackbaseHomepage.taskHomePageHeader();
	}

	@Then("User verify popular list of tags section")
	public void user_verify_popular_list_of_tags_section() {
		BackbaseHomepage.homePageTags();
	}

	@Then("User verify list of articles pulled from either Feed, Global, or by Tag")
	public void user_verify_list_of_articles_pulled_from_either_Feed_Global_or_by_Tag() {
		BackbaseHomepage.homePageFeed();
	}

	@Then("User verify pagination for list of articles")
	public void user_verify_pagination_for_list_of_articles() {
		BackbaseHomepage.articlePagination();
	}
	
	
	@Given("User verify Signup functionality")
	public void user_verify_Signup_functionality() {
		BackbaseHomepage.signupFunctionality();
	}

	@Then("User verify Signin functionality")
	public void user_verify_Signin_functionality() {
		BackbaseHomepage.signinFunctionality();
	}

	@When("User Signin with own credentials Email and password")
	public void user_Signin_with_own_credentials_Email_and_password(DataTable dataTable) {
		List<String> credentials = dataTable.asList();
		BackbaseHomepage.userSignin(credentials.get(0)  , credentials.get(1));
	}
	
	@Given("User Signin Functionality Email and password")
	public void user_signin_functionality(DataTable dataTable) {
		List<String> credentials = dataTable.asList();
		BackbaseHomepage.userSignin(credentials.get(0)  , credentials.get(1));
	}
	
	@Then("Verify user signin successfully")
	public void verify_user_Signin_successfully(DataTable dataTable) {
		List<String> profileName = dataTable.asList();
		BackbaseHomepage.signinSuccessful(profileName.get(0));
	}

	
	@When("User click on settings link")
	public void user_click_on_settings_link() {
		BackbaseSettingsPage.clickSettingsLink();
	}

	@When("Verify Your settings label displayed")
	public void verify_Your_settings_label_displayed() {
		BackbaseSettingsPage.verifyYourSettingLabel();
	}

	@Then("Verify URL, username, description, email, password text field")
	public void verify_URL_username_description_email_password_text_field() {
		BackbaseSettingsPage.verifySettingComponentTextField();
	}

	@Then("User verify update settings and logout button")
	public void user_verify_update_settings_and_logout_button() {
		BackbaseSettingsPage.verifySettingComponentBtn();
	}

	@Then("User logout from application")
	public void user_logout_from_application() {
		BackbaseSettingsPage.logoutFunc();
	}
	
	@Then("verify user successfully logout")
	public void verify_user_successfully_logout() {
		BackbaseSettingsPage.logoutFuncSuccess();
	}
	

	@Then("User create a new Article title {} about {} description {} tags {}")
	public void user_create_a_new_Article_title_about_description_tags(final String title, final String about, final String description, final String tag) {
		BackbaseArticlePage.createNewArticle(title, about, description, tag);
	}

	@When("User {} read the created article {} about {}")
	public void user_read_the_created_article_about(final String profileName, final String title, final String about) {
		BackbaseArticlePage.readArticle(profileName, title, about);
	}

	@Then("User {} update the article Title {}")
	public void user_update_the_article_Title(final String profileName, final String UpdateTitle) {
		BackbaseArticlePage.editArticle(profileName, UpdateTitle);
	}

	@Then("User {} delete the Article {}")
	public void user_delete_the_Article(final String profileName, final String UpdateTitle) {
		BackbaseArticlePage.deleteArticle(profileName, UpdateTitle);
	}
	
	@When("User created a post {} on Article")
	public void User_created_a_post_on_Article(final String post) {
		BackbasePost.createPost(post);
	}
	
	@Then("User read the post {}")
	public void User_read_a_post_on_Article(final String post) {
		BackbasePost.readPost(post);
	}
	
	@Then("User Delete the post {}")
	public void User_delete_post_on_Article(final String post) {
		BackbasePost.deletePost(post);
	}
	

	

}
