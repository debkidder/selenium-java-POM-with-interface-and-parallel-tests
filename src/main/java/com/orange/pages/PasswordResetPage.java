package com.orange.pages;

/** @author Debbie */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.configs.ConfigReader;

public class PasswordResetPage extends BasePage implements TrackingURL {

	public PasswordResetPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	ConfigReader reader = new ConfigReader();

	// locators
	By forgotPasswordPanel=By.xpath("//h1[normalize-space()='Forgot Your Password?']");
	By usernameAuthField=By.id("securityAuthentication_userName");
	By resetPasswordButton=By.id("btnSearchValues");
	By actualMsg=By.xpath("//h1[contains(text(),'Instruction Sent !')]");

	protected String username1;
	
	public String getCurrentPageURL() {
		String currentPageURL = driver.getCurrentUrl();
		return currentPageURL;
	}
	
	public void enterUsername() {		
		driver.findElement(usernameAuthField).sendKeys(reader.getUsername1());  // Admin
	}	
	
	public boolean isResetPasswordButtonEnabled() {	
		return driver.findElement(resetPasswordButton).isEnabled();		
	}
	
	public void clickResetPasswordButton() {	
		driver.findElement(resetPasswordButton).click();		
	}
	
	public String getActualMsg() {
		return driver.findElement(actualMsg).getText();
	}
	
}
