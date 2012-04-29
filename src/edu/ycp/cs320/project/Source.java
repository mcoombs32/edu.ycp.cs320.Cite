package edu.ycp.cs320.project;

import java.util.Observable;

public abstract class Source extends Observable {
	private SourceType sourceType;

	private String first,last,title,date,publisher,medium;

	
	public Source(SourceType sourceType) {
		this.sourceType = sourceType;
	}
	
	/**
	 * 
	 * 
	 * @param source
	 * @param first
	 * @param last
	 * @param title
	 * @param date
	 * @param publisher
	 * 
	 */
	public Source(/*String source,*/ SourceType sourceType, String first,String last, String title,String date, String publisher, String medium){

		/*this.source=source;*/
		this.sourceType = sourceType;
		this.first=first;
		this.last=last;
		this.title=title;
		this.date=date;
		this.publisher=publisher;
		this.medium=medium;
	}
	
	/*
	public String getsource(){
		return source;
	}
	*/
	
	public SourceType getSourceType() {
		return sourceType;
	}
	
	public String getfirst(){
		return first;
	}
	public String getlast(){
		return last;
	}
	public String gettitle(){
		return title;
	}
	public String getdate(){
		return date;
	}
	public String getpublisher(){
		return publisher;
	}

	public String getmedium(){
		return medium;
	}

	/*
	public void setsource(String source){
		this.source=source;
	}
	*/
	public void setfirst(String first){
		System.out.println("Setting first name to " + first);
		this.first=first;
		setChanged();
		notifyObservers();
	}
	public void setlast(String last){
		System.out.println("Setting last name to " + last);
		this.last=last;
		setChanged();
		notifyObservers();
	}
	public void settitle(String title){
		System.out.println("Setting title to " + title);
		this.title=title;
		setChanged();
		notifyObservers();
	}
	public void setdate(String date){
		System.out.println("Setting date to " + date);
		this.date=date;
		setChanged();
		notifyObservers();
	}
	public void setpublisher(String publisher){
		System.out.println("Setting publisher to " + publisher);
		this.publisher=publisher;
		setChanged();
		notifyObservers();
	}
	public void setmedium(String medium){
		System.out.println("Setting medium to " + medium);
		this.medium=medium;
		setChanged();
		notifyObservers();
	}


}

