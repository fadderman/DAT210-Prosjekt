package business.search;

import java.util.ArrayList;

import models.Field;
import models.User;

public class SearchResults {

	private ArrayList<User> userResults;
	private ArrayList<Field> fieldResults;
	
	public SearchResults(){
		userResults = new ArrayList<>();
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
	
}
