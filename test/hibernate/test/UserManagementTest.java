package hibernate.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hibernate.*;

public class UserManagementTest {

	CommentManagement cm;
	ConnectionManagement xm;
	FieldManagement fm;
	SubjectManagement sm;
	UserManagement um;
	
	@Before
	public void setUp() throws Exception {
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
	}

	@Test
	public void testUserCreation() {
		um.createUser("John", "First", "johnfirst@gmail.com", "In the vicinity", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "numero dos");
		um.createUser("Phil", "Last", "phil@last.com", "Here", "nomero tres");
		
		assertEquals(um.getByEmail("johnfirst@gmail.com").get(0).getLocation(), "In the vicinity");
		assertEquals(um.getByName("Bob", "Second").get(0).getEmail(), "bob.second@outlook.com");
		assertEquals(um.getByLocation("Here").get(0).getFullName(), "Phil Last");
	}

}
