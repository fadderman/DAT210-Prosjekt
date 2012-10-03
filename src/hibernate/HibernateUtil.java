package hibernate;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {    	
		Configuration configuration = new Configuration();
		configuration.configure("../hibXml/hibernate.cfg.xml");
		ClassToDatabase classToDatabase = new ClassToDatabase();

		Iterator<Class> ctDBIterator = classToDatabase.getClassToDatabase().iterator();
		while(ctDBIterator.hasNext()){
			configuration.addAnnotatedClass(ctDBIterator.next());
		}

		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		try{
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}   
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public <T> List<T> fetch(String queryString){
		return fetch(queryString, null, null);
	}

	public <T> List<T> fetch(String queryString, String queryVariable, Object criteria){
		List<T> results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria == null){
				//force a skip on null values
			}
			else if(criteria.getClass() == String.class){
				query.setString(queryVariable, (String) criteria);
			}
			else if(criteria.getClass() == Integer.class){
				Integer critInt = (Integer) criteria;
				query.setInteger(queryVariable, critInt.intValue());
			}
			else if(criteria.getClass() == Date.class)
				query.setDate(queryVariable, (Date)criteria);
			results = query.list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return results;
	}

	public Object fetchSingle(String queryString, String queryVariable, Object criteria){
		Object result = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria == null){
				//force a skip on null values
			}
			else if(criteria.getClass() == String.class){
				query.setString(queryVariable, (String) criteria);
			}
			else if(criteria.getClass() == Integer.class){
				Integer critInt = (Integer) criteria;
				query.setInteger(queryVariable, critInt.intValue());
			}
			else if(criteria.getClass() == Date.class)
				query.setDate(queryVariable, (Date)criteria);
			result = query.uniqueResult();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return result;
	}

	public int updateSingle(String queryString, String oldQueryVariable, String newQueryVariable, Object oldValue, Object newValue, int id){
		int updateCounter = -1;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			if(oldValue.getClass() == String.class){
				query.setString(newQueryVariable, (String) newValue);
				query.setString(oldQueryVariable, (String) oldValue);
			}
			if(oldValue.getClass() == Integer.class){
				Integer newInt = (Integer) newValue;
				Integer oldInt = (Integer) oldValue;
				query.setInteger(newQueryVariable, newInt.intValue());
				query.setInteger(oldQueryVariable, oldInt.intValue());
			}
			if(oldValue.getClass() == Date.class)
				query.setDate(newQueryVariable, (Date) newValue);
			query.setDate(oldQueryVariable, (Date) oldValue);
			updateCounter = query.executeUpdate();
			if(updateCounter < 1)
				System.out.println("No entities updated.");
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}catch (Exception e){
			if(updateCounter > 1) tx.rollback();
			System.err.println("More than one value changed, update not applied.");
			e.printStackTrace();
		}finally {
			session.close(); 
		}	
		return updateCounter;
	}
}
