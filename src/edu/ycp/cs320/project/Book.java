package edu.ycp.cs320.project;

public class Book extends Source{
private String city;
private String pubDate;
private SourceType book;
	
	public Book() {
		super(SourceType.BOOK);
	}

	public String toString() {
	     return city.toString();
	}


	public Book(String first, String last, String title, String date,
			String publisher,String city,String medium) {
		super(SourceType.BOOK,first, last, title,date,publisher,medium);
		this.city=city;
		


	}
	public String getcity(){
		return city;
		}

	public void setcity(String city){
		System.out.println("Setting city name to " + city);
		this.city=city;
		setChanged();
		notifyObservers();
		}

	

	

	
	
}
