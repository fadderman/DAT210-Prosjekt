package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Category;
import models.Subject;
import models.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CategoryManagement extends HibernateUtil{

	private static SessionFactory sessionFactory;

	public CategoryManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void createCategory(String title, String description){
		createCategory(title, description, null);
	}

	public void createCategory(String title, String description, Subject subject) {
		Category category = new Category(title, description, subject);
		addCategory(category);
	}

	public void addCategory(Category category){

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(category); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

	public List<Category> listAllCategories(){
		String queryString = ("FROM models.Category"); 
		List<Category> results = fetch(queryString);
		
		for (Iterator<Category> iterator = results.iterator(); iterator.hasNext();){
			Category category = (Category) iterator.next(); 
			System.out.println("This has been pulled from the database:");
			System.out.println("Category: " + category.getTitle());
			System.out.println("Description: " + category.getDescription());
			if(category.getSubjectList().isEmpty()){
				System.out.println("Subject list is empty.");
			} else {
				List<Subject> pulledSubjectList = category.getSubjectList();
				for(Iterator<Subject> itS = pulledSubjectList.iterator(); itS.hasNext();)
					System.out.println("Subject in list: " + itS.next().getTitle());
			}
		}
		return results;
	}

	public List<Category> getByTitle(String title){
		//Query query = session.createSQLQuery("SELECT s.title FROM SUBJECT s, CATEGORY c WHERE s.title = 'Java 3D' AND c.title = 'Java'");
		String queryString = "FROM models.Category where title = :title";
		String queryVariable = "title";
		return fetch(queryString, queryVariable, title);
	}

	public List<Category> getByID(int id){
		String queryString = "FROM models.Category WHERE id = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, new Integer(id));
	}

	public void updateTitle(Category category, String newTitle){
		String queryString = "update models.Category set title = :newTitle where title = :oldTitle and id = :id";
		String newQueryVariable = "newTitle";
		String oldQueryVariable = "oldTitle";
		updateSingle(queryString, oldQueryVariable, newQueryVariable, category.getTitle(), newTitle, category.getCategoryID());
	}

	public void updateDescription(){
		//TODO placeholder
	}
	
	public List<Subject> fetchSubjectList(Category category){
		String queryString = "FROM models.Subject where category = :categoryID";
		String queryVariable = "categoryID";
		Integer categoryInt = new Integer(category.getCategoryID());
		return fetch(queryString, queryVariable, categoryInt);
	}

	//TODO Are categories to be removed from DB or just marked as "obsolete" or "unused"? Using "drop table" in SQL for testing.
	public void CategoryRemove(){

	}
}
