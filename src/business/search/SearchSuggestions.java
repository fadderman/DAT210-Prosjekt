package business.search;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestions {

	private ArrayList<UserSuggestion> userSuggestions;
	private ArrayList<SubjectSuggestion> subjectSuggestions;
	
	public SearchSuggestions(){
		userSuggestions = new ArrayList<UserSuggestion>();
		subjectSuggestions = new ArrayList<SubjectSuggestion>();
	}

	public ArrayList<UserSuggestion> getUserSuggestions() {
		return userSuggestions;
	}

	public void setUserSuggestions(ArrayList<UserSuggestion> userSuggestions) {
		this.userSuggestions = userSuggestions;
	}

	public ArrayList<SubjectSuggestion> getSubjectSuggestions() {
		return subjectSuggestions;
	}

	public void setSubjectSuggestions(ArrayList<SubjectSuggestion> subjectSuggestions) {
		this.subjectSuggestions = subjectSuggestions;
	}
	
}
