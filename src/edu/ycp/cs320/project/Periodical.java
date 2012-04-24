package edu.ycp.cs320.project;

public class Periodical extends Source {
private String magazine,pagenumber,volume;
	public Periodical(SourceType sourceType,String first, String last, String title, String date,
			String publisher,String magazine, String pagenumber, String volume,String medium) {
		super(SourceType.MAGAZINE,first, last, title, date, publisher,medium);
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
