package edu.ycp.cs320.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Main {
	

	public static void main(String[] args) throws IOException {
	
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What type of Source are you using ?");
		String source = keyboard.next().toLowerCase();
		SourceType sourceType = convertToSourceType(source);
		
		
		enterinformation(sourceType);
		
			
		
	
}

	private static SourceType convertToSourceType(String source) {
		for (SourceType sourceType : SourceType.values()) {
			String s = sourceType.toString().replace("_", "").toLowerCase();
			if (s.equals(source)) {
				return sourceType;
			}
		}
		throw new IllegalArgumentException("Unknown source type: " + source);
	}
	private static FormatType convertToFormatType(String format) {
		for (FormatType formatType : FormatType.values()) {
			String s = formatType.toString().replace("_", "").toLowerCase();
			if (s.equals(format)) {
				return formatType;
			}
		}
		throw new IllegalArgumentException("Unknown source type: " + format);
	}

	public static void enterinformation(SourceType sourceType) throws IOException {
		Citation citation = null;
		Source source=null;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is the author first name?");
		String first = keyboard.next().toLowerCase();
		System.out.print("What is the author last name?");
		String last = keyboard.next().toLowerCase();
		System.out.print("What is the title?");
		String title = keyboard.next().toLowerCase();
		System.out.print("What is the date?");
		String date = keyboard.next().toLowerCase();
		System.out.print("Who is the publisher?");
		String publisher = keyboard.next().toLowerCase();
		if(sourceType == SourceType.BOOK){
			System.out.print("What is the city?");
			String city = keyboard.next().toLowerCase();
			 source=new Book(first, last, title, date, publisher, city);
			 FormatType format=enterformat();
			citation=new Citation(source,format);
			
			
			
			
		}
		if(sourceType == SourceType.WEBSITE){
			System.out.print("What is the url?");
			String url = keyboard.next().toLowerCase();
			System.out.print("What is the access?");
			String access = keyboard.next().toLowerCase();
			System.out.print("What is the website?");
			String website= keyboard.next().toLowerCase();
			source=new Website(sourceType,first,last,title,date, publisher,url,access,website);
			FormatType format=enterformat();
			citation=new Citation(source,format);
			
		}	
		
		if(sourceType == SourceType.MAGAZINE){
			System.out.print("What is the magazine?");
			String magazine = keyboard.next().toLowerCase();
			System.out.print("What is the page number?");
			String pagenumber= keyboard.next().toLowerCase();
			System.out.print("What is the volume number?");
			String volumenumber= keyboard.next().toLowerCase();
			source=new Magazine(sourceType,first, last,  title,date,publisher,magazine, pagenumber, volumenumber);
			FormatType format=enterformat();
			citation=new Citation(source,format);
			
		}
		if(sourceType == SourceType.JOURNAL){
			System.out.print("What is the journal?");
			String journal = keyboard.next().toLowerCase();
			System.out.print("What is the volume?");
			String volume = keyboard.next().toLowerCase();
			System.out.print("What is the pagenumber?");
			String pagenumber= keyboard.next().toLowerCase();
			source= new Journal(sourceType,first,last,title,  date, publisher, journal, volume,  pagenumber);
			FormatType format=enterformat();
			citation=new Citation(source,format);
			
		}
		String cit=citation.formatcit();
		System.out.print(cit);
		writetextfile(cit);
	}

	

	public static void writetextfile(String cit) throws IOException {
		  FileWriter writer = new FileWriter("citiation.txt");

          writer.write(cit);
         

          writer.close();

          System.out.println("File written successfully!");
  }
		
	

	private static FormatType enterformat() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What kind of format do you want?");
		String format = keyboard.next().toLowerCase();
		FormatType formatType = convertToFormatType(format);
		return formatType;
	}
}

