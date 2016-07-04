package com.mycompany.tests;
import com.mycompany.project.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToJavaObjects {
	
	public static void main(String args[]) throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		
		
		XMLToJavaObjects.class.getClassLoader();
		InputStream is = new FileInputStream("C:/Users/lgoel/workspace/XMLtoHTML2/testng-results.xml");
		System.out.println(is);
		@SuppressWarnings("unchecked")
		TestngResultsType testngObject = 
		        ((JAXBElement<TestngResultsType>) unmarshaller.unmarshal(
		    is)).getValue();

		//TestngResultsType testngObject = unmarshalledObject.getValue();
		int a = testngObject.getPassed();
		System.out.println(a);
		System.out.println(testngObject.getFailed());
		System.out.println(testngObject.getTotal());
		System.out.println(testngObject.getSkipped());
		System.out.println(testngObject.getReporterOutput());
		System.out.println(testngObject.getSuite().getDurationMs());
		
		/*TestngResultsType.Suite.Test.Class.TestMethod object = new TestngResultsType.Suite.Test.Class.TestMethod();
		TestngResults.Suite object1 = (TestngResults.Suite) unmarshaller.unmarshal(is);
		System.out.println(TestngResultsType.Suite.class);
		System.out.println(object);*/
	}
}
