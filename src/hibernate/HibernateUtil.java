package hibernate;

import java.util.*;

import models.Connection;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	protected static SessionFactory sessionFactory;
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
	
	protected boolean addToDatabase(Object toBeAdded){
		Object identifier = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			identifier = session.save(toBeAdded); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
		
		if(identifier != null)
			return true;
		else
			return false;
	}
	
	protected <T> List<T> fetch(String queryString){
		return fetch(queryString, null, null);
	}

	protected <T> List<T> fetch(String queryString, String queryVariable, Object criteria){
		List<T> results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria == null){
				//force a skip on null values, criteria not needed for SELECT *
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
			else if(criteria.getClass() == Collection.class)
				query.setParameterList(queryVariable, (Collection) criteria);
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
	
	protected <T> List<T> multiFetch(String queryString, String queryVariable1, String queryVariable2, Object criteria1, Object criteria2) {
		List<T> results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria1.getClass() == String.class){
				query.setString(queryVariable1, (String) criteria1);
			}
			else if(criteria1.getClass() == Integer.class){
				Integer critInt = (Integer) criteria1;
				query.setInteger(queryVariable1, critInt.intValue());
			}
			else if(criteria1.getClass() == Date.class){
				query.setDate(queryVariable1, (Date)criteria1);
			}
			if(criteria2.getClass() == String.class){
				query.setString(queryVariable2, (String) criteria2);
			}
			else if(criteria2.getClass() == Integer.class){
				Integer critInt = (Integer) criteria2;
				query.setInteger(queryVariable2, critInt.intValue());
			}
			else if(criteria2.getClass() == Date.class){
				query.setDate(queryVariable2, (Date)criteria2);
			}
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


	protected Object fetchSingle(String queryString, String queryVariable, Object criteria){
		Object result = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria == null){
				//force a skip on null values, criteria not needed for SELECT *
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

	protected int updateSingle(String queryString, String queryVariable, Object newValue, int id){
		int updateCounter = -1;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			if(newValue.getClass() == String.class){
				query.setString(queryVariable, (String) newValue);
			}
			if(newValue.getClass() == Integer.class){
				Integer newInt = (Integer) newValue;
				query.setInteger(queryVariable, newInt.intValue());
			}
			if(newValue.getClass() == Date.class){
				query.setDate(queryVariable, (Date) newValue);
			}
			if(newValue.getClass() == Boolean.class){
				Boolean newBool = (Boolean) newValue;
				query.setBoolean(queryVariable, newBool.booleanValue());
			}
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

//TODO database dump method needs to be added
