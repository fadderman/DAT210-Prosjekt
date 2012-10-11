package hibernate.test;

import static org.junit.Assert.*;
import hibernate.CommentManagement;
import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.SubjectManagement;
import hibernate.UserManagement;





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
		
	}
	


	@Test
	public void testCreateSubject() {
		sm.createSubject("Java3D", "Programming language");
		sm.createSubject("C#", "Programming language");
		sm.createSubject("Java", "Awsomeness programming language");
		
		assertEquals(sm.getByTitle("Java3D").get(0).getDescription(), "Programming language");
		assertEquals(sm.getByTitle("C#").get(0).getDescription(), "Programming language");
		assertEquals(sm.getByTitle("Java").get(0).getDescription(), "Awsomeness programming language");
		
		
		
	}
	
	@Test
	public void testGetByID(){
		
	}
	


}
