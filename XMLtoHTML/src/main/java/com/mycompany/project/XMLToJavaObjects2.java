package com.mycompany.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToJavaObjects2 {
	
	public static void main(String args[]) throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		
		
		XMLToJavaObjects2.class.getClassLoader();
		InputStream is = new FileInputStream("C:/Users/lgoel/workspace/XMLtoHTML/src/main/java/com/mycompany/project/testng-results.xml");
		System.out.println(is);
		TestngResults testngObject = 
		        (TestngResults) unmarshaller.unmarshal(
		    is);

//		TestngResults testngObject = unmarshalledObject.getValue();
	/*	int a = testngObject.getPassed();
		System.out.println(a);
		System.out.println(testngObject.getFailed());
		System.out.println(testngObject.getTotal());
		System.out.println(testngObject.getSkipped());
		System.out.println(testngObject.getReporterOutput());
		System.out.println(testngObject.getSuite());*/
		
		TestngResults.Suite.Test.Class.TestMethod object = new TestngResults.Suite.Test.Class.TestMethod();
		TestngResults.Suite object1 = (TestngResults.Suite) unmarshaller.unmarshal(is);
		System.out.println(TestngResults.Suite.class);
		System.out.println(object);
	}
}
