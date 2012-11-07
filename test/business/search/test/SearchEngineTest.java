package business.search.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hibernate.FieldManagement;
import hibernate.UserManagement;

import java.util.ArrayList;

import javax.security.auth.Subject;

import models.Field;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.search.SearchEngine;
import business.search.SearchResults;

public class SearchEngineTest {

	private SearchEngine searchEngine;
	static FieldManagement fieldHandler;
	static UserManagement userHandler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userHandler = new UserManagement();
		userHandler.addUser(new User("Thomas", "Hinna", "email", "city","country", "openID"));
		userHandler.addUser(new User("Thomas", "Nilsen", "email",  "city","country", "openID"));
		userHandler.addUser(new User("Morten", "Salte", "email",  "city","country","openID"));
		userHandler.addUser(new User("Morten", "Bla", "email",  "city","country","openID"));
		userHandler.addUser(new User("Mango", "Bli", "email",  "city","country", "openID"));
//		for(int i=0;i<500000;i++){
//			userHandler.addUser(new User("identifier_openID" + i, "firstName" + i, "lastName" + i,
//					"email" + i, "location" + i));
//		}
		fieldHandler = new FieldManagement();
		fieldHandler.addField(new Field("Java", "description"));
		fieldHandler.addField(new Field("C++", "description"));
		fieldHandler.addField(new Field("Javascript", "description"));
		fieldHandler.addField(new Field("C#", "description"));
		fieldHandler.addField(new Field("Python", "description"));
		fieldHandler.addField(new Field("Go", "description"));
		fieldHandler.addField(new Field("Ruby", "description"));
	}
	
	
	@Before
	public void setUp() throws Exception {
		searchEngine = new SearchEngine();
	}
	
	@After
	public void tearDown() throws Exception {
	searchEngine = null;
	}
	
	@Test
	public void searchForThomasAndExpectThomas() {
		String searchFor = "Thomas";
		SearchResults result = searchEngine.search(searchFor);
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals(searchFor, userRes.get(i).getFirstName());
		}
	}
	
	@Test
	public void searchForHinnaAndExpectHinna() {
		SearchResults result = searchEngine.search("Hinna");
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastName());
		}
	}
	
	@Test
	public void searchForLastnameHinnaAndExpectFirstnameThomas() {
//		System.out.println("starting timedtest");
//		long startTime = System.currentTimeMillis();
		SearchResults result = searchEngine.search("Hinna");
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstName());
		}
//		System.out.println("time used: " + (System.currentTimeMillis()-startTime));
	}
	
	
	@Test
	public void searchForThomasHinnaAndExpectFirstnameThomas() {
		SearchResults result = searchEngine.search("Thomas Hinna");
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstName());
		}
	}
	
	@Test
	public void searchForJavaAndExpectJava() {
		String searchFor = "Java";
		SearchResults result = searchEngine.search(searchFor);
		ArrayList<Field> fieldRes = result.getFieldResults();
		assertTrue(!fieldRes.isEmpty());
		for(int i=0;i<fieldRes.size();i++){
			assertTrue(fieldRes.get(i).getTitle().contains(searchFor));
		}
	}

}
