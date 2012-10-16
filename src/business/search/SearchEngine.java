package business.search;

import java.util.ArrayList;

import models.Subject;
import models.User;
import business.subject.SubjectHandler;
import business.user.UserHandler;

public class SearchEngine {

	private UserHandler userHandler;
	private SubjectHandler subjectHandler;

	public SearchEngine(){
		userHandler = new UserHandler();
		subjectHandler = new SubjectHandler();
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
			subjectHandler.addSubject(new Subject("Java", "description"));
			subjectHandler.addSubject(new Subject("C++", "description"));
			subjectHandler.addSubject(new Subject("C#", "description"));
			subjectHandler.addSubject(new Subject("Javascript", "description"));
			subjectHandler.addSubject(new Subject("Go", "description"));
			subjectHandler.addSubject(new Subject("Python", "description"));
			subjectHandler.addSubject(new Subject("C", "description"));
			hasBeenRun=true;
		}
	}

	public SearchSuggestions suggest(String query){
		query = query.toLowerCase();
		query = query.trim();
		
		SearchSuggestions result = new SearchSuggestions();

		result.setUserSuggestions(suggestUsers(query));
		result.setSubjectSuggestions(suggestSubjects(query));
		return result;
	}

	public ArrayList<UserSuggestion> suggestUsers(String query){
		ArrayList<UserSuggestion> userSuggestions=suggestUsersUsingString(query);

		if(!userSuggestions.isEmpty())return userSuggestions;

//		int dottedStringLength = query.length()-2;
//		String dottedString = "";
//		for (int i=0;i<dottedStringLength;i++){
//			dottedString +=".";
//		}
//		query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
		
		query = createDottedString(query);
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
	
	private String createDottedString(String query){
		int dottedStringLength = query.length()-2;
		String dottedString = "";
		for (int i=0;i<dottedStringLength;i++){
			dottedString +=".";
		}
		return query.charAt(0) + dottedString + query.charAt(query.length()-1);
	}

	public SearchResults search(String query){
		query = query.toLowerCase();
		query = query.trim();
		SearchResults results = new SearchResults();
		results.setUserResults(searchForUsers(query));
		results.setSubjectResults(searchForSubjects(query));
		return results;
	}

	private ArrayList<User> searchForUsers(String query){
		ArrayList<User> userResults = searchForUsersUsingString(query);

		if(!userResults.isEmpty())return userResults;

//		int dottedStringLength = query.length()-2;
//		String dottedString = "";
//		for (int i=0;i<dottedStringLength;i++){
//			dottedString +=".";
//		}
//		query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
		query = createDottedString(query);
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
	
	
	private ArrayList<SubjectSuggestion> suggestSubjects(String query) {
		ArrayList<SubjectSuggestion> subjectSuggestions=suggestSubjectUsingString(query);

		if(!subjectSuggestions.isEmpty())return subjectSuggestions;
		
		query = createDottedString(query);
		subjectSuggestions = suggestSubjectUsingDottedString(query);
		
		return subjectSuggestions;
	}

	private ArrayList<SubjectSuggestion> suggestSubjectUsingString(String query) {
		ArrayList<SubjectSuggestion> subjectSuggestion = new ArrayList<SubjectSuggestion>();
		Subject tmpSubject;
		for(int i=0;i<subjectHandler.getSubjectListSize();i++){
			tmpSubject=subjectHandler.getSubjectByIndex(i);
			if(tmpSubject.getTitle().toLowerCase().startsWith(query)){
				subjectSuggestion.add(new SubjectSuggestion(tmpSubject.getTitle()));
			}
		}
		
		return subjectSuggestion;
	}
	
	private ArrayList<SubjectSuggestion> suggestSubjectUsingDottedString(String query) {
		ArrayList<SubjectSuggestion> subjectSuggestion = new ArrayList<SubjectSuggestion>();
		Subject tmpSubject;
		for(int i=0;i<subjectHandler.getSubjectListSize();i++){
			tmpSubject=subjectHandler.getSubjectByIndex(i);
			if(tmpSubject.getTitle().toLowerCase().matches(query)){
				subjectSuggestion.add(new SubjectSuggestion(tmpSubject.getTitle()));
			}
		}
		
		return subjectSuggestion;
	}
	
	private ArrayList<Subject> searchForSubjects(String query) {
		ArrayList<Subject> subjectResults=searchForSubjectUsingString(query);

		if(!subjectResults.isEmpty())return subjectResults;
		
		query = createDottedString(query);
		subjectResults = searchForSubjectUsingDottedString(query);
		
		return subjectResults;
	}

	
	private ArrayList<Subject> searchForSubjectUsingString(String query) {
		ArrayList<Subject> subjectResults = new ArrayList<Subject>();
		Subject tmpSubject;
		for(int i=0;i<subjectHandler.getSubjectListSize();i++){
			tmpSubject=subjectHandler.getSubjectByIndex(i);
			if(tmpSubject.getTitle().toLowerCase().startsWith(query)){
				subjectResults.add(tmpSubject);
			}
		}
		return subjectResults;
	}
	
	private ArrayList<Subject> searchForSubjectUsingDottedString(String query) {
		ArrayList<Subject> subjectResults = new ArrayList<Subject>();
		Subject tmpSubject;
		for(int i=0;i<subjectHandler.getSubjectListSize();i++){
			tmpSubject=subjectHandler.getSubjectByIndex(i);
			if(tmpSubject.getTitle().toLowerCase().matches(query)){
				subjectResults.add(tmpSubject);
			}
		}
		return subjectResults;
	}

	

}
