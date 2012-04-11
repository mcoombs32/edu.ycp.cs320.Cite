package edu.ycp.cs320.project;

public  class Source {
private String source,first,last,title,date,publisher;
public Source(String source,String first,String last, String title,String date, String publisher){
this.source=source;
this.first=first;
this.last=last;
this.title=title;
this.date=date;
this.publisher=publisher;
}
public String getsource(){
	return source;
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
public void setsource(String source){
this.source=source;
	}
public void setfirst(String first){
this.first=first;
}
public void setlast(String last){
this.last=last;
	}
public void settitle(String title){
this.title=title;
	}
public void setdate(String date){
this.date=date;
	}
public void setpublisher(String publisher){
	this.publisher=publisher;
	
}
}