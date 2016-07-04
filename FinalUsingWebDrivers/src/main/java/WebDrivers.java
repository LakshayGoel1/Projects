

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WebDrivers {

	
	@Test
	public void startWebDriver(){
    //System.setProperty("webdriver.chrome.driver","C:/Users/lgoel/Downloads/chromedriver.exe");
	
	//driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
	//Assert.assertTrue(driver.get("http://google.com"));
	//Assert.assertTrue(driver.getTitle().startsWith("CALCULATOR"),"title should start differently");
    //driver.close();
   // -----------------------
}
	//driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
	int number1 = 80, number2 = 40;
	
	@Test
	public void testAddition() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
		File file1 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder0.html");
		System.out.println("Hi");
		InputStream inputStream1 = new FileInputStream(file1);
		System.out.println(inputStream1);
		StringBuilder builder1 = new StringBuilder();
		int ptr2 = 0;
		while ((ptr2 = inputStream1.read()) != -1) {
			builder1.append((char) ptr2);
		}

		String htmlString1 = builder1.toString();
		System.out.println(htmlString1);

		inputStream1.close();
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		Document html1 = Jsoup.parse(htmlString1);
		Element testSteps = html1.select("table").select("tr").get(1).select("td").get(3);
		System.out.println(testSteps);
		
		driver.findElement(By.id("operation")).sendKeys("Addition");
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:/Users/lgoel/Desktop/HTMLfiles/Addition1.png"));
		
		testSteps.html("<img src="+"Addition1.png "+"style='width:400px;height:300px;'"+"><br>");
		
		testSteps.append("1. Going to add two numbers "+number1+" and "+number2+".<br>");
		
		Calculator2 c = new Calculator2();
		int result = c.Addition(number1, number2);
		
	
		driver.findElement(By.id("number1")).sendKeys(Integer.toString(number1));
		driver.findElement(By.id("number2")).sendKeys(Integer.toString(number2));
		
		File source2 = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2,new File("C:/Users/lgoel/Desktop/HTMLfiles/Addition2.png"));
		
		testSteps.append("<img src="+"Addition2.png "+"style='width:400px;height:300px;'"+"><br>");
		testSteps.append("2.Checking whether correct or not.<br>");
		if(result==120){
			driver.findElement(By.id("result")).sendKeys(Integer.toString(result)+"(CORRECT)");
			File source3 = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Addition3.png"));
			testSteps.append("<img src="+"Addition3.png "+"style='width:400px;height:300px;'"+"><br>");
			testSteps.append("3. Result is "+result+" that is correct.<br>4.PASSED.<br>");
			testSteps.append("Executed completely.");
		}
		else{
			driver.findElement(By.id("result")).sendKeys(Integer.toString(result)+"(WRONG)");
			File source3 = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Addition3.png"));
			testSteps.append("<img src="+"Addition3.png "+"style='width:400px;height:300px;'"+"><br>");
			testSteps.append("3. Result is "+result+" that is wrong.<br>4.FAILED.<br>");
			
		testSteps.append("Executed completely.");
			}
		String copyHtml1 = html1.toString();
		// Write Content
		FileWriter writer1 = new FileWriter(file1);
		writer1.write(copyHtml1);
		writer1.close();
		driver.close();
		Assert.assertEquals(120, result);
	}

	@Test
	public void testSubtraction() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
		File file3 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder3.html");
		System.out.println("Hi");
		InputStream inputStream3 = new FileInputStream(file3);
		System.out.println(inputStream3);
		StringBuilder builder3 = new StringBuilder();
		int ptr2 = 0;
		while ((ptr2 = inputStream3.read()) != -1) {
			builder3.append((char) ptr2);
		}

		String htmlString1 = builder3.toString();
		System.out.println(htmlString1);

		inputStream3.close();
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		Document html3 = Jsoup.parse(htmlString1);
		Element testSteps3 = html3.select("table").select("tr").get(1).select("td").get(3);
		System.out.println(testSteps3);
		
		
		driver.findElement(By.id("operation")).sendKeys("Subtraction");
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:/Users/lgoel/Desktop/HTMLfiles/Subtraction1.png"));
		
		testSteps3.html("<img src="+"Subtraction1.png "+"style='width:400px;height:300px;'"+"><br>");
		Calculator2 c3 = new Calculator2();
		int result3 = c3.Subtraction(number1, number2);
		testSteps3.append("1. Going to subtract two numbers "+number1+" and "+number2+".<br>");
		
		driver.findElement(By.id("number1")).sendKeys(Integer.toString(number1));
		driver.findElement(By.id("number2")).sendKeys(Integer.toString(number2));
		
		File source2 = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2,new File("C:/Users/lgoel/Desktop/HTMLfiles/Subtraction2.png"));
		
		testSteps3.append("<img src="+"Subtraction2.png "+"style='width:400px;height:300px;'"+"><br>");
		testSteps3.append("2.Checking whether correct or not.<br>");
		if(result3==120){
			driver.findElement(By.id("result")).sendKeys(Integer.toString(result3)+"(CORRECT)");
			File source3 = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Subtraction3.png"));
			testSteps3.append("<img src="+"Subtraction3.png "+"style='width:400px;height:300px;'"+"><br>");
			testSteps3.append("3. Result is "+result3+" that is correct.<br>4.PASSED.<br>");
			testSteps3.append("Executed completely.");
		}
		else{
			driver.findElement(By.id("result")).sendKeys(Integer.toString(result3)+"(WRONG)");
			File source3 = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Subtraction3.png"));
			testSteps3.append("<img src="+"Subtraction3.png "+"style='width:400px;height:300px;'"+"><br>");
			testSteps3.append("3. Result is "+result3+" that is wrong.<br>4.FAILED.<br>");
		testSteps3.append("Executed completely.");
		}
		String copyHtml3 = html3.toString();
		// Write Content
		FileWriter writer3 = new FileWriter(file3);
		writer3.write(copyHtml3);
		writer3.close();
		driver.close();
		Assert.assertEquals(120, result3);
		
	}

		@Test
		public void testDivision() throws IOException {
			WebDriver driver = new FirefoxDriver();
			driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
			File file1 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder1.html");
			System.out.println("Hi");
			InputStream inputStream1 = new FileInputStream(file1);
			System.out.println(inputStream1);
			StringBuilder builder1 = new StringBuilder();
			int ptr2 = 0;
			while ((ptr2 = inputStream1.read()) != -1) {
				builder1.append((char) ptr2);
			}

			String htmlString1 = builder1.toString();
			System.out.println(htmlString1);

			inputStream1.close();
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			Document html1 = Jsoup.parse(htmlString1);
			Element testSteps1 = html1.select("table").select("tr").get(1).select("td").get(3);
			System.out.println(testSteps1);
			
			driver.findElement(By.id("operation")).sendKeys("Division");
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("C:/Users/lgoel/Desktop/HTMLfiles/Division1.png"));
			
			testSteps1.html("<img src="+"Division1.png "+"style='width:400px;height:300px;'"+"><br>");
			Calculator2 c1 = new Calculator2();
			int result1 = c1.Division(number1, number2);
			
			testSteps1.append("1. Going to divide number "+number1+" by "+number2+".<br>");
			
			driver.findElement(By.id("number1")).sendKeys(Integer.toString(number1));
			driver.findElement(By.id("number2")).sendKeys(Integer.toString(number2));
			
			File source2 = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source2,new File("C:/Users/lgoel/Desktop/HTMLfiles/Division2.png"));
			
			testSteps1.append("<img src="+"Division2.png "+"style='width:400px;height:300px;'"+"><br>");
			testSteps1.append("2.Checking whether correct or not.<br>");
			if(result1==2){
				driver.findElement(By.id("result")).sendKeys(Integer.toString(result1)+"(CORRECT)");
				File source3 = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Division3.png"));
				testSteps1.append("<img src="+"Division3.png "+"style='width:400px;height:300px;'"+"><br>");
				testSteps1.append("3. Result is "+result1+" that is correct.<br>4.PASSED.<br>");
				testSteps1.append("Executed completely.");
			}
			else{
				driver.findElement(By.id("result")).sendKeys(Integer.toString(result1)+"(WRONG)");
				File source3 = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Division3.png"));
				testSteps1.append("<img src="+"Division3.png "+"style='width:400px;height:300px;'"+"><br>");
				testSteps1.append("3. Result is "+result1+" that is wrong.<br>4.FAILED.<br>");
			testSteps1.append("Executed completely.");
			}
			String copyHtml3 = html1.toString();
			// Write Content
			FileWriter writer3 = new FileWriter(file1);
			writer3.write(copyHtml3);
			writer3.close();
			driver.close();
			Assert.assertEquals(2, result1);
			/*Calculator2 c2 = new Calculator2();
			int result3 = c2.Division(number1, number2);
			Assert.assertEquals(2, result3);*/
		}
		
			@Test
			public void testMultiplication() throws IOException {
				WebDriver driver = new FirefoxDriver();
				driver.get("file:///C:/Users/lgoel/Desktop/HTMLfiles/Calculator.html");
				File file2 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder2.html");
				System.out.println("Hi");
				InputStream inputStream2 = new FileInputStream(file2);
				System.out.println(inputStream2);
				StringBuilder builder2 = new StringBuilder();
				int ptr2 = 0;
				while ((ptr2 = inputStream2.read()) != -1) {
					builder2.append((char) ptr2);
				}

				String htmlString1 = builder2.toString();
				System.out.println(htmlString1);

				inputStream2.close();
			
				TakesScreenshot ts = (TakesScreenshot)driver;
				Document html2 = Jsoup.parse(htmlString1);
				Element testSteps2 = html2.select("table").select("tr").get(1).select("td").get(3);
				System.out.println(testSteps2);
				testSteps2.html("1. Going to multiply two numbers "+number1+" and "+number2+".<br>");
				
				driver.findElement(By.id("operation")).sendKeys("Multiplication");
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source,new File("C:/Users/lgoel/Desktop/HTMLfiles/Multiplication1.png"));
				
				testSteps2.html("<img src="+"Multiplication1.png "+"style='width:400px;height:300px;'"+"><br>");
				Calculator2 c2 = new Calculator2();
				int result = c2.Multiplication(number1, number2);
				
				testSteps2.append("1. Going to multiply two numbers "+number1+" and "+number2+".<br>");
				driver.findElement(By.id("number1")).sendKeys(Integer.toString(number1));
				driver.findElement(By.id("number2")).sendKeys(Integer.toString(number2));
				
				File source2 = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source2,new File("C:/Users/lgoel/Desktop/HTMLfiles/Multiplication2.png"));
				
				testSteps2.append("<img src="+"Multiplication2.png "+"style='width:400px;height:300px;'"+"><br>");
				
				testSteps2.append("2.Checking whether correct or not.<br>");
				if(result==3200){
					driver.findElement(By.id("result")).sendKeys(Integer.toString(result)+"(CORRECT)");
					File source3 = ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Multiplication3.png"));
					testSteps2.append("<img src="+"Multiplication3.png "+"style='width:400px;height:300px;'"+"><br>");
					testSteps2.append("3. Result is "+result+" that is correct.<br>4.PASSED.<br>");
					testSteps2.append("Executed completely.");
				}
				else{
					driver.findElement(By.id("result")).sendKeys(Integer.toString(result)+"(WRONG)");
					File source3 = ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source3,new File("C:/Users/lgoel/Desktop/HTMLfiles/Division3.png"));
					testSteps2.append("<img src="+"Division3.png "+"style='width:400px;height:300px;'"+"><br>");
					testSteps2.append("3. Result is "+result+" that is wrong.<br>4.FAILED<br>");
				testSteps2.append("Executed completely.");
				}
				String copyHtml2 = html2.toString();
				// Write Content
				FileWriter writer2 = new FileWriter(file2);
				writer2.write(copyHtml2);
				writer2.close();
				driver.close();
				Assert.assertEquals(3200, result);
				/*Calculator2 c2 = new Calculator2();
				int result4 = c2.Multiplication(number1, number2);
				Assert.assertEquals(3200, result4);*/
	}
	
}
