package edu.ycp.cs320.project.controller;

import edu.ycp.cs320.project.Book;
import edu.ycp.cs320.project.Citation;
import edu.ycp.cs320.project.FormatType;
import edu.ycp.cs320.project.Journal;
import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.Website;

public class CitationController {
	private Citation model;
	
	public void setModel(Citation model){
		this.model = model;
	}
	public void setFormat(FormatType text) {
		// TODO Auto-generated method stub
	model.setformattype(text);
	}
	public void setbook(Book book){
		model.setbook(book);
	}
	public void setwebsite(Website website){
		model.setwebsite(website);
	}
	public void setjournal(Journal journal){
		model.setjournal(journal);
	}
	public void setmagazine(Periodical periodical){
		model.setmagazine(periodical);
	}
	public void format() {
		// TODO Auto-generated method stub
		model.formatcit();
		
	}
}
