package hibernate;

import java.util.Iterator;

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
}
