package hibernate;

import java.util.List;

import models.Subject;
import models.Field;

public class SubjectManagement extends HibernateUtil{

	public SubjectManagement() {
		sessionFactory = getSessionFactory();
	}

	public boolean createSubject(String title, String description){
		return createSubject(title, description, null);
	}

	public boolean createSubject(String title, String description, Field field) {
		Subject subject = new Subject(title, description, field);
		return addSubject(subject);
	}

	public boolean addSubject(Subject subject){
		return addToDatabase(subject);
	}

	public List<Subject> getAllSubjects(){
		String queryString = ("from models.Subject where active = true"); 
		List<Subject> results = fetch(queryString);
		return results;
	}

	public List<Subject> getAllInactiveSubjects(){
		String queryString = ("from models.Subject where active = false"); 
		List<Subject> results = fetch(queryString);
		return results;
	}
	
	public Subject getByID(int id){
		String queryString = "from models.Subject where subjectID = :id";
		String queryVariable = "id";
		return (Subject) fetchSingle(queryString, queryVariable, new Integer(id));
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
	
	public void changeStatus(Subject subject, boolean active){
		String queryString = "update models.Subject set active = :active where id = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, active, new Integer(subject.getSubjectID()));
	}
	
	public List<Field> fetchFieldList(Subject subject){
		String queryString = "from models.Field where subject = :subjectID";
		String queryVariable = "subjectID";
		return fetch(queryString, queryVariable, new Integer(subject.getSubjectID()));
	}
	
	/* TODO for testing
	public void toString(List<Subject> categories){
		for (Iterator<Subject> iterator = categories.iterator(); iterator.hasNext();){
			Subject subject = (Subject) iterator.next(); 
			System.out.println("This has been pulled from the database:");
			System.out.println("Subject: " + subject.getTitle());
			System.out.println("Description: " + subject.getDescription());
			if(subject.getFieldList().isEmpty()){
				System.out.println("Field list is empty.");
			} else {
				List<Field> pulledFieldList = subject.getFieldList();
				for(Iterator<Field> itS = pulledFieldList.iterator(); itS.hasNext();)
					System.out.println("Field in list: " + itS.next().getTitle());
			}
		}
	}*/
}
