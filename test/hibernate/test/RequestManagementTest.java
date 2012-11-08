package hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import hibernate.CommentManagement;
import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.RequestManagement;
import hibernate.UserManagement;

import models.Request;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestManagementTest {

	private static CommentManagement cm;
	private static ConnectionManagement xm;
	private static FieldManagement fm;
	private static UserManagement um;
	private static RequestManagement rm;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		um = new UserManagement();
		rm = new RequestManagement();

		fm.createField("Java", "This is Java");
		fm.createField("C++", "C plus plus");
		fm.createField("Google tips", "Google like a pro");
		fm.createField("Bathroom Wall", "How to copy code from the internet");
		fm.createField("COBOL", "Old stuff for old ppl");

		um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");

		xm.createOpenMentor(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Google tips"));


		xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++"));
		xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall"));
		xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL"));

		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));

		xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++"));
		xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall"));
		xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));		

		rm.createRequest(um.getByEmail("johnfirst@gmail.com"), xm.getByID(1), true);
		
		}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	}

	@Test
	public void testGetRequestByID(){

		assertEquals(rm.createRequest(um.getByEmail("johnfirst@gmail.com"), xm.getByID(1), true), true);
		assertEquals(rm.createRequest(um.getByEmail("someguy@somewhere.com"), xm.getByID(2), true), true);
	}
	
	@Test
	public void testGetRequestByUserID(){
		List<Request> list = rm.getRequestByUserID(um.getByEmail("johnfirst@gmail.com").getUserID());
		assertEquals(list.get(0).getRequestID(), um.getByEmail("johnfirst@gmail.com").getUserID());
	}

}
