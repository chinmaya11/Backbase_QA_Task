package com.backbase.ta.pages;



import com.backbase.ta.utils.WebDriverFactory;

public class BackbaseLoginPage extends WebDriverFactory {
	
	private static final String BACKBASE_URL = "qa-task.backbasecloud.com";

	
	/**
	 * Opens BackBase Login for given country.
	 * 
	 * @param url
	 *            {@link URL} https://qa-task.backbasecloud.com
	 */
	public static void get(final String url, final String username, final String password) {
		try {	
			WebDriverFactory.getDriver().get("https://" + "candidatex" +":" + "qa-is-cool" +"@"+ BACKBASE_URL);	
		}
		catch (Exception e) {
			e.getMessage();
		}

	}
	
	
	


}
