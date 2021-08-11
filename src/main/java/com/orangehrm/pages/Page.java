package com.orangehrm.pages;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Page {
	
	//String currentPageURL = driver.getCurrentUrl();
	//String actualMsg = driver.getActualMsg();
	
	protected static WebDriver driver;
	
	public void setWebDriver(WebDriver driver) {
		Page.driver = driver;
	}
	
	// TODO: check if this needed
	/*
	 * public String getActualMsg() { return
	 * driver.findElement(actualMsg).getText(); }
	 */
	
	public String getCurrentPageURL() {
		String currentPageURL = driver.getCurrentUrl();
		return currentPageURL;
	}
		
} 

