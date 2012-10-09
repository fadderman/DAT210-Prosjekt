package business.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

	private List<UserResult> userResults;
	
	public SearchResult(){
		userResults = new ArrayList<UserResult>();
	}

	public List<UserResult> getUserResults() {
		return userResults;
	}

	public void setUserResults(List<UserResult> userResults) {
		this.userResults = userResults;
	}

}
