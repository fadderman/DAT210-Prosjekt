package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import hibernate.CommentManagement;
import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.SubjectManagement;
import hibernate.UserManagement;

import models.Field;
import models.Subject;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.Current;

public class FieldManagementTest {

	private static CommentManagement cm;
	private static ConnectionManagement xm;
	private static FieldManagement fm;
	private static SubjectManagement sm;
	private static UserManagement um;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
		
		sm.createSubject("Programming", "Programming related");
		sm.createSubject("Non-programming", "not programming related");
	}
	
	@Before
	public void setUp(){
		
	}

	@Test
	public void testCreateField() {
		assertEquals(fm.createField("Java", "This is Java", sm.getSingleByTitle("Programming")), true);
		assertEquals(fm.createField("C++", "C plus plus", sm.getSingleByTitle("Programming")), true);
		assertEquals(fm.createField("Google tips", "Google like a pro", sm.getSingleByTitle("Non-programming")), true);
		assertEquals(fm.createField("Bathroom Wall", "How to copy code from the internet", sm.getSingleByTitle("Non-programming")), true);
		assertEquals(fm.createField("COBOL", "Old stuff for old ppl", sm.getSingleByTitle("Programming")), true);
	}
	
	@Test
	public void testGetAllFields(){
		List<Field> list = fm.getAllFields();
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			assertEquals(i.next().getClass(), Field.class);
		}
	}
	
	@Test
	public void testChangeStatus(){
		fm.changeStatus(fm.getSingleByTitle("COBOL"), false);
		fm.changeStatus(fm.getSingleByTitle("Bathroom Wall"), false);
		
		List<Field> list = fm.getAllInactiveFields();
		
		assertEquals(list.get(0).getTitle(), "Bathroom Wall");
		assertEquals(list.get(1).getTitle(), "COBOL");	
	}

	@Test
	public void testGetByID(){
		assertEquals(fm.getByID(1).getTitle(), "Java");
	}
	
	@Test
	public void testGetByTitle(){
		List<Field> list = fm.getByTitle("Google tips");
		assertEquals(list.get(0).getTitle(), "Google tips");
		
	}
	
	@Test
	public void testGetSingleByTitle(){
		Field f = fm.getSingleByTitle("C++");
		assertEquals(f.getTitle(), "C++");
	}
	
	@Test
	public void testUpdateTitle(){
		Field f = fm.getSingleByTitle("C++");
		fm.updateTitle(f, "C--");
		
		assertEquals(fm.getByID(2).getTitle(), "C--");
	}
	
	@Test
	public void testUpdateDescription(){
		List<Field> list = fm.getByTitle("Google tips");
		
		fm.updateDescription(list.get(0), "Pro Googling tips for n00bs");
		
		assertEquals(fm.getSingleByTitle("Google tips").getDescription(), "Pro Googling tips for n00bs");
	}
	
	//public void testFetchConnectionList
	//public void testGetMentors
	//public void testGetTrainees
}
