package edu.ycp.cs320.project;


public class Periodical extends Source {
private String magazine,pagenumber,volume;

	public Periodical(SourceType sourceType,String first, String last, String title, String date,String publisher,String magazine, String pagenumber, String volume,String medium) {
		super(SourceType.PERIODICAL,first, last, title, date, publisher, medium);
		this.magazine=magazine;
		this.pagenumber=pagenumber;
		this.volume=volume;	
	}
		

	public Periodical (){
		super(SourceType.PERIODICAL);
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
		System.out.println("Setting Magazine Name to " + magazine);
		this.magazine=magazine;
		setChanged();
		notifyObservers();
	}
	public void setvolume(String volume){
		System.out.println("Setting volume to " + volume);
		this.volume=volume;
		setChanged();
		notifyObservers();
	}
	public void setpagenumber(String pagenumber){
		System.out.println("Setting page number to " + pagenumber);
		this.pagenumber=pagenumber;
		setChanged();
		notifyObservers();
	}
}
