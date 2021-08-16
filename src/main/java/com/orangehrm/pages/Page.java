package com.orangehrm.pages;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Page {
	
	//String currentPageURL = driver.getCurrentUrl();

	
	protected static WebDriver driver;
	
	public void setWebDriver(WebDriver driver) {
		Page.driver = driver;
	}
	
	// might remove if not needed
	/*
	 * public String getActualMsg() { return
	 * driver.findElement(actualMsg).getText(); }
	 */
	
	public String getCurrentPageURL() {
		String currentPageURL = driver.getCurrentUrl();
		return currentPageURL;
	}
		
} 

