package edu.ycp.cs320.project;

public class Book extends Source{
private String city;
private String pubDate;

	
	public Book() {
		super(SourceType.BOOK);
	}

	public Book(String first, String last, String title, String date,
			String publisher,String city,String medium) {
		super(SourceType.BOOK,first, last, title,date,publisher,medium);
		this.city=city;
		
	}
	public String getcity(){
		return city;
		}
	
	//public String toString() {
      //  return city.toString();
//}
	public void setcity(String city){
		this.city=city;
		}

	public void setPubDate(String text) {
		this.pubDate = text;
	}

	public String getPubDate() {
		return pubDate;
	}

	
	
}
