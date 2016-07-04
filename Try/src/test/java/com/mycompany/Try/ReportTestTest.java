package com.mycompany.Try;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class ReportTestTest {
  @Test
  public void testIt() {
	  WebDriver driver = new HtmlUnitDriver();
		Reporter.initialize();
		driver.get("http://www.ontestautomation.com/files/report_test.html");
		
		for (int i = 1; i <=5; i++) {
			WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
			Reporter.report(el.getAttribute("value"), "Text field " + Integer.toString(i));
		}
		
		Reporter.writeResults();
		driver.close();	
	}
	  
  
}
