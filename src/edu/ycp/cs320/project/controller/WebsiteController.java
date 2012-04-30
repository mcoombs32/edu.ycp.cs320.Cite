package edu.ycp.cs320.project.controller;

import edu.ycp.cs320.project.Website;

public class WebsiteController {
		private Website model;
		
		public void setModel(Website model) {
			this.model = model;
		}

		public void setFirstName(String text) {
			model.setfirst(text);
		}

		public void setLastName(String text) {
			model.setlast(text);
		}

		public void setURL(String text) {
			model.seturl(text);
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
		
		public void setAccess(String text){
			model.setaccess(text);
		}
		
		public void setWebsite(String text){
			model.setwebsite(text);
		}
		public void setmedium(String text) {
			model.setmedium(text);
			
		}
	}


