package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.*;

import models.*;
import hibernate.*;

public class UserManagementTest {

	static CommentManagement cm;
	static ConnectionManagement xm;
	static FieldManagement fm;
	static UserManagement um;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		um = new UserManagement();
		
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
		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));
	}
	
	@Before
	public void setUp(){
		
	}

	@Test
	public void testListAllUsers(){
		List<User> list = um.listAllUsers();
		
		for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
			User current = iterator.next();
			assertEquals(current.getClass(), User.class);
		}
	}
	@Test
	public void testChangeStatus(){
		User tester = um.getByID(4);
		um.changeStatus(tester, false);
		
		List<User> list = um.listAllInactiveUsers();
		
		for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
			User current = iterator.next();
			assertEquals(current.isActive(), false);
		}
			
	}
	
	@Test
	public void testGetByName(){
		List<User> list = um.getByName("Bob", "Second");
		assertEquals(list.get(0).getFullName(), "Bob Second");
	}
	
	public void testGetByEmail(){
		User test = um.getByEmail("johnfirst@gmail.com");
		assertEquals(test.getFullName(), "John First");
	}
	
	@Test
	public void testGetByOpenID(){
		User user = um.getByOpenId("numero tres");
		assertEquals(user.getFullName(), "Bob Last");
	}
	
	@Test
	public void testGetByLocation(){
		List<User> list = um.getByLocation("Here", "It exits on Earth");
		assertEquals(list.get(0).getFullName(), "John First");
		assertEquals(list.get(1).getFullName(), "Bob Last");
	}
	
	@Test
	public void testUpdateFirstName(){
		User test = um.getByEmail("johnfirst@gmail.com");
		um.updateFirstName("Johnathan", test);
		assertEquals(um.getByEmail("johnfirst@gmail.com").getFirstName(), "Johnathan");
	}
	
	@Test
	public void testUpdateLastName(){
		User test = um.getByEmail("johnfirst@gmail.com");
		um.updateLastName("Firstensen", test);
		assertEquals(um.getByEmail("johnfirst@gmail.com").getLastName(), "Firstensen");
	}
	
	@Test
	public void testUpdateLocation(){
		User test = um.getByEmail("bob.second@outlook.com");
		um.updateLocation("Stavanger", "Norway", test);
		assertEquals(um.getByLocation("Stavanger", "Norway").get(0).getFullName(), "Bob Second");
	}
	@Test
	public void testFetchMentorConnections(){
		List<Connection> list = um.fetchMentorConnections(um.getByEmail("phil@last.com"));
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			assertEquals(current.getClass(), Connection.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testFetchTraineeConnections(){
		List<Connection> list = um.fetchTraineeConnections(um.getByEmail("johnfirst@gmail.com"));
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			assertEquals(current.getClass(), Connection.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetMentorFields(){
		List<Field> list = um.getMentorFields(um.getByEmail("phil@last.com"));
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			Field current = i.next();
			assertEquals(current.getClass(), Field.class);
			System.out.println(current.getTitle());
		}
		assertEquals(list.size(), 2);
	}
	@Test
	public void testGetTraineeFields(){
		List<Field> list = um.getTraineeFields(um.getByEmail("johnfirst@gmail.com"));
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			Field current = i.next();
			assertEquals(current.getClass(), Field.class);
			System.out.println(current.getTitle());
		}
		assertEquals(list.size(), 2);
	}
	
	//TODO testFetchCommentList
}
