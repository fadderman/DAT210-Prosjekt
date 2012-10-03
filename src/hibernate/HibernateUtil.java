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
	
	public static <T> List<T> fetch(String queryString, String queryVariable, Object criteria){
		List<T> results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			if(criteria.getClass() == String.class)
				query.setString(queryVariable, (String) criteria);
			if(criteria.getClass() == Integer.class){
				Integer critInt = (Integer) criteria;
				query.setInteger(queryVariable, critInt.intValue());
			}
			if(criteria.getClass() == Date.class)
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
}
