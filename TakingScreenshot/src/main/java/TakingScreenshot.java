import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakingScreenshot {
	@Test
	public void DoTest() throws IOException{
	WebDriver driver = new FirefoxDriver();
	driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
	driver.findElement(By.id("number1")).sendKeys("5");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source,new File("C:/Users/lgoel/Desktop/HTMLfiles/Screen1.png"));
	System.out.println(driver.getPageSource());
	driver.findElement(By.id("number2")).sendKeys("5");
	File source2 = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source2,new File("C:/Users/lgoel/Desktop/HTMLfiles/Screen2.png"));
	System.out.println(driver.getPageSource());
	System.out.println("Screenshot taken");
	driver.close();
}
}
