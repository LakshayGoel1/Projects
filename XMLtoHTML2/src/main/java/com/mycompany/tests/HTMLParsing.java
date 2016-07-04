package com.mycompany.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParsing {
	public static void main(String args[]) throws IOException {

		File file = new File("C:/Users/lgoel/Desktop/HTMLfiles/HTMLTemplate2.txt");
		InputStream inputStream = new FileInputStream(file);
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
		String h2 = html.body().getElementsByTag("h2").get(0).text();
		System.out.println(h2);
		Elements div2 = html.getElementsByAttribute("placeholder").get(1).select("td");
		//System.out.println(html);
		 System.out.println(div2);
		 div2.html("Placeholder2");

		// Elements div =
		// html.select("div").first().select("table").select("tr").select("th");
		Elements div = html.select("div").get(1).select("tr").get(1).select("td").select("a");
		div.html("I think it is done");
		System.out.println(html);
		File file2 = new File("C:/Users/lgoel/Desktop/HTMLfiles/HTMLTemplateCopied.html");
		  
		//Create the file
		if (file2.createNewFile()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		 String copy = html.toString();
		//Write Content
		FileWriter writer = new FileWriter(file2);
		writer.write(copy);
		writer.close();
		//String copy = JSoup.parse(html)
		System.out.println(div);

	}
}
