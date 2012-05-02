package edu.ycp.cs320.project;

public class Citation {
	private FormatType format;
	/*
	private Book book;
	 */

	private Source source;
	

	/**
	 * Constructor for a book citation.
	 * 
	 * @param book     the book
	 * @param format   the format in which to generation the citation
	 * @param source2  additional source associated with the book (for example, the book's website)
	 */
	public Citation(Source source,FormatType format){


		this.format=format;
		//this.book=book;
		this.source =source;
		//this.source2=source2;
	}


	public FormatType getformat() {
		// TODO Auto-generated method stub
		return format;
	}

	public String toString() {

		return source.toString();
	}

	/*public String getsource(){
		return source2;
	}*/

	public Source getSource(){
		return this.source;
	}
	public Book getbook(){
		return (Book) source;
	}
	public Website getwebsite(){
		return (Website) source;
	}
	public Journal getjournal(){
		return (Journal) source;
	}
	public Periodical getmagazine(){
		return (Periodical) source;
	}


	public void setformattype(FormatType format){
		this.format=format;
	}


	public String formatcit() {
		String cit = null;
		if(getformat().equals(FormatType.MLA)){
			cit=printmla();
		}
		if(getformat().equals(FormatType.APA)){
			cit=printapa();
		}
		if(getformat().equals(FormatType.CHICAGO)){
			cit=printchicago();
		}
		return cit;

	}

	private String printchicago() {
		String cit = null;

		// TODO Auto-generated method stub



		if(source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+", "+getbook().getfirst()+". "+getbook().gettitle()+" "+getbook().getcity()+": "+getbook().getpublisher()+", "+getbook().getdate()+".";


		}

		if(source.getSourceType() == SourceType.PERIODICAL){


			cit=getmagazine().getlast()+", "+getmagazine().getfirst()+". \""+getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+", "+getmagazine().getdate()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst()+". \""+getwebsite().gettitle()+"\". "+getwebsite().getwebsite()+", Last modified "+getwebsite().getdate()+". "+"Accessed"+" "+((Website) source).getmonth(getwebsite().getaccess().substring(0,2))+" "+getwebsite().getaccess().substring(3,5)+", "+getwebsite().getaccess().substring(6,10)+". "+getwebsite().geturl()+".";
		}
		if(source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+", "+getjournal().getfirst()+". \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+" "+getjournal().getvolume()+" ("+getjournal().getdate()+"): "+getjournal().getpagenumber();

		}
		return cit;
	}
	
	private String printapa() {
		String cit=null;


		if(source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+", "+getbook().getfirst().charAt(0)+". ("+getbook().getdate()+"). "+getbook().gettitle()+". "+getbook().getcity()+": "+getbook().getpublisher()+".";
		}



		if(source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+", "+getbook().getfirst().charAt(0)+". ("+getbook().getdate()+"). "+getbook().gettitle()+". "+getbook().getcity()+": "+getbook().getpublisher()+".";
		}

		if(source.getSourceType() == SourceType.PERIODICAL){


			cit=getmagazine().getlast()+", "+getmagazine().getfirst().charAt(0)+". ("+getmagazine().getdate()+"). \""+ getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+", "+getmagazine().getvolumenumber()+", "+getmagazine().getpagenumber()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst().charAt(0)+". ("+getwebsite().getdate()+"). \""+getwebsite().gettitle()+"\". Retrieved from "+getwebsite().geturl();
		}
		if(source.getSourceType() == SourceType.JOURNAL){

			cit=getjournal().getlast()+", "+getjournal().getfirst().charAt(0)+". ("+getjournal().getdate()+"). \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+", "+getjournal().getvolume()+", "+getjournal().getpagenumber()+".";

		}

		return cit;
	}



	private String printmla(){
		String cit=null;
		if(source.getSourceType() == SourceType.BOOK){

			cit=getbook().getlast()+", "+getbook().getfirst()+". "+getbook().gettitle()+". "+getbook().getcity()+": "+getbook().getpublisher()+", "+getbook().getdate()+". "+getbook().getmedium()+".";
				}



		if(source.getSourceType() == SourceType.PERIODICAL){


			cit=getmagazine().getlast()+", "+getmagazine().getfirst()+". \""+getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+" "+getmagazine().getdate()+": "+getmagazine().getpagenumber()+". "+getmagazine().getmedium()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst()+". \""+getwebsite().gettitle()+"\". "+getwebsite().getwebsite()+". "+getwebsite().getpublisher()+", " +getwebsite().getdate()+". "+getwebsite().getmedium()+". "+getwebsite().getaccess().substring(3,5)+" "+((Website) source).getmonth(getwebsite().getaccess().substring(0,2))+" "+getwebsite().getaccess().substring(6,10)+". <"+getwebsite().geturl()+">.";
		}
		if(source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+", "+getjournal().getfirst()+". \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+" "+getjournal().getvolume()+" ("+getjournal().getdate()+"): "+getjournal().getpagenumber()+". "+getjournal().getmedium()+".";
		}
		return cit;

	}




	private String getmonth(String substring) {
		if(substring=="01"){
			return "Jan";
		}
		if(substring=="02"){
			return "Feb";
		}
		if(substring=="03"){
			return "Mar";
		}
		if(substring=="04"){
			return "Apr";
		}
		if(substring=="05"){
			return "May";
		}
		if(substring=="06"){
			return "Jun";
		}
		if(substring=="07"){
			return "Jul";
		}
		if(substring=="08"){
			return "Aug";
		}
		if(substring=="09"){
			return "Sep";
		}	if(substring=="10"){
			return "Oct";
		}
		if(substring=="11"){
			return "Nov";
		}	if(substring=="12"){
			return "Dec";
		}
		return null;
	}
}








