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

}
