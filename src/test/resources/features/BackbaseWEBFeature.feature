@Smoke
Feature: Sample feature to demonstrate the capabilities of this Web application


Background:
Given User opens backbase qa task website URL and then enter Username and Password
| https://qa-task.backbasecloud.com   | candidatex    | qa-is-cool   |
When User verify title on task home page


  Scenario: Verify HomePage Functionality
  
   Given User verify task home page logo
   Then User verify Home, Signin and signup link in header section
   Then User verify popular list of tags section
   Then User verify list of articles pulled from either Feed, Global, or by Tag
   Then User verify pagination for list of articles   

	Scenario: Verify HomePage Sign in/Sign up pages Functionality	
	
		Given User verify Signup functionality
		Then User verify Signin functionality
		When User Signin with own credentials Email and password
		|   chinmaya28@backbase.com   | chinmaya28  |
		Then Verify user signin successfully
		|chinmaya28  |
	
	Scenario: Verify Settings page and Logout functionality
	
		Given User Signin Functionality Email and password
		|   chinmaya28@backbase.com   | chinmaya28  |
		When User click on settings link
		When Verify Your settings label displayed
		Then Verify URL, username, description, email, password text field
		Then User verify update settings and logout button
		Then User logout from application	
		Then verify user successfully logout
	
	Scenario Outline: User Verify Editor page to create/read/edit/delete Articles and Post
	
		Given User Signin Functionality Email and password
		|   chinmaya28@backbase.com   | chinmaya28  |
		Then User create a new Article title <ArticleTitle> about <ArticleAbout> description <ArticleDesc> tags <Tags>
  	When User <ProfileName> read the created article <ArticleTitle> about <ArticleAbout>
  	Then User <ProfileName> update the article Title <UpdateTitle>
 		Then User <ProfileName> delete the Article <UpdateTitle>
 		  
  	When User created a post <Post> on Article
  	Then User read the post <Post>
  	Then User Delete the post <Post>
  	Then User logout from application
  	  
  Examples:
 | ArticleTitle    	    | ArticleAbout 	   |   ArticleDesc         |   Tags   | Comment   | UpdateTitle |   Post        |
 | Test Web Automation  | Automation       |Automation is cool     |  api     | ok        | Updated     |  My New Post  |