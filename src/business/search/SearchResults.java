package business.search;

import java.util.ArrayList;

import models.User;

public class SearchResults {

	private ArrayList<User> userResults;
	
	public SearchResults(){
		userResults = new ArrayList<>();
	}

	public ArrayList<User> getUserResults() {
		return userResults;
	}

	public void setUserResults(ArrayList<User> userResults) {
		this.userResults = userResults;
	}
	
	
}
