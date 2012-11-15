package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;

public class UserManagement extends HibernateUtil{
	
	public UserManagement() {
		sessionFactory = getSessionFactory();
	}

	public boolean createUser(String firstName, String lastName, String email, String locationCity, String locationCountry, String identifierOpenID){
		return addUser(new User(firstName, lastName, email, locationCity, locationCountry, identifierOpenID));
	}

	public boolean addUser(User user) {
		return addToDatabase(user);
	}
	
	public List<User> listAllUsers(){
		String queryString = ("from models.User where active = true");
		return fetch(queryString);
	}
	
	public List<User> listAllInactiveUsers(){
		String queryString = ("from models.User where active = false");
		return fetch(queryString);
	}
	
	public User getByID(int id){
		String queryString = "from models.User where userID = :id";
		String queryVariable = "id";
		return (User) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<User> getByName(String firstName, String lastName){
		String queryString = "from models.User where firstName = :firstName and lastName = :lastName and active = true";
		String queryVariable1 = "firstName";
		String queryVariable2 = "lastName";
		return multiFetch(queryString, queryVariable1, queryVariable2, firstName, lastName);
	}
	
	public User getByEmail(String email){
		String queryString = "from models.User where email = :email and active  = true";
		String queryVariable = "email";
		return (User) fetchSingle(queryString, queryVariable, email);
	}
	
	public List<User> getByLocation(String city, String country){
		String queryString = "from models.User where locationCity = :city and locationCountry = :country and active = true";
		String queryVariable1 = "city";
		String queryVariable2 = "country";
		return multiFetch(queryString, queryVariable1, queryVariable2, city, country);
	}

	
	public List<User> getByCity(String city){
		String queryString = "from models.User where locationCity = :city and active = true";
		String queryVariable = "city";
		return fetch(queryString, queryVariable, city);
	}
	
	public List<User> getByCountry(String country){
		String queryString = "from models.User where locationCountry = :country and active = true";
		String queryVariable = "country";
		return fetch(queryString, queryVariable, country);
	}

	public User getByOpenId(String identifierOpenID){

		String queryString = "from models.User where identifierOpenID = :identifierOpenID and active = true";
		String queryVariable = "identifierOpenID";
		return (User)fetchSingle(queryString, queryVariable, identifierOpenID);
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
	
	public void updateLocation(String newCity, String newCountry, User user){
		updateCity(newCity, user);
		updateCountry(newCountry, user);
	}
	
	public void updateEmail(String newEmail, User user){
		String queryString = "update models.User set email = :newEmail where userID = :id";
		String queryVariable = "newEmail";
		updateSingle(queryString, queryVariable, newEmail, user.getUserID());
	}
	
	public void updateCity(String newCity, User user){
		String queryString = "update models.User set locationCity = :newCity where userID = :id";
		String queryVariable = "newCity";
		updateSingle(queryString, queryVariable, newCity, user.getUserID());
	}
	
	public void updateCountry(String newCountry, User user){
		String queryString = "update models.User set locationCountry = :newCountry where userID = :id";
		String queryVariable = "newCountry";
		updateSingle(queryString, queryVariable, newCountry, user.getUserID());
	}
	
	public void changeStatus(User user, boolean active){
		String queryString = "update models.User set active = :active where userID = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, new Boolean(active), user.getUserID());
	}
	
	public List<Connection> fetchMentorConnections(User user){
		String queryString = "from models.Connection where mentor = :userID"; 
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Connection> fetchTraineeConnections(User user){
		String queryString = "from models.Connection where trainee = :userID"; 
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Comment> fetchCommentList(User user){
		String queryString = "from models.Comment where author = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}

	public List<Field> getMentorFields(User user){
		List<Connection> fetchedConnections = fetchMentorConnections(user);
		List<Field> mentorFieldList = new ArrayList<Field>();
		String queryString = "from models.Field field where :connectionID in elements(field.connectionList)";
		String queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			Field listElement = (Field) fetchSingle(queryString, queryVariable, new Integer(current.getConnectionID()));
			if(listElement != null)
				mentorFieldList.add(listElement);
		}
		return mentorFieldList;
	}
	
	public List<Field> getTraineeFields(User user){
		List<Connection> fetchedConnections = fetchTraineeConnections(user);
		List<Field> traineeFieldList = new ArrayList<Field>();
		String queryString = "from models.Field field where :connectionID in elements(field.connectionList)";
		String queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			Field listElement = (Field) fetchSingle(queryString, queryVariable, new Integer(current.getConnectionID()));
			if(listElement != null)
				traineeFieldList.add(listElement);
		}
		return traineeFieldList;
	}
}
