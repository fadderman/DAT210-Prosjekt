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
	private static boolean hasBeenRun = false;
	public void createDummyData(){
		if(!hasBeenRun){
			userHandler.addUser(new User("Thomas", "Hinna", "email", "Sandnes", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Thomas", "Nilsen", "email", "Liverpool", "United Kingdom", "identifierOpenID"));
			userHandler.addUser(new User("Morten", "Salte", "email", "Lyefjell", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Morten", "Bla", "email", "Sola", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Mango", "Bli", "email", "Bergen", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Thomas", "MMM", "email", "Oslo", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Morten", "Nilsen", "email", "Oslo", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Petter", "Salte", "email", "Stockholm", "Sweden", "identifierOpenID"));
			userHandler.addUser(new User("Alexander", "Bli", "email", "Oslo", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Bli", "Alexandersen", "email", "Stavanger", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Ørjan", "Rørheim", "email", "Stavanger", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Åge", "Håland", "email", "Ålesund", "Norway", "identifierOpenID"));
			userHandler.addUser(new User("Tom", "Nærland", "email", "Nærbø", "Norway", "identifierOpenID"));
			hasBeenRun=true;
		}
	}

	public SearchSuggestions suggest(String query){
		query = query.toLowerCase();
		query = query.trim();
		
		SearchSuggestions result = new SearchSuggestions();

		result.setUserResults(suggestUsers(query));
		return result;
	}

	public ArrayList<UserSuggestion> suggestUsers(String query){
		ArrayList<UserSuggestion> userSuggestions=suggestUsersUsingString(query);

		if(!userSuggestions.isEmpty())return userSuggestions;

		int dottedStringLength = query.length()-2;
		String dottedString = "";
		for (int i=0;i<dottedStringLength;i++){
			dottedString +=".";
		}
		query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
		userSuggestions = suggestUsersUsingDottedString(query);		
		return userSuggestions;

	}

	private ArrayList<UserSuggestion> suggestUsersUsingString(String query){
		ArrayList<UserSuggestion> userSuggestions = new ArrayList<UserSuggestion>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().startsWith(query)){
				userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if(tmpUser.getLastName().toLowerCase().startsWith(query)){
				userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if((tmpUser.getFirstName().toLowerCase() +" " + tmpUser.getLastName().toLowerCase()).startsWith(query)){
				userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}
		}
		return userSuggestions;
	}

	private ArrayList<UserSuggestion> suggestUsersUsingDottedString(String query){
		ArrayList<UserSuggestion> userSuggestions = new ArrayList<UserSuggestion>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().matches(query)){
				userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if(tmpUser.getLastName().toLowerCase().matches(query)){
				userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if((tmpUser.getFirstName().toLowerCase() +" " +  tmpUser.getLastName().toLowerCase()).startsWith(query)){
			userSuggestions.add(new UserSuggestion(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
		}
		}
		return userSuggestions;
	}
	
	public SearchResults search(String query){
		query = query.toLowerCase();
		query = query.trim();
		SearchResults results = new SearchResults();
		results.setUserResults(searchForUsers(query));
		
		return results;
	}
	
	private ArrayList<User> searchForUsers(String query){
		ArrayList<User> userResults = searchForUsersUsingString(query);

		if(!userResults.isEmpty())return userResults;

		int dottedStringLength = query.length()-2;
		String dottedString = "";
		for (int i=0;i<dottedStringLength;i++){
			dottedString +=".";
		}
		query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
		userResults = searchForUsersUsingDottedString(query);
		
		return userResults;
	}
	
	private ArrayList<User> searchForUsersUsingString(String query) {
		ArrayList<User> userResults = new ArrayList<User>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().startsWith(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}else if(tmpUser.getLastName().toLowerCase().startsWith(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}else if((tmpUser.getFirstName().toLowerCase() +" " +  tmpUser.getLastName().toLowerCase()).startsWith(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}
		}
		return userResults;
	}
	
	private ArrayList<User> searchForUsersUsingDottedString(String query) {
		ArrayList<User> userResults = new ArrayList<User>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().matches(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}else if(tmpUser.getLastName().toLowerCase().matches(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}else if((tmpUser.getFirstName().toLowerCase() +" " +  tmpUser.getLastName().toLowerCase()).startsWith(query)){
				userResults.add(userHandler.getUserByIndex(i));
			}
		}
		return userResults;
	}
	
}
