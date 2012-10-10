package business.search.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.search.SearchEngine;
import business.search.SearchSuggestions;
import business.search.UserSuggestion;
import business.user.UserHandler;

public class SearchEngineTest {

	private SearchEngine searchEngine;
	static UserHandler userHandler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userHandler = new UserHandler();
		userHandler.addUser(new User("openID", "Thomas", "Hinna", "email", "location"));
		userHandler.addUser(new User("openID", "Thomas", "Nilsen", "email", "location"));
		userHandler.addUser(new User("openID", "Morten", "Salte", "email", "location"));
		userHandler.addUser(new User("openID", "Morten", "Bla", "email", "location"));
		userHandler.addUser(new User("openID", "Mango", "Bli", "email", "location"));
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
	public void searchForThomasAndExpectThomas() {
		String searchFor = "Thomas";
		SearchSuggestions result = searchEngine.suggest(searchFor);
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals(searchFor, userRes.get(i).getFirstname());
		}
	}
	
	@Test
	public void searchForHinnaAndExpectHinna() {
		SearchSuggestions result = searchEngine.suggest("Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastname());
		}
	}
	
	@Test
	public void searchForLastnameHinnaAndExpectFirstnameThomas() {
//		System.out.println("starting timedtest");
//		long startTime = System.currentTimeMillis();
		SearchSuggestions result = searchEngine.suggest("Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
		}
//		System.out.println("time used: " + (System.currentTimeMillis()-startTime));
	}
	
	@Test
	public void searchForHehmaAndExpectHinna() {
		SearchSuggestions result = searchEngine.suggest("Hehma");
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Hinna", userRes.get(i).getLastname());
		}
	}
	
	@Test
	public void searchForT1234sAndExpectThomas() {
		SearchSuggestions result = searchEngine.suggest("t1234s");
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
		}
	}
	
	@Test
	public void searchForThomasHinnaAndExpectFirstnameThomas() {
		SearchSuggestions result = searchEngine.suggest("Thomas Hinna");
		ArrayList<UserSuggestion> userRes = result.getUserResults();
		assertTrue(!userRes.isEmpty());
		for(int i=0;i<userRes.size();i++){
			assertEquals("Thomas", userRes.get(i).getFirstname());
		}
	}

}
