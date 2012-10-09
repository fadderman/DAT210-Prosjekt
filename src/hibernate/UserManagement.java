package hibernate;

import java.util.List;

import models.Connection;
import models.User;

public class UserManagement extends HibernateUtil{
	
	public UserManagement() {
		sessionFactory = getSessionFactory();
	}

	public void createUser(String firstName, String lastName, String email, String location, String identifierOpenID){
		addUser(new User(firstName, lastName, email, location, identifierOpenID));
	}

	public void addUser(User user) {
		addToDatabase(user);
	}
	
	public List<Connection> getByName(String firstName, String lastName){
		String queryString = "from models.User where firstName = :firstName and lastName = :lastName and active = true";
		String queryVariable1 = "firstName";
		String queryVariable2 = "lastName";
		return multiFetch(queryString, queryVariable1, queryVariable2, firstName, lastName);
	}
	
	public List<Connection> getByEmail(String email){
		String queryString = "from models.User where email = :email and active  = true";
		String queryVariable = "email";
		return fetch(queryString, queryVariable, email);
	}
	
	public List<Connection> getByLocation(String location){
		String queryString = "from models.User where location = :location and active = true";
		String queryVariable = "location";
		return fetch(queryString, queryVariable, location);
	}
	
	public List<Connection> getByOpenId(String identifierOpenID){
		String queryString = "from models.User where identifierOpenID = :identifierOpenID and active = true";
		String queryVariable = "identifierOpenID";
		return fetch(queryString, queryVariable, identifierOpenID);
	}
}