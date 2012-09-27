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

public class SubjectManagement {

	private static SessionFactory sessionFactory;

	private Subject subject;
	
	public SubjectManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void SubjectCreate(String title, String description, Category category){
		subject = new Subject(title, description, category);
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(subject); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	public void SubjectAdd(Subject subject){
		this.subject = subject;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(subject); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	//TODO Are subjects to be removed from DB or just marked as "obsolete" or "unused"? Using "drop table" in SQL for testing.
	public void SubjectRemove(){
		
	}
	
	//TODO only for a quick test. Will be removed/moved to a unit test later.
		public void listAllUsers( ){
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				
				//TODO fix errors!
				List<Subject> subjects = session.createQuery("FROM SUBJECT").list(); 
				for (Iterator<Subject> iterator = 
						subjects.iterator(); iterator.hasNext();){
					Subject subject = (Subject) iterator.next(); 
					System.out.print("Title: " + subject.getTitle()); 
					System.out.print("  Description: " + subject.getDescription()); 
					System.out.println("  Category: " + subject.getCategory()); 
				}
				tx.commit();
			}catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		}
		//TODO SubjectModify methods on desired fields.
}
