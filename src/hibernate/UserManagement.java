package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import models.User;

public class UserManagement {
	
	private static SessionFactory sessionFactory;

	private User user;
	
	public UserManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void UserCreate(String username, String firstName, String lastName, String email, String location){
		user = new User(username, firstName, lastName, email, location);
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	public void UserAdd(User user){
		this.user = user;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	//TODO Are users to be removed from DB or just marked as "obsolete" or "unused"?
	public void UserRemove(){
		
	}
	
	//TODO only for a quick test. Will be removed/moved to a unit test later.
	public void listAllUsers( ){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			//TODO fix errors!
			List users = session.createQuery("FROM USER").list(); 
			for (Iterator iterator = 
					users.iterator(); iterator.hasNext();){
				User user = (User) iterator.next(); 
				System.out.print("First Name: " + user.getFirstName()); 
				System.out.print("  Last Name: " + user.getLastName()); 
				System.out.println("  Username: " + user.getUsername()); 
				System.out.println("  email: " + user.getEmail());
				System.out.println("  Location: " + user.getLocation());
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	//TODO UserModify methods on desired fields.
}