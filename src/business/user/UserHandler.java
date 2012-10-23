package business.user;

import hibernate.UserManagement;

import java.util.ArrayList;

import models.User;

public class UserHandler {
	
	private static ArrayList<User> userList= new ArrayList<User>();
	private static UserManagement userManager;		//access to the database
	
	public UserHandler(){
//		users = new ArrayList<User>();
//		userManager = new UserManagement();
	}

	public static void addUser(User user) {
		synchronized (userList) {
			userList.add(user);
		}
	}

	public static User getUserByIdentifier(String identifier) {
		if(identifier.isEmpty())return null;
		
		for(int i=0; i<userList.size();i++){
			if(userList.get(i).getIdentifierOpenID().equals(identifier)){
				return userList.get(i);
			}
		}
		return null;
	}
	
	public static User getUserByIndex(int index){
		return userList.get(index);
	}
	
	public static int getUserListSize(){
		return userList.size();
	}
	
//	public static ArrayList<User> getUsersByID(ArrayList<UserSuggestion> usersToGet){
//		ArrayList<User> usersToReturn = new ArrayList<User>();
//		for(int i=0;i<userList.size();i++){
//			for(int j=0;j<usersToGet.size();j++){
//				if(usersToGet.get(j).getUserID() == userList.get(i).getUserID()){
//					usersToReturn.add(userList.get(i));
//					usersToGet.remove(j);
//				}
//			}			
//		}
//		return usersToReturn;
//	}
	
	
}
