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

	}


