package edu.ycp.cs320.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import edu.ycp.cs320.project.FormatType;


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

		String first = keyboard.nextLine().toLowerCase();
		System.out.print("What is the author last name?");
		String last = keyboard.nextLine().toLowerCase();
		System.out.print("What is the title?");
		String title = keyboard.nextLine().toLowerCase();
		System.out.print("What is the date?");
		String date = keyboard.nextLine().toLowerCase();
		System.out.print("Who is the publisher?");
		String publisher = keyboard.nextLine().toLowerCase();
		System.out.print("What is the medium?");
		String medium = keyboard.nextLine().toLowerCase();
		if(sourceType == SourceType.BOOK){
			System.out.print("What is the city?");
			String city = keyboard.next().toLowerCase();

			 source=new Book(first, last, title, date, publisher, city,medium);

			 FormatType format=enterformat();
			citation=new Citation(source,format);
			
			
			
			
		}
		if(sourceType == SourceType.WEBSITE){

			System.out.print("What is the url?");

			String url = keyboard.nextLine().toLowerCase();
			System.out.print("What is the access?");
			String access = keyboard.nextLine().toLowerCase();
			System.out.print("What is the website?");
			String website= keyboard.nextLine().toLowerCase();


			source=new Website(sourceType,first,last,title,date, publisher,medium,url,access,website);

			FormatType format=enterformat();
			citation=new Citation(source,format);
			
		}	





		if(sourceType == SourceType.PERIODICAL){
			System.out.print("What is the magazine?");

			String magazine = keyboard.nextLine().toLowerCase();
			System.out.print("What is the page number?");
			String pagenumber= keyboard.nextLine().toLowerCase();
			System.out.print("What is the volume number?");
			String volumenumber= keyboard.nextLine().toLowerCase();
			source=new Periodical(sourceType,first, last,  title,date,publisher,medium,magazine, pagenumber, volumenumber);
			FormatType format=enterformat();
			citation=new Citation(source,format);

			
			
			
			
			
		}
		if(sourceType == SourceType.JOURNAL){
			System.out.print("What is the journal?");
			String journal = keyboard.next().toLowerCase();
			System.out.print("What is the volume?");
			String volume = keyboard.next().toLowerCase();

			System.out.print("What is the pagenumber?");
			String pagenumber= keyboard.nextLine().toLowerCase();
			source= new Journal(sourceType,first,last,title,  date, publisher, journal, volume,  pagenumber,medium);

			

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

