package com.orange.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orange.pages.LoginPage;
import com.orange.pages.PasswordResetPage;

public class PasswordResetTests extends BaseTest {
	
	public void LoginPage(WebDriver driver, WebDriverWait wait) {
	}
	
	LoginPage testdriver = new LoginPage(driver, wait); {
	}
	
	  @Test (priority=1, enabled=true) 
	  public void testResetLinkEnabled() throws InterruptedException  {
		  // Verifies RESET LINK
	        long id = Thread.currentThread().getId();
	        System.out.println("Test method: testResetLinkEnabled. Thread id: " + id);
	  
		LoginPage testdriver = new LoginPage(driver, wait); { 
			
			Assert.assertTrue(testdriver.isForgotPasswordLinkEnabled(), "Forgot Password link doesn't seem to be enabled");
			testdriver.clickForgotPasswordLink();
			
//			Assert.assertTrue(testdriver.getCurrentPageURL().contains("https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode"), "Incorrectly going to: '" 
//			+ testdriver.getCurrentPageURL() 
//			+ "' instead of expected URL: https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode';");	
			
		}
	  }
	  
	 
	  @Test (priority=2, enabled=true) 
	  public void testResetSubmission() throws InterruptedException  {
		  // Verifies that the reset button is enabled
	        long id = Thread.currentThread().getId();
	        System.out.println("Test method: testResetLinkEnabled. Thread id: " + id);
	  
	   PasswordResetPage testdriver = new PasswordResetPage(driver, wait); { 
		   
			Assert.assertTrue(testdriver.getCurrentPageURL().contains("https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode"), "Incorrectly going to: '" 
			+ testdriver.getCurrentPageURL() 
			+ "' instead of expected URL: https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode';");
			
			testdriver.enterUsername(); 

			Assert.assertTrue(testdriver.isResetPasswordButtonEnabled(), "Reset Password button doesn't seem to be enabled");
			testdriver.clickResetPasswordButton();
	
		}
	  }
}
