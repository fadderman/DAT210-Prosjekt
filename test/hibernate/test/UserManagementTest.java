package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import models.User;

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

		User user1 = new User("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		User user2 = new User("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		User user3 = new User("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		User user4 = new User("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");
		
		assertEquals(um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno"), true);
		assertEquals(um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos"), true);
		assertEquals(um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres"), true);
		assertEquals(um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro"), true);
	}

	@Test
	public void testListAllUsers(){
		List<User> list = um.listAllUsers();
		
		for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
			User current = iterator.next();
			assertEquals(current.getIdentifierOpenID().getClass(), String.class);
		}
	}
	@Test
	public void testChangeStatus(){
		User tester = um.getByID(4);
		um.changeStatus(tester, false);
		
		List<User> list = um.listAllInactiveUsers();
		
		for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
			User current = iterator.next();
			System.out.println(current.getFullName());
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
		List<User> list = um.getByOpenId("numero tres");
		assertEquals(list.get(0).getFullName(), "Bob Last");
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
		User test = um.getByEmail("johnfirst@gmail.com");
		um.updateLocation("Stavanger", "Norway", test);
		assertEquals(um.getByLocation("Stavanger", "Norway").get(0).getFullName(), "Johnathan Firstensen");
	}
	
	//TODO testFetchMentorConnections
	//TODO testFetchTraineeConnections
	//TODO testFetchCommentList
	//TODO testGetMentorFields
	
	//TODO testGetTraineeFields
	
}
