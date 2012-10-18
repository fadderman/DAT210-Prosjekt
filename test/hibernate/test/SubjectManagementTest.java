package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import hibernate.*;
import models.*;

import org.junit.*;

public class SubjectManagementTest {
	SubjectManagement sm;
	CommentManagement cm;
	ConnectionManagement xm;
	FieldManagement fm;
	UserManagement um;
	
	
	

	
	
	@Before
	public void beforeTest() throws Exception{
		sm = new SubjectManagement();
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		um = new UserManagement();
		
		fm.createField("Java", "This is java", null);
		
	}
	


	@Test
	public void testCreateSubject() {
		
		Subject subject1 = new Subject("Java3D", "Programming language");
		Subject subject2 = new Subject("C#", "Old programming language");
		Subject subject3 = new Subject("Java", "Awsomeness programming language");
		
		

		
		
		assertEquals(sm.createSubject("Java3D", "Programming language"), true);
		assertEquals(sm.createSubject("C#", "Programming language"), true);
		assertEquals(sm.createSubject("Java", "Awsomeness programming language"), true);
//		
//		assertEquals(sm.getByTitle("Java3D").get(0).getDescription(), "Programming language");
//		assertEquals(sm.getByTitle("C#").get(0).getDescription(), "Programming language");
//		assertEquals(sm.getByTitle("Java").get(0).getDescription(), "Awsomeness programming language");
		
		
		
	}
	
	@Test
	public void testGetAllSubjects(){
		List<Subject> list = sm.getAllSubjects();
		
		for (Iterator<Subject> iterator = list.iterator(); iterator.hasNext();) {
			Subject current = iterator.next();
			assertEquals(current.getClass(), String.class);
		}
		
	}
	
	@Test
	public void testGetByTitle(){
		List<Subject> list = sm.getByTitle("Java3D");
		assertEquals(list.get(0).getDescription(), "Programming language");
	}
	

	
	@Test
	public void testUpdateTitle(){
		List<Subject> test = sm.getByTitle("Java3D");
		sm.updateTitle( test.get(0), "Java4D");
		assertEquals(sm.getByTitle("Java4D").get(0).getTitle(), "Java4D");
		
	}
	
	@Test
	public void testUpdateDescription(){
		List<Subject> test =  sm.getByTitle("Java");
		sm.updateDescription(test.get(0), "Programming language");
		assertEquals(sm.getByTitle("Java").get(0).getDescription(), "Programming language");
	}
	
	@Test
	public void testChangeStatus(){
		Subject test = sm.getByID(3);
		sm.changeStatus(test, false);
		
		List<Subject> list = sm.getAllInactiveSubjects();
		
		for(Iterator<Subject> iterator = list.iterator(); iterator.hasNext();){
			Subject current = iterator.next();
			System.out.println(current.getTitle());
			assertEquals(current.isActive(), false);
		}
	}
	
	
	
	
	//TODO List<Field> fetchFieldList
	
	




}
