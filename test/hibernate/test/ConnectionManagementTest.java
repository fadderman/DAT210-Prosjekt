package hibernate.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Iterator;

import hibernate.*;

import models.Connection;
import models.User;

import org.junit.*;

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
	public void testCreateOpenMentor() {
		assertEquals(xm.createOpenMentor(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Java")), true);
		assertEquals(xm.createOpenMentor(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Java")), true);
		assertEquals(xm.createOpenMentor(um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Google tips")), true);
	}
	
	@Test
	public void testCreateOpenTrainee() {
		assertEquals(xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++")), true);
		assertEquals(xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall")), true);
		assertEquals(xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL")), true);
	}
	
	@Test
	public void testCreateConnection(){
		assertEquals(xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL")), true);
		assertEquals(xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips")), true);
		assertEquals(xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall")), true);
	}
	
	@Test
	public void testChangeStatus(){
		List<Connection> list = xm.getByMentor(um.getByEmail("phil@last.com"));
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			if(current.getField().getTitle() == "Bathroom Wall"){
				xm.changeStatus(current, false);
			}
		}
		
		list = xm.getByMentor(um.getByEmail("phil@last.com"));
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			if(current.getField().getTitle() == "Bathroom Wall"){
				assertEquals(current.isActive(), false);
			}
		}
		
	}
	
	@Test
	public void testGetAllConnections(){
		List<Connection> list = xm.getAllConnections();
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			assertEquals(current.getClass(), Connection.class);
		}
		assertEquals(list.size(), 7);
	}

}
