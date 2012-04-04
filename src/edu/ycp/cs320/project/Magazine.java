package edu.ycp.cs320.project;

public class Magazine extends Source {
private String magazine,pagenumber,volume;
	public Magazine(String first, String last, String title, String date,
			String publisher,String magazine, String pagenumber, String volume) {
		super(first, last, title, date, publisher);
		this.magazine=magazine;
		this.pagenumber=pagenumber;
		this.volume=volume;
	}
	public String getmagazine(){
		return magazine;
	}
	public String getpagenumber(){
		return pagenumber;
	}
	public String getvolumenumber(){
		return volume;
	}
	public void setmagazine(String magazine){
		this.magazine=magazine;
		}
	public void setvolume(String volume){
		this.volume=volume;
		}
	public void setpagenumber(String pagenumber){
		this.pagenumber=pagenumber;
		}
}
