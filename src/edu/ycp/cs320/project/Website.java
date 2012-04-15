package edu.ycp.cs320.project;

public class Website extends Source {
	private String url,access,website;
	public Website(SourceType sourceType,String first, String last, String title, String date,
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
		this.url=url;
		}
	public void setaccess(String access){
		this.access=access;
		}
	public void setwebsite(String website){
		this.website=website;
		}
}
