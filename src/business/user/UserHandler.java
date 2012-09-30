package business.user;

import hibernate.UserManagement;

import java.util.ArrayList;

import models.User;

public class UserHandler {
	
	private static ArrayList<User> users;		//holds all the users in the system
	private static UserManagement userManager;		//access to the database
	
	public UserHandler(){
		users = new ArrayList<User>();
//		userManager = new UserManagement();
	}

	public void addUser(User user) {
		synchronized (users) {
			users.add(user);
		}
	}

	public User getUserByIdentifier(String identifier) {
		if(identifier.isEmpty())return null;
		
		for(int i=0; i<users.size();i++){
			if(users.get(i).getIdentifier().equals(identifier)){
				return users.get(i);
			}
		}
		return null;
	}
	
}
