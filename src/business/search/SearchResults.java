package business.search;

import java.util.ArrayList;

import models.Field;
import models.User;

public class SearchResults {

	private ArrayList<User> userResults;
	private ArrayList<Field> fieldResults;
	
	public SearchResults(){
		userResults = new ArrayList<User>();
		fieldResults = new ArrayList<Field>();
	}

	public ArrayList<User> getUserResults() {
		return userResults;
	}

	public void setUserResults(ArrayList<User> userResults) {
		this.userResults = userResults;
	}

	public ArrayList<Field> getFieldResults() {
		return fieldResults;
	}

	public void setFieldResults(ArrayList<Field> fieldResults) {
		this.fieldResults = fieldResults;
	}
	
	public String getSearchResultsAsJSON() {
		String json = "";
		
		if(userResults.size() > 0 && fieldResults.size() > 0) {
			// results from both
			json = "";
			json += getUsersAsJSON(false);
			json += getFieldsAsJSON();
		} else if(userResults.size() > 0 && !(fieldResults.size() > 0)) {
			// results from users
			json = "";
			json += getUsersAsJSON(true);
		} else if(!(userResults.size() > 0) && fieldResults.size() > 0) {
			// results from fields
			json = "";
			json += getFieldsAsJSON();
		}

		return json;
	}
	
	private String getUsersAsJSON(boolean alone) {
		String json = "";
		User u;
		for(int i=0;i<userResults.size();i++) {
			u = userResults.get(i);
			json += "{\"label\": \"" + u.getFullName() + "\", \"category\": \"Users\"}";
			
			if(!(i+1 == userResults.size())) {
				// if it's not the last element, append comma
				json += ",";
			} else if(i+1 == userResults.size() && !alone) {
				// if it's the last element but user results were not the only results, append comma
				json += ",";
			} else {
				// do nothing
			}
		}
		
		return json;
	}
	
	private String getFieldsAsJSON() {
		String json = "";
		Field f;
		for(int i=0;i<fieldResults.size();i++) {
			f = fieldResults.get(i);
			json += "{\"label\": \"" + f.getTitle() + "\", \"category\": \"Field\"}";
			
			if(!(i+1 == fieldResults.size())) {
				// if it's not the last element, append comma
				json += ",";
			}
			
		}
		
		return json;
	}
	
}
