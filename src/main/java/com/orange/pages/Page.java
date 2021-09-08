package com.orange.pages;

/** @author Debbie */

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public WebDriver driver;
	public WebDriverWait wait;		
	
//	public String getActualMsg() {
//		return driver.findElement(actualMsg).getText();
//	}

	public Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// creates an interface using a method with type Generics and returning new page
	// different than the usual interface approach, specific for webdriver handling I think
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
public String getCurrentPageURL() {
		String currentPageURL = driver.getCurrentUrl();
		return currentPageURL;
	}
	
}



