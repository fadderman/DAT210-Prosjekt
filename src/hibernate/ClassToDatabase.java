package hibernate;

import java.util.ArrayList;
import java.util.List;
import models.*;
/**
 * Classes that are to be made persistent by Hibernate need to be added
 * to the ArrayList in this class.
 * 
 * @author Bart Wasilewski
 */
@SuppressWarnings("rawtypes")
public class ClassToDatabase {

	private List<Class> classToDatabase;
	public ClassToDatabase(){
		classToDatabase = new ArrayList<Class>();
		classToDatabase.add(User.class);
		classToDatabase.add(Connection.class);
		classToDatabase.add(FieldTree.class);
		classToDatabase.add(Field.class);
		classToDatabase.add(Subject.class);
		classToDatabase.add(Comment.class);
	}
	/**
	 * 
	 * @return ArrayList of Classes to be added to Hibernate's persistent class
	 * configuration registry.
	 */
	public List<Class> getClassToDatabase(){
		return classToDatabase;
	}
	
	
}
