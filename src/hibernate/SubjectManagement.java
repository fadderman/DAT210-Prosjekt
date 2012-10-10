package hibernate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;




public class SubjectManagement extends HibernateUtil{

	

	public SubjectManagement() {
		sessionFactory = getSessionFactory();
	}

	public void createSubject(String title, String description, Category category){
		Subject subject = new Subject(title, description, category);
		addSubject(subject);
	}

	public void addSubject(Subject subject){
		addToDatabase(subject);
	}
	
	public List<Subject> getAllSubjects(){
		String queryString = ("from models.Subject where active = true"); 
		return fetch(queryString);
	}
	public List<Subject> getAllInactiveSubjects(){
		String queryString = ("from models.Subject where active = false"); 
		return fetch(queryString);
	}
	
	public List<Subject> getByTitle(String title){
		String queryString = "from models.Subject where title = :title";
		String queryVariable = "title";
		return fetch(queryString, queryVariable, title);
	}
	
	public Subject getSingleByTitle(String title){
		String queryString = "from models.Subject where title = :title";
		String queryVariable = "title";
		return (Subject) fetchSingle(queryString, queryVariable, title);
	}
	
	public List<Subject> getByID(int id){
		String queryString = "from models.Subject WHERE id = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, new Integer(id));
	}
	
	public void updateTitle(Subject subject, String newTitle){
		String queryString = "update models.Subject set title = :newTitle where id = :id";
		String queryVariable = "newTitle";
		updateSingle(queryString, queryVariable, newTitle, subject.getSubjectID());
	}
	
	public void updateDescription(Subject subject, String newDescription){
		String queryString = "update models.Subject set description = :newDescription where id = :id";
		String queryVariable = "newDescription";
		updateSingle(queryString, queryVariable, newDescription, subject.getSubjectID());
	}
	
	public List<Connection> fetchConnectionList(Subject subject){
		String queryString = "from models.Connection where subject = :subjectID";
		String queryVariable = "subjectID";
		return fetch(queryString, queryVariable, new Integer(subject.getSubjectID()));
	}
	
	public List<User> getByMentorConnection(Subject subject){
		String queryString = "from models.Connection where subject.subjectID = :subjectID";
		String queryVariable = "subjectID";
		List<Connection> fetchedConnections = fetch(queryString, queryVariable, subject.getSubjectID());
		List<User> mentorList = new ArrayList();
		queryString = "from models.User user where :connectionID in elements(user.connectionMentor)";
		queryVariable = "connectionID";
		for(Iterator<Connection> iterator = fetchedConnections.iterator(); iterator.hasNext();){
			Connection current = iterator.next();
			mentorList.add((User) fetchSingle(queryString, queryVariable, current.getConnectionID()));
		}
		return mentorList;
	}
	
	public List<Connection> connectionGetTest(Subject subject){
		String queryString = "from models.Connection where subject.subjectID = :subjectID";
		String queryVariable = "subjectID";
		return fetch(queryString, queryVariable, new Integer(subject.getSubjectID()));
	}
	/*
	//TODO Broken many to many query.
	public List<User> fetchMentorList(Subject subject){
		//String queryString = "from models.User u, models.Subject s where s.subjectID = :subjectID and s.subjectID in elements(u.mentorList)";
		String queryString = "from models.User as us, models.Subject as sub join us.sub where sub.id = :subjectID and sub.subjectID in elements(us.mentorList)";
		String queryVariable = "subjectID";
		return fetch(queryString, queryVariable, subject.getSubjectID());
	}
	
	public List<User> fetchTraineeList(Subject subject){
		return null;
	}
	*/
}
