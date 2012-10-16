package business.search;

import java.util.ArrayList;

import models.Subject;
import models.User;

public class SearchResults {

	private ArrayList<User> userResults;
	private ArrayList<Subject> subjectResults;
	
	public SearchResults(){
		userResults = new ArrayList<>();
		subjectResults = new ArrayList<Subject>();
	}

	public ArrayList<User> getUserResults() {
		return userResults;
	}

	public void setUserResults(ArrayList<User> userResults) {
		this.userResults = userResults;
	}

	public ArrayList<Subject> getSubjectResults() {
		return subjectResults;
	}

	public void setSubjectResults(ArrayList<Subject> subjectResults) {
		this.subjectResults = subjectResults;
	}
	
}
