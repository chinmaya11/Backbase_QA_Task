package com.backbase.ta.utils;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredFactory {
	
	private static final String url = "https://qa-task.backbasecloud.com";
	private static final String jwtTokenPath = "/api/users/login";
	private static final String createArticlePath = "/api/articles";
	private static final String readArticlePath = "/api/articles/{slug}";
	private static final String commentPath = "/api/articles/{slug}/comments";
	private static final String deleteCommentPath = "/api/articles/{slug}/comments/{id}";
	private static final String favouriteArticlePath = "/api/articles/{slug}/favorite";
	private static final String userProfilePath = "/api/profiles/{username}";
	private static final String followUserProfilePath = "/api/profiles/{username}/follow";
	
	

	
	
	private static String jwtToken=null;
	private static String token=null;
	public static String slugText;
	public static String commentID;
	
	private static final String username = "candidatex";
	private static final String password = "qa-is-cool";
	
	static RequestSpecification request;
	static Response response;
	
	
	/**
	 * Initializes {@link RestAssured} for current thread.
	 */
	public static void initializeAPIEnv(String runMode) {
		RestAssured.baseURI = url;

		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON);
		response = request.get();
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static String generateJWTToken() {
	String payload = 	"{\r\n" + 
			"  \"user\":{\r\n" + 
			"    \"email\": \"ckjohn@john.john\",\r\n" + 
			"    \"password\": \"ckjohnjohn\"\r\n" + 
			"  }\r\n" + 
			"}";
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .when()
                .body(payload);
                
		response = request.post(jwtTokenPath);
		
		token=response.jsonPath().get("user.token");
		jwtToken = "Token "+token;
		Assert.assertEquals(response.getStatusCode(), 200);
		return jwtToken;


	}
	
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void createNewArticle() {
	String payload = 	"{\r\n" + 
			"  \"article\": {\r\n" + 
			"    \"title\": \"How to train your automation team\",\r\n" + 
			"    \"description\": \"Ever wonder how?\",\r\n" + 
			"    \"body\": \"You have to believe\",\r\n" + 
			"    \"tagList\": [\"magic\", \"cool\", \"dragons\"]\r\n" + 
			"  }\r\n" + 
			"}";
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .when()
                .body(payload);
                
		response = request.post(createArticlePath);		
		slugText=response.jsonPath().get("article.slug");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void readArticle() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .pathParam("slug", slugText);

		response = request.get(readArticlePath);
		String slugs=response.jsonPath().get("article.slug");
		String title = response.jsonPath().get("article.title");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void updateArticle() {
		String payload = 	"{\r\n" + 
				"  \"article\": {\r\n" + 
				"    \"title\": \"How to train your dragonss new\"\r\n" + 
				"  }\r\n" + 
				"}";
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("slug", slugText)
                .when()
                .body(payload);
		
		response = request.put(readArticlePath);
		String title = response.jsonPath().get("article.title");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void deleteArticle() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("slug", slugText);
		
		response = request.delete(readArticlePath);
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void addComment() {
	String payload = 	"{\r\n" + 
			"  \"comment\": {\r\n" + 
			"    \"body\": \"His name was my name too.\"\r\n" + 
			"  }\r\n" + 
			"}";
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .when()
                .body(payload)
                .pathParam("slug", "how-to-train-your-dragonss-ny58nz");
                
		response = request.post(commentPath);	
		commentID=response.jsonPath().get("comment.id");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void readComment() {
	String payload = 	"{\r\n" + 
			"  \"comment\": {\r\n" + 
			"    \"body\": \"His name was my name too.\"\r\n" + 
			"  }\r\n" + 
			"}";
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .when()
                .body(payload)
                .pathParam("slug", slugText);
                
		response = request.get(commentPath);		
		slugText=response.jsonPath().get("article.slug");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void deleteComment() {
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("slug", "how-to-train-your-dragonss-ny58nz")
                .pathParam("id", commentID);
                
		response = request.delete(deleteCommentPath);		
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void favouriteArticle() {
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("slug", slugText);
                
		response = request.post(favouriteArticlePath);		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void unfavouriteArticle() {
	
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("slug", slugText);
                
		response = request.delete(favouriteArticlePath);		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void getUserProfile() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("username", "chinsahu");
                
		response = request.get(userProfilePath);		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void followUserProfile() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("username", "chinsahu");
                
		response = request.post(followUserProfilePath);		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	/**
	 * Initializes {@link Generate JWT Token} for current thread.
	 */
	public static void unFollowUserProfile() {
		request = RestAssured.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header("Accept", ContentType.JSON.getAcceptHeader())				
                .contentType(ContentType.JSON)
                .header("Accept-Charset", "utf-8")
                .header("jwtauthorization", jwtToken)
                .pathParam("username", "chinsahu");
                
		response = request.delete(followUserProfilePath);		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	

}
