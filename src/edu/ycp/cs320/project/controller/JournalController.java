package edu.ycp.cs320.project.controller;

import edu.ycp.cs320.project.Journal;

public class JournalController {

	private Journal model;
	
	public void setModel(Journal model){
		this.model = model;
	}
	public void setFirstName(String text) {
		model.setfirst(text);
	}

	public void setLastName(String text) {
		model.setlast(text);
	}

	public void setTitle(String text){
		model.settitle(text);
	}
	
	public void setDate(String text){
		model.setdate(text);
	}

	public void setPublisher(String text){
		model.setpublisher(text);
	}
	
	public void setVolume(String text){
		model.setvolume(text);
	}
	
	public void setPagenumber(String text){
		model.setpagenumber(text);
	}
	public void setmedium(String text) {
		model.setmedium(text);
		
	}
	
}
