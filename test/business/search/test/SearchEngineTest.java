package business.search.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import models.Subject;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.search.SearchEngine;
import business.search.SearchResults;
import business.subject.SubjectHandler;
import business.user.UserHandler;

public class SearchEngineTest {

	private SearchEngine searchEngine;
	static UserHandler userHandler;
	static SubjectHandler subjectHandler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userHandler = new UserHandler();
		userHandler.addUser(new User("Thomas", "Hinna", "email", "city","country", "openID"));
		userHandler.addUser(new User("Thomas", "Nilsen", "email",  "city","country", "openID"));
		userHandler.addUser(new User("Morten", "Salte", "email",  "city","country","openID"));
		userHandler.addUser(new User("Morten", "Bla", "email",  "city","country","openID"));
		userHandler.addUser(new User("Mango", "Bli", "email",  "city","country", "openID"));
//		for(int i=0;i<500000;i++){
//			userHandler.addUser(new User("identifier_openID" + i, "firstName" + i, "lastName" + i,
//					"email" + i, "location" + i));
//		}
		subjectHandler = new SubjectHandler();
		subjectHandler.addSubject(new Subject("Java", "description"));
		subjectHandler.addSubject(new Subject("C++", "description"));
		subjectHandler.addSubject(new Subject("C#", "description"));
		subjectHandler.addSubject(new Subject("Javascript", "description"));
		subjectHandler.addSubject(new Subject("Go", "description"));
		subjectHandler.addSubject(new Subject("Python", "description"));
		subjectHandler.addSubject(new Subject("C", "description"));
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
	public void searchForHehmaAndExpectHinna() {
		SearchResults result = searchEngine.search("Hehma");
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastName());
		}
	}

	
	@Test
	public void searchForT1234sAndExpectThomas() {
		SearchResults result = searchEngine.search("t1234s");
		ArrayList<User> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstName());
		}
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
	
//	@Test
//	public void searchForJavaAndExpectJava() {
//		String searchFor = "Java";
//		SearchResults result = searchEngine.search(searchFor);
//		ArrayList<Subject> subRes = result.getSubjectResults();
//		assertTrue(!subRes.isEmpty());
//		for(int i=0;i<subRes.size();i++){
//			assertEquals(searchFor, subRes.get(i).getTitle());
//			assertTrue(subRes.get(i).getTitle().startsWith(searchFor));
//		}
//	}

}
