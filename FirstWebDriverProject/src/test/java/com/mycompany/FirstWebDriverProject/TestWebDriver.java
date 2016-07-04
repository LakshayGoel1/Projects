package com.mycompany.FirstWebDriverProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestWebDriver {

	@Test
	public void startWebDriver(){
    //System.setProperty("webdriver.chrome.driver","C:/Users/lgoel/Downloads/chromedriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
	//Assert.assertTrue(driver.get("http://google.com"));
	Assert.assertTrue(driver.getTitle().startsWith("CALCULATOR"),"title should start differently");
    //driver.close();
   // -----------------------
}
}
