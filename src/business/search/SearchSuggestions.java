package business.search;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestions {

	private ArrayList<UserSuggestion> userResults;
	
	public SearchSuggestions(){
		userResults = new ArrayList<UserSuggestion>();
	}

	public ArrayList<UserSuggestion> getUserResults() {
		return userResults;
	}

	public void setUserResults(ArrayList<UserSuggestion> userResults) {
		this.userResults = userResults;
	}

}
