package edu.ycp.cs320.project;

public class Website extends Source {
	
	
	public Website() {
		super(SourceType.WEBSITE);
	}
	
	private String url,access,website;
	public Website (SourceType sourceType,String first, String last, String title, String date,
			String publisher,String url, String access, String website) {
		super(SourceType.WEBSITE,first, last, title, date, publisher);
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
}
