package edu.ycp.cs320.project;

public class Journal extends Source {
String journal, volume, pagenumber,source;
	public Journal(String first, String last, String title, String date, String publisher,String journal,String volume, String pagenumber ) {
		super(first, last, title, date, publisher);	
		this.journal=journal;
		this.volume=volume;
		this.pagenumber=pagenumber;
	}
	public String getjournal(){
		return journal;
		}
	public String getvolume(){
		return volume;
		}
	public String getpagenumber(){
		return pagenumber;
		}
	public void setjournal(String journal){
		this.journal=journal;
		}
	public void setvolume(String volume){
		this.volume=volume;
		}
	public void setpagenumber(String pagenumber){
		this.pagenumber=pagenumber;
		}
}
