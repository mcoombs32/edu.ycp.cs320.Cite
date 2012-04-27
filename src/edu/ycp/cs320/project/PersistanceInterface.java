package edu.ycp.cs320.project;

public abstract interface PersistanceInterface {

	
	public abstract void saveCitation(Citation cite);
	
	public abstract Citation findCite(String title);
	
}
