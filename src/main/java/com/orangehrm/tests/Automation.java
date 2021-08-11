package com.orangehrm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.orangehrm.pages.*;
//import com.orangehrm.pages.Page;

//import org.testng.asserts.SoftAssert;
//import org.testng.Reporter;
 
public class Automation {
 
	private static WebDriver webDriver;
	protected static Page autoPage;
	
	private String applicationURL = "https://opensource-demo.orangehrmlive.com/";
 
	@BeforeTest
	public void launchApplication(){
		setChromeDriverProperty();
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(applicationURL);
		autoPage = new Page();
		autoPage.setWebDriver(webDriver);

	}
	
	@AfterTest 
	public void closeBrowser(){ webDriver.quit(); }
	 
 
	private void setChromeDriverProperty(){
		System.setProperty("webdriver.chrome.driver", "C://SeleniumJarsAndDrivers//chromedriver/chromedriver.exe");
	}
 
}
