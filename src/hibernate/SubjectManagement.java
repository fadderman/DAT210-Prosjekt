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
	
	public void createSubject(String title, String description, Category category){
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
	
	public void addSubject(Subject subject){
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
	
	//TODO only for a quick test. Will be removed/moved to a unit test later.
		public void listAllSubjects( ){
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				
				//TODO fix errors!
				List<Subject> subjects = session.createQuery("FROM models.Subject").list(); 
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
		//TODO ModifySubject and lookupSubject methods on desired fields.
}
