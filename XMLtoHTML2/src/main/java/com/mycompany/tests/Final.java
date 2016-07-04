package com.mycompany.tests;

import com.mycompany.project.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Final {

	public static void main(String args[]) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		XMLToJavaObjects.class.getClassLoader();
		InputStream is = new FileInputStream("C:/Users/lgoel/workspace/XMLtoHTML2/testng-results.xml");
		System.out.println(is);
		@SuppressWarnings("unchecked")
		TestngResultsType testngObject = ((JAXBElement<TestngResultsType>) unmarshaller.unmarshal(is)).getValue();

		File file = new File("C:/Users/lgoel/Desktop/HTMLfiles/HTMLTemplate3.txt");
		InputStream inputStream = new FileInputStream(file);
		System.out.println(inputStream);
		StringBuilder builder = new StringBuilder();
		int ptr = 0;
		while ((ptr = inputStream.read()) != -1) {
			builder.append((char) ptr);
			// System.out.println(ptr);
		}

		String htmlString = builder.toString();
		// System.out.println(htmlString);

		inputStream.close();
		Document html = Jsoup.parse(htmlString);
		// ------------------Correct----------------------------------------------//

		String h2 = html.body().getElementsByTag("h2").get(0).text();
		System.out.println(h2);
		
		int totalTests = testngObject.getTotal();
		int totalPassed = testngObject.getPassed();
		int totalFailed = testngObject.getFailed();
		int totalSkipped = testngObject.getSkipped();
		
		//Anything staring with % is placeholder here//
		Elements total = html.getElementsByAttribute("%totaltests").get(0).select("td");
		total.html(Integer.toString(totalTests));
		
		Elements passed = html.getElementsByAttribute("%totalpassed").get(0).select("td");
		passed.html(Integer.toString(totalPassed)+getPercentage(totalPassed,totalTests));

		Elements failed = html.getElementsByAttribute("%totalfailed").get(0).select("td");
		failed.html(Integer.toString(totalFailed)+getPercentage(totalFailed,totalTests));
		
		Elements skipped = html.getElementsByAttribute("%totalskipped").get(0).select("td");
		skipped.html(Integer.toString(totalSkipped)+getPercentage(totalSkipped,totalTests));
		
		Elements div = html.getElementsByAttribute("%testsstarted").get(0).select("td");
		Calendar cal = testngObject.getSuite().getTest().getStartedAt().toGregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		formatter.setTimeZone(cal.getTimeZone());
		String dateString = formatter.format(cal.getTime());
		div.html(dateString);
		
		Elements div2 = html.getElementsByAttribute("%testsfinished").get(0).select("td");
		Calendar cal2 = testngObject.getSuite().getTest().getFinishedAt().toGregorianCalendar();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		formatter.setTimeZone(cal2.getTimeZone());
		String dateString2 = formatter2.format(cal.getTime());
		div2.html(dateString2);
		
		Elements divsuite = html.select("table").get(1).select("tr").get(1).select("th");
		divsuite.html(testngObject.getSuite().getName());
		
		Elements divtest = html.select("table").get(1).select("tr").get(2).select("th");
		divtest.html(testngObject.getSuite().getTest().getName());
		
		Elements div4 = html.getElementsByAttribute("%time").get(0).select("td");
		div4.html(Integer.toString(testngObject.getSuite().getTest().getDurationMs()));
		
		
		System.out.println(testngObject.getSuite().getTest().getClazz().getTestMethod().get(1).getName());
		int numberOfTests = testngObject.getSuite().getTest().getClazz().getTestMethod().size();
		System.out.println(numberOfTests);
		
		Element div5 = html.select("table").get(2);
		System.out.println(div5);
		for(int i=0;i<numberOfTests;i++){
			String dup = Integer.toString(i);
		//div5.append("<tr><td><a href='Placeholder2.html' target='iframe_a'>"+testngObject.getSuite().getTest().getClazz().getTestMethod().get(i).getName()+"</a></td></tr>");
		div5.append("<tr><td><a href=Placeholder"+dup+".html target='iframe_a'>"+testngObject.getSuite().getTest().getClazz().getTestMethod().get(i).getName()+"</a></td></tr>");
		
		}
		System.out.println(testngObject.getSuite().getTest());
		
		
		//-------------------------UNDER CONSTRUCTION------------------//
		
		File file2 = new File("C:/Users/lgoel/Desktop/HTMLfiles/HTMLTemplateCopied.html");

		// Create the file
		if (file2.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
		String copy = html.toString();
		// Write Content
		FileWriter writer = new FileWriter(file2);
		writer.write(copy);
		writer.close();
		
		
			//------------------Correct----------------//
			
			File file4 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder.txt");
			System.out.println("Hi");
			InputStream inputStream2 = new FileInputStream(file4);
			System.out.println(inputStream2);
			StringBuilder builder2 = new StringBuilder();
			int ptr2 = 0;
			while ((ptr2 = inputStream2.read()) != -1) {
				builder2.append((char) ptr2);
			}

			String htmlString2 = builder2.toString();
			System.out.println(htmlString2);

			inputStream2.close();
			
			
			
			
			System.out.println(testngObject.getSuite().getTest().getClazz().getTestMethod().get(0).getName());

			for(int i=0;i<numberOfTests;i++){
				Document html2 = Jsoup.parse(htmlString2);
				File file3 = new File("C:/Users/lgoel/Desktop/HTMLfiles/Placeholder"+i+".html");
				if (file3.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File already exists.");
				}
				
				Element testName = html2.select("table").select("tr").get(1).select("td").get(0);
				Element testStatus = html2.select("table").select("tr").get(1).select("td").get(1);
				Element testTime = html2.select("table").select("tr").get(1).select("td").get(2);
				Element testException = html2.select("table").select("tr").get(1).select("td").get(3);
				
				testName.html(testngObject.getSuite().getTest().getClazz().getTestMethod().get(i).getName());
				testStatus.html(testngObject.getSuite().getTest().getClazz().getTestMethod().get(i).getStatus());
				testTime.html(Integer.toString(testngObject.getSuite().getTest().getClazz().getTestMethod().get(i).getDurationMs()));
				
				System.out.println(testngObject.getSuite().getTest().getClazz().getTestMethod().get(i));
				String copyHtml = html2.toString();
				// Write Content
				FileWriter writer2 = new FileWriter(file3);
				writer2.write(copyHtml);
				writer2.close();
			}
		}

	
	//getPercentage Method returns the percentage of tests//
			public static String getPercentage(double target, double totaltests){
				double result = (target/totaltests)*100;
				
				return "("+result+"%)";
			}
}
