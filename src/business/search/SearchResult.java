package business.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

	private ArrayList<UserResult> userResults;
	
	public SearchResult(){
		userResults = new ArrayList<UserResult>();
	}

	public ArrayList<UserResult> getUserResults() {
		return userResults;
	}

	public void setUserResults(ArrayList<UserResult> userResults) {
		this.userResults = userResults;
	}

}
