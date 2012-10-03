package hibernate;

import models.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ConnectionManagement {

	private static SessionFactory sessionFactory;
	
	public ConnectionManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void createConnection(User mentor, User trainee, Subject subject, int difficultyLevel){
		Connection connection = new Connection(mentor, trainee, subject, difficultyLevel);
		addConnection(connection);
	}

	private void addConnection(Connection connection) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(connection); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}		
	}
}
