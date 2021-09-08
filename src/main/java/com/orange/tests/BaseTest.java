package com.orange.tests;

/** @author Debbie */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.orange.configs.ConfigReader;
import com.orange.pages.BasePage;
import com.orange.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	
	protected String configURL;
	ConfigReader reader = new ConfigReader();
	
	@BeforeTest

	
	@Parameters(value= {"browser"})
	public void setUpTest(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	} else if(browser.equals("ff")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else {
		System.out.println("No browser defined in xml file...");
	}
	
	driver.get(reader.configURL);   //"https://opensource-demo.orangehrmlive.com"
	try {
		Thread.sleep(600);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	driver.manage().window().maximize();
	
	// initialize Page class (to pass the driver) using child class since can't create object of abstract classes
	page = new BasePage(driver, wait);
	
    long id = Thread.currentThread().getId();
    System.out.println("Before test-class. Thread id is: " + id);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
        long id = Thread.currentThread().getId();
        System.out.println("After test-class. Thread id is: " + id);
	}

}


