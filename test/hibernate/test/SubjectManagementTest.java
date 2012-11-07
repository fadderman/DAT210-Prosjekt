package hibernate.test;

import static org.junit.Assert.*;
import hibernate.SubjectManagement;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectManagementTest {
	private SubjectManagement testList;

	
	
	@Before
	public void beforeTest(){
		testList = new SubjectManagement();
	}
	
	@After
	public void afterTest(){
		testList = null;
	}
	

	@Test
	public void testCreateSubject() {
		testList.createSubject("Java3D", "Programming language");
		String listText = testList.toString();
		
	}
	
	@Test
	public void testGetAllSubjects(){
		
	}

}
