package edu.ycp.cs320.project;

public class Citation {
	private String format;
	/*
	private Book book;
	*/
	private Website website;
	private Magazine magazine;
	private Journal journal;
	private Source source;
	//private String source2;
	
	/**
	 * Constructor for a book citation.
	 * 
	 * @param book     the book
	 * @param format   the format in which to generation the citation
	 * @param source2  additional source associated with the book (for example, the book's website)
	 */
	public Citation(Book book,String format/*,String source2*/){
		
	this.format=format;
	//this.book=book;
	this.source = book;
	//this.source2=source2;
	}

	public Citation(Website website,String format,String source2){
		
		this.website=website;
		this.format=format;
		//this.source2=source2;
	}
	public Citation(Magazine magazine,String format,String source2){
	this.magazine=magazine;
	this.format=format;
	//this.source2=source2;
	}

	public Citation(Journal journal,String format,String source2){
	this.journal=journal;
	this.format=format;
	//this.source2=source2;
	}

	public Citation() {
		this.journal=null;
		this.format=null;
		//this.source2=null;
		// TODO Auto-generated constructor stub
	}

	public String getformat() {
		// TODO Auto-generated method stub
		return format;
	}
	public String toString() {
        return source.toString();
}
	/*public String getsource(){
		return source2;
	}*/

	public Book getbook(){
		return (Book) source;
	}
	public Website getwebsite(){
		return website;
	}
	public Journal getjournal(){
		return journal;
	}
	public Magazine getmagazine(){
		return magazine;
	}
	/*
	public void setbook(Book book){
		this.book=book;
	}
	*/
	public void setwebsite(Website website){
		this.website=website;
	}
	public void setjournal(Journal journal){
		this.journal=journal;
	}
	public void setmagazine(Magazine magazine){
		this.magazine=magazine;
	}
	/*public String createdmla(){
		return source2;
	}*/

	public String formatcit() {
		String cit = null;
		if(getformat().equals("mla")){
			cit=printmla();
		}
		if(getformat().equals("apa")){
			cit=printapa();
		}
		if(getformat().equals("chicago")){
			cit=printchicago();
		}
		return cit;
		
	}

	private String printchicago() {
		String cit = null;
		// TODO Auto-generated method stub
		if(/*getsource().equals("book")*/source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+","+getbook().getfirst()+"."+getbook().gettitle()+"."+getbook().getcity()+","+getbook().getpublisher()+","+getbook().getdate();
				}
		if(/*getsource().equals("magazine")*/source.getSourceType() == SourceType.MAGAZINE){
			cit=getmagazine().getlast()+","+getmagazine().getfirst()+"."+getmagazine().gettitle()+"."+getmagazine().getmagazine()+","+getmagazine().getdate()+","+getmagazine().getpagenumber();
		}
		if(/*getsource().equals("website")*/source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+","+getwebsite().getfirst()+"."+getwebsite().gettitle()+"."+getwebsite().getdate()+","+getwebsite().geturl();
		}
		if(/*getsource().equals("journal")*/source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+","+getjournal().getfirst()+"."+getjournal().gettitle()+"."+getjournal().getjournal()+","+getjournal().getvolume()+","+getjournal().getpagenumber();
		}
		return cit;
	}

	private String printapa() {
		String cit=null;
		if(/*getsource().equals("book")*/source.getSourceType() == SourceType.BOOK){
			 cit=getbook().getlast()+","+getbook().getfirst()+","+getbook().gettitle()+","+getbook().getcity()+","+getbook().getpublisher();
				}
		if(/*getsource().equals("magazine")*/source.getSourceType() == SourceType.MAGAZINE){
			cit=getmagazine().getlast()+","+getmagazine().getfirst()+","+getmagazine().gettitle()+","+getmagazine().getmagazine()+","+getmagazine().getdate()+","+getmagazine().getpagenumber();
		}
		if(/*getsource().equals("website")*/source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+","+getwebsite().getfirst()+","+getwebsite().gettitle()+","+getwebsite().getpublisher()+","+getwebsite().getdate()+","+getwebsite().getaccess();
		}
		if(/*getsource().equals("journal")*/source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+","+getjournal().getfirst()+","+getjournal().gettitle()+","+getjournal().getpublisher()+","+getjournal().getdate()+","+getjournal().getpagenumber();
		}
		return cit;
	}
		
	

	private String printmla() {
		// TODO:title in quote
		String cit=null;
		if(/*getsource().equals("book")*/source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+","+getbook().getfirst()+"."+getbook().gettitle()+"."+getbook().getcity()+":"+getbook().getpublisher()+","+getbook().getdate()+".";
				}
		if(/*getsource().equals("magazine")*/source.getSourceType() == SourceType.MAGAZINE){
			cit=getmagazine().getlast()+","+getmagazine().getfirst()+"."+getmagazine().gettitle()+"."+getmagazine().getmagazine()+" "+getmagazine().getdate()+":"+getmagazine().getpagenumber();
		}
		if(/*getsource().equals("website")*/source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+","+getwebsite().getfirst()+","+getwebsite().gettitle()+","+getwebsite().getpublisher()+","+getwebsite().getdate()+","+getwebsite().getaccess();
		}
		if(/*getsource().equals("journal")*/source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+","+getjournal().getfirst()+"."+getjournal().gettitle()+"."+getjournal().getpublisher()+" "+getjournal().getvolume()+" ("+getjournal().getdate()+"):"+getjournal().getpagenumber();
		}
		return cit;
	}
	}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


