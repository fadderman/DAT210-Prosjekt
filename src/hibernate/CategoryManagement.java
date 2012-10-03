package hibernate;

import java.util.Iterator;
import java.util.List;

import models.Category;
import models.Subject;

import org.hibernate.HibernateException;
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
		addToDatabase(category);
	}

	public List<Category> getAllCategories(){
		String queryString = ("FROM models.Category where active = true"); 
		List<Category> results = fetch(queryString);
		toString(results); //TODO primarily for testing, prints to console
		return results;
	}

	public List<Category> getByTitle(String title){
		String queryString = "from models.Category where title = :title";
		String queryVariable = "title";
		return fetch(queryString, queryVariable, title);
	}
	public Category getSingleByTitle(String title){
		String queryString = "from models.Category where title = :title";
		String queryVariable = "title";
		return (Category) fetchSingle(queryString, queryVariable, title);
	}

	public List<Category> getByID(int id){
		String queryString = "from models.Category WHERE id = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, new Integer(id));
	}

	public void updateTitle(Category category, String newTitle){
		String queryString = "update models.Category set title = :newTitle where id = :id";
		String newQueryVariable = "newTitle";
		updateSingle(queryString, newQueryVariable, newTitle, category.getCategoryID());
	}

	public void updateDescription(Category category, String newDescription){
		String queryString = "update models.Category set description = :newDescription where id = :id";
		String newQueryVariable = "newDescription";
		updateSingle(queryString, newQueryVariable, newDescription, category.getCategoryID());
	}
	
	public List<Subject> fetchSubjectList(Category category){
		String queryString = "from models.Subject where category = :categoryID";
		String queryVariable = "categoryID";
		Integer categoryInt = new Integer(category.getCategoryID());
		return fetch(queryString, queryVariable, categoryInt);
	}
	
	public void toString(List<Category> categories){
		for (Iterator<Category> iterator = categories.iterator(); iterator.hasNext();){
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
	}
}
