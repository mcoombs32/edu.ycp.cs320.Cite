package edu.ycp.cs320.project.controller;
import edu.ycp.cs320.project.Citation;
import edu.ycp.cs320.project.MapPersistance;


public class PersistanceController {

	private MapPersistance model;
	
	public void setModel(MapPersistance map){
		this.model = map;
	}
	public void save(Citation cite){
		model.saveCitation(cite);
	}
	public Citation Search(String title){
		return model.findCite(title);
	}

}
