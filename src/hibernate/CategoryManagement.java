package hibernate;

import java.util.Iterator;
import java.util.List;

import models.Category;
import models.Subject;
import models.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CategoryManagement {
	
	private static SessionFactory sessionFactory;
	
	private Category category;
	
	public CategoryManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void CategoryCreate(String title, String description, Subject subject) {
		Category category = new Category(title, description, subject);
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
	
	public void CategoryAdd(Category category){
		this.category = category;
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
			
			//TODO fix errors!
			List<Category> categories = session.createQuery("FROM USER").list(); 
			for (Iterator<Category> iterator = 
					categories.iterator(); iterator.hasNext();){
				Category category = (Category) iterator.next(); 
				System.out.println("Category: " + category.getTitle());
				System.out.println("Description: " + category.getDescription());
				System.out.println("Subjects: ");
				for(Iterator<Subject> subjectiterator = category.getSubjectList().iterator(); subjectiterator.hasNext();){
					System.out.println(subjectiterator.next().getTitle() + ", " + "Description: " + subjectiterator.next());
				}
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	//TODO change to pull one Class at a time
	public Category getCategory(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Category pulledCategory = new Category("Not Pulled", null, new Subject("Not pulled",null,null));
		try{
			tx = session.beginTransaction();
			
			//TODO fix errors!
			List<Category> categories = session.createQuery("FROM USER").list(); 
			for (Iterator<Category> iterator = 
					categories.iterator(); iterator.hasNext();){
				Category category = (Category) iterator.next(); 
				System.out.println("Category: " + category.getTitle());
				System.out.println("Description: " + category.getDescription());
				System.out.println("Subjects: ");
				for(Iterator<Subject> subjectiterator = category.getSubjectList().iterator(); subjectiterator.hasNext();){
					System.out.println(subjectiterator.next().getTitle() + ", " + "Description: " + subjectiterator.next());
				}
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return pulledCategory;
	}

}
