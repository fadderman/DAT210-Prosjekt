package hibernate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;




public class FieldManagement extends HibernateUtil{

	

	public FieldManagement() {
		sessionFactory = getSessionFactory();
	}

	public boolean createField(String title, String description, Subject subject){
		return addField(new Field(title, description, subject));
	}

	public boolean addField(Field field){
		return addToDatabase(field);
	}
	
	public List<Field> getAllFields(){
		String queryString = ("from models.Field where active = true"); 
		return fetch(queryString);
	}
	public List<Field> getAllInactiveFields(){
		String queryString = ("from models.Field where active = false"); 
		return fetch(queryString);
	}
	
	public Field getByID(int id){
		String queryString = "from models.Field where id = :id";
		String queryVariable = "id";
		return (Field) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<Field> getByTitle(String title){
		String queryString = "from models.Field where title = :title and active = true";
		String queryVariable = "title";
		return fetch(queryString, queryVariable, title);
	}
	
	public Field getSingleByTitle(String title){
		String queryString = "from models.Field where title = :title and active = true";
		String queryVariable = "title";
		return (Field) fetchSingle(queryString, queryVariable, title);
	}
	
	public List<Field> getFieldsByParent(Field parent){
		String queryString = "from models.Field where parent = :parentID and active = true";
		String queryVariable = "parent";
		return fetch(queryString, queryVariable, new Integer(parent.getFieldID()));
	}
	
	public void updateTitle(Field field, String newTitle){
		String queryString = "update models.Field set title = :newTitle where id = :id";
		String queryVariable = "newTitle";
		updateSingle(queryString, queryVariable, newTitle, field.getFieldID());
	}
	
	public void updateDescription(Field field, String newDescription){
		String queryString = "update models.Field set description = :newDescription where id = :id";
		String queryVariable = "newDescription";
		updateSingle(queryString, queryVariable, newDescription, field.getFieldID());
	}
	
	public void setParentField(Field field, Field newParent){
		updateParentField(field, newParent);
	}
	
	public void updateParentField(Field field, Field newParent){
		String queryString = "update models.Field set parent = :newParent where id = :id";
		String queryVariable = "newParent";
		updateSingle(queryString, queryVariable, newParent, field.getFieldID());
	}
	
	public void removeParent(Field field){
		delete(field);
	}
	
	public List<Connection> fetchConnectionList(Field field){
		String queryString = "from models.Connection where field = :fieldID";
		String queryVariable = "fieldID";
		return fetch(queryString, queryVariable, new Integer(field.getFieldID()));
	}
	
	public void changeStatus(Field field, boolean active){
		String queryString = "update models.Field set active = :active where id = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, active, new Integer(field.getFieldID()));
	}
	
	public List<User> getMentors(Field field){
		List<Connection> fetchedConnections = fetchConnectionList(field);
		List<User> mentorList = new ArrayList<User>();
		String queryString = "from models.User user where :connectionID in elements(user.mentorConnection)";
		String queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			User listElement = (User) fetchSingle(queryString, queryVariable, new Integer(current.getConnectionID()));
			if(listElement != null)
				mentorList.add(listElement);
		}
		return mentorList;
	}
	
	public List<User> getTrainees(Field field){
		List<Connection> fetchedConnections = fetchConnectionList(field);
		List<User> traineeList = new ArrayList<User>();
		String queryString = "from models.User user where :connectionID in elements(user.traineeConnection)";
		String queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			User listElement = (User) fetchSingle(queryString, queryVariable, new Integer(current.getConnectionID()));
			if(listElement != null)
				traineeList.add(listElement);
		}
		return traineeList;
	}
	
	/*
	//TODO Broken many to many query.
	public List<User> fetchMentorList(Field field){
		//String queryString = "from models.User u, models.Field f where f.fieldID = :fieldID and f.fieldID in elements(u.mentorList)";
		String queryString = "from models.User as us, models.Field as f join us.f where f.id = :fieldID and f.fieldID in elements(us.mentorList)";
		String queryVariable = "fieldID";
		return fetch(queryString, queryVariable, field.getFieldID());
	}
	
	public List<User> fetchTraineeList(Field field){
		return null;
	}
	*/
}
