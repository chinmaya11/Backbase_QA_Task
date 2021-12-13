package com.backbase.ta.steps;


import com.backbase.ta.utils.RestAssuredFactory;
import com.backbase.ta.utils.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


/**
 * Cucumber hook steps definition class responsible for actions taken before and after test execution.
 */
public class BackgroundSteps {
	
	public static String jwtauthToken;

	/**
	 * Cucumber hook steps definition class responsible for intialize webdriver.
	 * 
	 * @param Fetching arguments being passed while executing a maven goal to run scripts in API and GUI >> headless mode
	 */
	@Before
	public void beforeUITests() {
		String runmode = System.getProperty("runmode");

		 if (runmode!= null && runmode.equalsIgnoreCase("api")) {
				RestAssuredFactory.initializeAPIEnv(System.getProperty("runmode"));
				String jwtauthToken = RestAssuredFactory.generateJWTToken();
			} else {
				WebDriverFactory.initialize(System.getProperty("runmode"));
			}			
	}
	
	
	
	
	/**
	 * Cucumber hook steps definition class responsible for quit webdriver.
	 */
	@After
	public void afterUITests(final Scenario scenario) {
		if (!scenario.isFailed()) {
			WebDriverFactory.quitCurrentDriver();
		}
	}
}
