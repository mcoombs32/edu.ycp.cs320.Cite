package edu.ycp.cs320.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class MapPersistance  extends Observable implements PersistanceInterface {

	private Map<String,Citation> citeMap;
	
	public MapPersistance(){
		this.citeMap = new HashMap<String,Citation>();
	}
	@Override
	public void saveCitation(Citation cite) {
		boolean exists = false;
		if (citeMap.containsKey(cite.getSource().gettitle().toLowerCase())){
			exists = true;
		}else if (!exists)
			citeMap.put(cite.getSource().gettitle().toLowerCase(), cite);
		notifyObservers();
	}

	@Override
	public Citation findCite(String title) {
		if (citeMap.containsKey(title)){
			return citeMap.get(title);
			}
		else{
			return null;
	}
	}

}
