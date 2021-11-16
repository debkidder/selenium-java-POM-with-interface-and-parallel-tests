package com.orange.pages;

/** @author Debbie */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.configs.ConfigReader;

public class LoginPage extends BasePage implements TrackingURL{


	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	ConfigReader reader = new ConfigReader();

	// locators
	By usernameField=By.id("txtUsername");
	By passwordField=By.xpath("//input[@id='txtPassword']");
	By loginButton=By.id("btnLogin");
	By actualMsg=By.xpath(".//*[@id=\'spanMessage\']");
	By loginPanel=By.xpath("//*[@id='logInPanelHeading']");
	By forgotPasswordLink=By.xpath("//a[normalize-space()='Forgot your password?']");
	
	protected String username1;
	protected String password1;
	

	public String getCurrentPageURL() {
		String currentPageURL = driver.getCurrentUrl();
		return currentPageURL;
	}
		
	public void enterUsername() {		
		driver.findElement(usernameField).sendKeys(reader.getUsername1());  // Admin
	}	
	
	public void enterPassword() {		
		driver.findElement(passwordField).sendKeys(reader.password1); // admin123
	}	
	
	public void enterBadPassword() {
		driver.findElement(passwordField).sendKeys("ADMIN123");				
	}
	
	public void clickLoginButton() {	
		driver.findElement(loginButton).click();		
	}	
	
	
	public boolean findLoginButton() {	
		return driver.findElement(loginButton).isDisplayed();		
	}
	
	public String getActualMsg() {
		return driver.findElement(actualMsg).getText();
	}
	
	public void clearFields() {
		driver.findElement(usernameField).clear();
		driver.findElement(passwordField).clear();
	}
	
	public void clickForgotPasswordLink() {	
		driver.findElement(forgotPasswordLink).click();	
	}
	
	public boolean isForgotPasswordLinkEnabled() {	
		return driver.findElement(forgotPasswordLink).isEnabled();		
	}
	
//	public void checkForgotPasswordLink() {	
//		driver.findElement(forgotPasswordLink).isDisplayed();		
//	}


	

	
}