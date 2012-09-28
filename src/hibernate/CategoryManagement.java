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

public class CategoryManagement {
	
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
	//TODO Are categories to be removed from DB or just marked as "obsolete" or "unused"? Using "drop table" in SQL for testing.
	public void CategoryRemove(){
		
	}
	
	public void listAllCategories(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Category> categories = session.createQuery("FROM models.Category").list(); 
			for (Iterator<Category> iterator = 
					categories.iterator(); iterator.hasNext();){
				Category category = (Category) iterator.next(); 
				System.out.println("This has been pulled from the database:");
				System.out.println("Category: " + category.getTitle());
				System.out.println("Description: " + category.getDescription());
				if(category.getSubjectList().isEmpty()){
					System.out.println("Subject list is empty.");
				} else
				System.out.println("First subject in list: " + category.getSubjectList().get(1).getTitle());
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	public List<Category> getCategoryByTitle(Category category){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Category> categories = new ArrayList<Category>();
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM models.Category where title = :title");
			query.setString("title", category.getTitle());
			categories = query.list();			
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return categories;
	}

}
