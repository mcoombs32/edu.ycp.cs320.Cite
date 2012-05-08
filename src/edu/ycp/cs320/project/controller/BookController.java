package edu.ycp.cs320.project.controller;

import edu.ycp.cs320.project.Book;

public class BookController {
	private Book model;
	
	public void setModel(Book model) {
		this.model = model;
	}

	public void setFirstName(String text) {
		model.setfirst(text);
	}

	public void setLastName(String text) {
		model.setlast(text);
	}

	public void setTitle(String text) {
		model.settitle(text);
		
	}

	public void setPub(String text) {
		model.setpublisher(text);
		
	}

	public void setdate(String text) {
		model.setdate(text);
		
	}

	public void setcity(String text) {
		model.setcity(text);
		
	}
	public void setmedium(String text) {
		model.setmedium(text);
		
	}
	


}
