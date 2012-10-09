package business.search;

import java.util.ArrayList;
import java.util.List;

import models.User;

import business.user.UserHandler;

public class SearchEngine {

	private UserHandler userHandler;

	public SearchEngine(){
		userHandler = new UserHandler();
	}

	public SearchResult search(String query){
		query.toLowerCase();
		query.trim();
		SearchResult result = new SearchResult();

		result.setUserResults(searchForUsers(query));




		return result;
	}

	private ArrayList<UserResult> searchForUsers(String query){
		ArrayList<UserResult> userResults = new ArrayList<UserResult>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().startsWith(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if(tmpUser.getLastName().startsWith(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}
		}
		if(userResults.isEmpty()){
			int dottedStringLength = query.length()-2;
			String dottedString = "";
			for (int i=0;i<dottedStringLength;i++){
				dottedString +=".";
			}
			query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
			
			for(int i=0;i<userHandler.getUserListSize();i++){
				tmpUser=userHandler.getUserByIndex(i);
				if(tmpUser.getFirstName().startsWith(query)){
					userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
				}else if(tmpUser.getLastName().startsWith(query)){
					userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
				}
			}
		}

		return userResults;

	}



}
