package com.orange.tests;

/** @author Debbie */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.pages.LoginPage;

public class LoginTests extends BaseTest {
	
	public void LoginPage(WebDriver driver, WebDriverWait wait) {
	}
	
	LoginPage testdriver = new LoginPage(driver, wait); {
	}
	
	@Test (priority=1, enabled=true)
	public void negTestLoginEmptyUsername() {		
		// Verifies FAILED LOGIN - EMPTY USERNAME 
        long id = Thread.currentThread().getId();
        System.out.println("Test method: negTestLoginEmptyUsername. Thread id: " + id);

		LoginPage testdriver = new LoginPage(driver, wait); {
			// intentionally skips username
			testdriver.enterPassword();
			testdriver.clickLoginButton();
			// Verifies actual msg for empty username matches expected msg
			Assert.assertTrue(testdriver.getActualMsg().contains("Username cannot be empty"), "Displaying: '" + testdriver.getActualMsg() + "' instead of expected message: 'Username cannot be empty';");
			testdriver.clearFields();
		}		
	}
		
	@Test (priority=2, enabled=true)
	public void negTestLoginBadPassword() {		
		// Verifies FAILED LOGIN - BAD PASSWORD 
        long id = Thread.currentThread().getId();
        System.out.println("Test method: negTestLoginBadPassword. Thread id: " + id);
	
		LoginPage testdriver = new LoginPage(driver, wait); {
			testdriver.enterUsername();
			testdriver.enterBadPassword();
			testdriver.clickLoginButton();
			// Verifies actual msg for bad password matches expected msg		
			Assert.assertTrue(testdriver.getActualMsg().contains("Invalid credentials"), "Displaying: '" + testdriver.getActualMsg() + "' instead of 'Invalid credentials';");
			testdriver.clearFields();
		}		
	}
	
		
	@Test (priority=3, enabled=true)
	public void testLogin() throws InterruptedException {
		// Verifies SUCCESSFUL LOGIN 
        long id = Thread.currentThread().getId();
        System.out.println("Test method: testLogin. Thread id: " + id);
		
		LoginPage testdriver = new LoginPage(driver, wait); { 
			
			testdriver.enterUsername(); 
			testdriver.enterPassword();
			testdriver.clickLoginButton(); 
			Assert.assertTrue(testdriver.getCurrentPageURL().contains("https://opensource-demo.orangehrmlive.com/index.php/dashboard"), "Incorrectly going to: '" + testdriver.getCurrentPageURL
					() + "' instead of expected URL: https://opensource-demo.orangehrmlive.com/index.php/dashboard';");			
		}	  
	}  
}

// TODO: Add logging and reporting
// TODO: Take screenshot on test failures
	

	
