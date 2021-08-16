package com.orangehrm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.orangehrm.pages.*;
import com.orangehrm.configs.ConfigReader;


 
public class Automation {
 
	private static WebDriver webDriver;
	protected static Page autoPage;
	
	// If using the config 
	protected String configURL;

	
	// Can set URL using the config file (I wanted to learn how to read from the config file, but it's a little slower)
	ConfigReader reader = new ConfigReader();
	
	// Use this instead of above if wanting to hardcode 
	///private String applicationURL = "https://opensource-demo.orangehrmlive.com/";
	
 
	@BeforeTest
	public void launchApplication(){
		setChromeDriverProperty();
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(reader.configURL);
		// Use this instead of above if wanting to hardcode
		///webDriver.get(applicationURL);
		autoPage = new Page();
		autoPage.setWebDriver(webDriver);
	}
	
	@AfterTest 
	public void closeBrowser(){ webDriver.quit(); }
	 
 
	private void setChromeDriverProperty(){
		// TODO: I should switch to a resource path
		System.setProperty("webdriver.chrome.driver", "C://SeleniumJarsAndDrivers//chromedriver/chromedriver.exe");
	}
 
}
