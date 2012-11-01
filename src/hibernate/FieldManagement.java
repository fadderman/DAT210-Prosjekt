package hibernate;


import java.util.*;

import org.hibernate.NonUniqueResultException;

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
	
	public List<Field> getByParent(Field parent){
		List<FieldTree> fetchedTrees = new ArrayList<FieldTree>();
		List<Field> children = new ArrayList<Field>();
		String queryString = "from models.FieldTree where parent = :parentID and active = true";
		String queryVariable = "parentID";
		fetchedTrees = fetch(queryString, queryVariable, new Integer(parent.getFieldID()));
		
		for(Iterator<FieldTree> i = fetchedTrees.iterator(); i.hasNext();){
			FieldTree current = i.next();
			Field nextChild = getByID(current.getChild().getFieldID());
			if(nextChild.isActive()) children.add(nextChild);
		}
		return children;
	}
	
	public List<Field> getByChild(Field child){
		List<FieldTree> fetchedTrees = new ArrayList<FieldTree>();
		List<Field> parents = new ArrayList<Field>();
		String queryString = "from models.FieldTree where child = :childID and active = true";
		String queryVariable = "childID";
		fetchedTrees = fetch(queryString, queryVariable, new Integer(child.getFieldID()));
		
		for(Iterator<FieldTree> i = fetchedTrees.iterator(); i.hasNext();){
			FieldTree current = i.next();
			Field nextParent = getByID(current.getParent().getFieldID());
			if(nextParent.isActive()) 
				parents.add(nextParent);
		}
		return parents;
	}
	
	public FieldTree getSingleBranch(Field child, Field parent){
		List<FieldTree> list = new ArrayList<FieldTree>();
		String queryString = "from models.FieldTree where child = :childID and parent = :parentID";
		String queryVariable1 = "childID";
		String queryVariable2 = "parentID";
		list = multiFetch(queryString, queryVariable1, queryVariable2, new Integer(child.getFieldID()), new Integer(parent.getFieldID()));
		if(list.size() > 1)
			throw new NonUniqueResultException(list.size());		
		return list.get(0);
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
	
	public void buildTree(Field child, Field parent){
		FieldTree newTreeElement = new FieldTree(child, parent);
		addToDatabase(newTreeElement);
	}
	
	public void toggleBranchStatus(Field child, Field parent, boolean active){
		String queryString = "update models.FieldTree set active = :active where child = :id1 and parent = :id2";
		String queryUpdateVariable = "active";
		multiCriteriaUpdate(queryString, queryUpdateVariable, active, new Integer(child.getFieldID()), new Integer(parent.getFieldID()));
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
