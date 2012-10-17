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

import org.junit.Before;
import org.junit.Test;

public class FieldManagementTest {

	private CommentManagement cm;
	private ConnectionManagement xm;
	private FieldManagement fm;
	private SubjectManagement sm;
	private UserManagement um;

	@Before
	public void setUp() throws Exception {
		
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
		
		sm.createSubject("Programming", "Programming related");
		sm.createSubject("Non-programming", "not programming related");
	}

	@Test
	public void testCreateField() {
		assertEquals(fm.createField("Java", "This is Java", sm.getSingleByTitle("Programming")), true);
		assertEquals(fm.createField("C++", "C plus plus", sm.getSingleByTitle("Programming")), true);
		assertEquals(fm.createField("Google tips", "Google like a pro", sm.getSingleByTitle("Non-programming")), true);
		assertEquals(fm.createField("Bathroom Wall", "How to copy code from the interne", sm.getSingleByTitle("Non-programming")), true);
		assertEquals(fm.createField("COBOL", "Old stuff for old ppl", sm.getSingleByTitle("Programming")), true);
	}
	
	@Test
	public void testGetAllFields(){
		List<Field> list = fm.getAllFields();
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			Field current = i.next();
			System.out.println(current.getTitle()); 
		}
	}
	
	@Test
	public void testChangeStatus(){
		fm.changeStatus(fm.getSingleByTitle("COBOL"), false);
		fm.changeStatus(fm.getSingleByTitle("Bathroom Wall"), false);
		
		List<Field> list = fm.getAllInactiveFields();

		assertEquals(list.get(0).getTitle(), "COBOL");
		assertEquals(list.get(1).getTitle(), "Bathroom Wall");
		
	}

}
