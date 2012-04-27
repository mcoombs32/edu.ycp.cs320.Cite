package edu.ycp.cs320.project.controller;

import edu.ycp.cs320.project.Periodical;

public class PeriodicalController {
	private Periodical model;

	public void setModel(Periodical model){
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

	public void setPageNumber(String text){
		model.setpagenumber(text);	
	}
	
	public void setVolume(String text){
		model.setvolume(text);
	}
	
	public void setMagazineName(String text){
		model.setmagazine(text);
	}
	

}
