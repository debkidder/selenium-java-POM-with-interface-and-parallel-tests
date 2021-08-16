package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//import org.testng.Reporter;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginTests extends Automation {
	
	// Tests 1 and 2 are interchangeable, but can't be run after Test 3, the successful login; 
	// So considering putting negative tests in separate class or doing complete teardown with each test...looking for best practice


	@Test (priority=1, enabled=true)
	public void testLoginEmptyUsername() {		
	
		LoginPage tester = new LoginPage(); {
			// verifies login is prevented with empty username 
			// removes step: tester.enterUsername();
			tester.enterPassword();
			tester.clickLoginBtn();
			String actualMsg = tester.getActualMsg();			
			Assert.assertTrue(actualMsg.contains("Username cannot be empty"), "Displaying wrong message: '" + actualMsg + "' instead of the expected message: 'Username cannot be empty';");
			tester.clearFields();
		}		
	}
		
	@Test (priority=2, enabled=true)
	public void testLoginBadPassword() {		
	
		LoginPage tester = new LoginPage(); {
			// verify login is prevented with bad password 
			tester.enterUsername();
			tester.enterBadPassword();
			tester.clickLoginBtn();
			String actualMsg = tester.getActualMsg();			
			//Assert.assertEquals(actualMsg,"Invalid credentials");
			Assert.assertTrue(actualMsg.contains("Invalid credentials"), "Displaying wrong message: '" + actualMsg + "' instead of the expected message: 'Invalid credentials';");
			tester.clearFields();
		}		
	}
	
	
	
	@Test (priority=3, enabled=true)
	public void testLogin() throws InterruptedException {
	  
		LoginPage tester = new LoginPage(); { 
			// verify login succeeds with valid username/password after unsuccessful attempt
			// TODO: Add implicit waits if needed
			tester.enterUsername(); 
			tester.enterPassword();
			tester.clickLoginBtn(); 
			String currentPageURL = tester.getCurrentPageURL();
			Assert.assertTrue(currentPageURL.contains("https://opensource-demo.orangehrmlive.com/index.php/dashboard"), "After login, going to wrong URL: '" + currentPageURL + "' instead of the expected one: \"https://opensource-demo.orangehrmlive.com/index.php/dashboard\';");			
			// TODO: Check best practice on creating separate class for each test; or 2 classes for each page...positive/negative tests
		}	  
	}	
	
}

// TODO: Add logging and reporting
// TODO: Take screenshot on test failures
	

	
