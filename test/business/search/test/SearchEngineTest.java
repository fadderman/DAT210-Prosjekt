package business.search.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.search.SearchEngine;
import business.search.SearchResults;
import business.search.SearchSuggestions;
import business.search.UserSuggestion;
import business.user.UserHandler;

public class SearchEngineTest {

	private SearchEngine searchEngine;
	static UserHandler userHandler;
	
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
	public void searchForThomasAndExpectThomasAsSuggested() {
		String searchFor = "Thomas";
		SearchSuggestions result = searchEngine.suggest(searchFor);
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals(searchFor, userRes.get(i).getFirstname());
		}
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
	public void searchForHinnaAndExpectHinnaAsSuggested() {
		SearchSuggestions result = searchEngine.suggest("Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastname());
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
	public void searchForLastnameHinnaAndExpectFirstnameThomasAsSuggested() {
//		System.out.println("starting timedtest");
//		long startTime = System.currentTimeMillis();
		SearchSuggestions result = searchEngine.suggest("Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
		}
//		System.out.println("time used: " + (System.currentTimeMillis()-startTime));
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
	public void searchForHehmaAndExpectHinnaAsSuggested() {
		SearchSuggestions result = searchEngine.suggest("Hehma");
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastname());
		}
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
	public void searchForT1234sAndExpectThomasAsSuggested() {
		SearchSuggestions result = searchEngine.suggest("t1234s");
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
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
	public void searchForThomasHinnaAndExpectFirstnameThomasAsSuggested() {
		SearchSuggestions result = searchEngine.suggest("Thomas Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserSuggestions();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
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

}
