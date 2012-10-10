package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;

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
	
	public List<User> listAllUsers(){
		String queryString = ("from model.User where active = true");
		return fetch(queryString);
	}
	
	public List<User> listAllInactiveUsers(){
		String queryString = ("from model.User where active = false");
		return fetch(queryString);
	}
	
	public List<User> getByID(int id){
		String queryString = "from models.User where categoryID = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, new Integer(id));
	}
	
	public List<User> getByName(String firstName, String lastName){
		String queryString = "from models.User where firstName = :firstName and lastName = :lastName and active = true";
		String queryVariable1 = "firstName";
		String queryVariable2 = "lastName";
		return multiFetch(queryString, queryVariable1, queryVariable2, firstName, lastName);
	}
	
	public List<User> getByEmail(String email){
		String queryString = "from models.User where email = :email and active  = true";
		String queryVariable = "email";
		return fetch(queryString, queryVariable, email);
	}
	
	public List<User> getByLocation(String location){
		String queryString = "from models.User where location = :location and active = true";
		String queryVariable = "location";
		return fetch(queryString, queryVariable, location);
	}
	
	public List<User> getByOpenId(String identifierOpenID){
		String queryString = "from models.User where identifierOpenID = :identifierOpenID and active = true";
		String queryVariable = "identifierOpenID";
		return fetch(queryString, queryVariable, identifierOpenID);
	}
	
	public void updateFirstName(String newFirstName, User user){
		String queryString = "update models.User set firstName = :newFirstName where userID = :id";
		String queryVariable = "newFirstName";
		updateSingle(queryString, queryVariable, newFirstName, user.getUserID());
	}
	
	public void updateLastName(String newLastName, User user){
		String queryString = "update models.User set lastName = :newLastName where userID = :id";
		String queryVariable = "newLastName";
		updateSingle(queryString, queryVariable, newLastName, user.getUserID());
	}
	
	public void updateLocation(String newLocation, User user){
		String queryString = "update models.User set location = :newLocation where userID = :id";
		String queryVariable = "newLocation";
		updateSingle(queryString, queryVariable, newLocation, user.getUserID());
	}
	
	public void changeStatus(User user, boolean active){
		String queryString = "update models.User set active = :active where UserID = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, active, new Integer(user.getUserID()));
	}
	
	public List<Connection> fetchMentorConnection(User user){
		String queryString = "from models.Connection where mentor = :userID"; 
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Connection> fetchTraineeConnection(User user){
		String queryString = "from models.Connection where trainee = :userID"; 
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Comment> fetchCommentList(User user){
		String queryString = "from models.Comment where author = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}

	public List<User> getMentors(Subject subject){
		List<Connection> fetchedConnections = fetchConnectionList(subject);
		List<User> mentorList = new ArrayList<User>();
		String queryString = "from models.User user where :connectionID in elements(user.connectionMentor)";
		String queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			User listElement = (User) fetchSingle(queryString, queryVariable, current.getConnectionID());
			if(listElement != null)
				mentorList.add(listElement);
		}
		return mentorList;
	}
}