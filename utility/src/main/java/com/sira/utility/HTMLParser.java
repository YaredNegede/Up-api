package com.sira.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {

	public  void parseFromString(String html) throws IOException {

		org.jsoup.nodes.Document doc = Jsoup.parse(html);

		Elements newsHeadlines = doc.children();

		File f = new File("src/test/resources/d9e8a9dd-4d53-4915-9568-b520fbaaed34.json");
		
		doc.select("p").forEach(System.out::println);
/*
		for (Element el : newsHeadlines) {
			
			System.err.println(el.data());			
			
			java.io.FileWriter wr = new  java.io.FileWriter(f);
			
			wr.write(el.data());

		}*/

	}
	
	public void parseFromStringFromFile(String path) throws IOException {
		
		 parseFromString(readFile(path));
		
	}

	public String readFile(String path) throws IOException {

		File fl = new File(path);
		
		System.out.println(fl.getAbsolutePath());

		return read(fl);

	}

	public String read(File fl) throws IOException {
		
		FileReader fileReader = new FileReader(fl);

		BufferedReader rd = new BufferedReader(fileReader);

		String st;

		StringBuffer sb = new StringBuffer();

		while((st = rd.readLine()) !=null) {

			sb.append(st);
			
		}

		rd.close();
		
		
		return sb.toString();
	}

}
