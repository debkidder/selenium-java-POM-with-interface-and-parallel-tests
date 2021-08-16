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
	
	// Config URL approach part 1 (if using the config approach w/config.properties file, ConfigReader class, getConfigURL method, and configURL) 
	protected String configURL;

	// Config URL approach part 2
	ConfigReader reader = new ConfigReader();
	
	// OR disable the above Config approach (part 1, 2, and 3) and enable this
	// Hardcoded URL approach part 1: 
	///private String applicationURL = "https://opensource-demo.orangehrmlive.com/";
	
 
	@BeforeTest
	public void launchApplication(){
		setChromeDriverProperty();
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		// Config URL approach part 3
		webDriver.get(reader.configURL);
		// OR disable the above and enable this
		// Hardcoded URL approach part 2:
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
