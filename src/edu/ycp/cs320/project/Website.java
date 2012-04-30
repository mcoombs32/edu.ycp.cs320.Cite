package edu.ycp.cs320.project;

public class Website extends Source {
	
	
	public Website() {
		super(SourceType.WEBSITE);
	}
	
	private String url,access,website;
	public Website (SourceType sourceType,String first, String last, String title, String date,

			String publisher,String url, String access, String website,String medium) {
		super(SourceType.WEBSITE,first, last, title, date, publisher,medium);

		// TODO Auto-generated constructor stub
		this.url=url;
		this.access=access;
		this.website=website;
	}
	
	public String geturl(){
		return url;
		}
	public String getaccess(){
		return access;
		}
	public String getwebsite(){
		return website;
		}
	public void seturl(String url){
		System.out.println("Setting url to " + url);
		this.url=url;
		setChanged();
		notifyObservers();
		}
	public void setaccess(String access){
		System.out.println("Setting access to " + access);
		this.access=access;
		setChanged();
		notifyObservers();
		}
	public void setwebsite(String website){
		System.out.println("Setting website to " + website);
		this.website=website;
		setChanged();
		notifyObservers();
		}

	public String getmonth(String substring) {
		if(substring.equals("01")){
			return "Jan.";
		}
		if(substring.equals("02")){
			return "Feb.";
		}
		if(substring.equals("03")){
			return "Mar.";
		}
		if(substring.equals("04")){
			return "Apr.";
		}
		if(substring.equals("05")){
			return "May";
		}
		if(substring.equals("06")){
			return "Jun.";
		}
		if(substring.equals("07")){
			return "Jul.";
		}
		if(substring.equals("08")){
			return "Aug.";
		}
		if(substring.equals("09")){
			return "Sep.";
		}
		if(substring.equals("10")){
			return "Oct.";
		}
		if(substring.equals("11")){
			return "Nov.";
		}
		if(substring.equals("12")){
			return "Dec.";
		}
		
		
		return null;
	}
}
