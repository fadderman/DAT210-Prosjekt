package hibernate.test;

import static org.junit.Assert.*;
import hibernate.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionManagementTest {

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
		
		fm.createField("Java", "This is Java", sm.getSingleByTitle("Programming"));
		fm.createField("C++", "C plus plus", sm.getSingleByTitle("Programming"));
		fm.createField("Google tips", "Google like a pro", sm.getSingleByTitle("Non-programming"));
		fm.createField("Bathroom Wall", "How to copy code from the internet", sm.getSingleByTitle("Non-programming"));
		fm.createField("COBOL", "Old stuff for old ppl", sm.getSingleByTitle("Programming"));
		
		um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");
		
		
	}
	
	@Before
	public void setUp(){
		
	}


	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
