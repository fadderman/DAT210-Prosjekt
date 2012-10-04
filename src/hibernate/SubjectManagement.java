package hibernate;


import java.util.List;

import models.*;




public class SubjectManagement extends HibernateUtil{

	

	public SubjectManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void createSubject(String title, String description, Category category){
		Subject subject = new Subject(title, description, category);
		addSubject(subject);
	}

	public void addSubject(Subject subject){
		addToDatabase(subject);
	}


	//TODO only for a quick test. Will be removed/moved to a unit test later.
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
		String queryVariable = "categoryID";
		return fetch(queryString, queryVariable,  new Integer(subject.getSubjectID()));
	}





	//TODO ModifySubject and lookupSubject methods on desired fields.
}
