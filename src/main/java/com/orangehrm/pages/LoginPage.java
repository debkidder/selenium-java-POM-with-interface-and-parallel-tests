package com.orangehrm.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
 
public class LoginPage extends Page {
	
	// locators
	By username=By.id("txtUsername");
	By password=By.xpath("//input[@id='txtPassword']");
	By loginBtn=By.name("Submit");
	By actualMsg=By.xpath(".//*[@id=\'spanMessage\']");
		
	
	public void enterUsername() {		
		driver.findElement(username).sendKeys("Admin");					
	}	
	
	public void enterPassword() {		
		driver.findElement(password).sendKeys("admin123");				
	}	
	
	public void enterBadPassword() {
		driver.findElement(password).sendKeys("ADMIN123");				
	}
	
	public void clickLoginBtn() {	
		driver.findElement(loginBtn).click();		
	}	
	
	public String getActualMsg() {
		return driver.findElement(actualMsg).getText();
	}
	
	public void clearFields() {
		driver.findElement(username).clear();
		driver.findElement(password).clear();
	}
}
