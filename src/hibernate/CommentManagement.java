package hibernate;

import models.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CommentManagement {
	
	private static SessionFactory sessionFactory;
	
	public CommentManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void createCoomment(Connection connection, User author, String content){
		Comment comment = new Comment(connection, author, content);
		addComment(comment);
	}

	private void addComment(Comment comment) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(comment); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
	}

}
