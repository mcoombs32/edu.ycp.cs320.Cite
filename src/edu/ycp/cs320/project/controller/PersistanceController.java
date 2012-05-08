package edu.ycp.cs320.project.controller;
import edu.ycp.cs320.project.Citation;
import edu.ycp.cs320.project.MapPersistance;


public class PersistanceController {

	private MapPersistance map;
	
	public void save(Citation cite){
		map.saveCitation(cite);
	}
}
