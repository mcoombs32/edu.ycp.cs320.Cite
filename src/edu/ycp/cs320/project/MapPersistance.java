package edu.ycp.cs320.project;

import java.util.Map;
import java.util.Observable;

public class MapPersistance  extends Observable implements PersistanceInterface {

	private Map<String,Citation> citeMap;
	@Override
	public void saveCitation(Citation cite) {
		boolean exists = false;
		if (citeMap.containsValue(cite)){
			exists = true;
		}else if (!exists)
			citeMap.put(cite.getSource().gettitle(), cite);
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
