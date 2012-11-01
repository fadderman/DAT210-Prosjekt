package business.connection.test;

import static org.junit.Assert.*;

import models.Connection;
import models.Field;
import models.User;
import hibernate.*;

import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

import business.connection.ConnectionHandler;

public class ConnectionHandlerTest {
	static String firstName, lastName, email, city, country;
	static String[] field = {"","boats", "crafting","derpy"}, description ={"","I like them boats", "gotsa craft", "herpy derpy"}, experience={"","novice", "expert", "intermediate"}, traineeRadioButton={"Yes", "No", "No"}, mentorRadioButton={"No", "Yes", "No"};
	static User testUser, emptyUser;
	static ConnectionHandler handler;
	static ConnectionManagement manag = new ConnectionManagement();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emptyUser = new User();
		firstName = "Bob"; lastName = "Saget"; email ="bob@saget.com"; city="LA"; country="USA";
		testUser = new User(firstName, lastName, email, city, country, "123");
		testUser.setUserID(1);
		handler = new ConnectionHandler(testUser, field, description, experience, traineeRadioButton, mentorRadioButton);
	}

	
	@Test
	public void testBoatFieldExpectsBoatConnection(){
		Connection testConnection = new Connection(testUser, emptyUser, new Field(field[0], description[0]), 0);
		assertTrue(manag.getByID(1).getDifficultyLevel() == testConnection.getDifficultyLevel());
		testConnection = new Connection(testUser, emptyUser, new Field(field[0], description[0]), 2);
		assertTrue(manag.getByID(2).getDifficultyLevel() == testConnection.getDifficultyLevel());
	}
	
	@Test
	public void testNumberOfConnectionsExpectedThree(){
		int i = manag.getAllConnections().size();
		System.out.println(i + " manag.getConnections.size");
		assertEquals(i, 3);
	}
	
	@Test
	public void testDescriptionExpectsdescriptions(){
		assertTrue("gotsa craft".equals(manag.getByID(2).getField().getDescription()));
		assertTrue("I like them boats".equals(manag.getByID(1).getField().getDescription()));
	}
	
	@Test
	public void testTitleExcpectsTitles(){
		assertTrue("boats".equals(manag.getByID(1).getField().getTitle()));
		assertTrue("crafting".equals(manag.getByID(2).getField().getTitle()));
	}
	
	@Test 
	public void testDifficultyExpectsDifficulties(){
		assertEquals(0, manag.getByID(1).getDifficultyLevel());
		assertEquals(2, manag.getByID(2).getDifficultyLevel());
		assertEquals(1, manag.getByID(3).getDifficultyLevel());
	}
	
	@Test
	public void testRadioButtonsExpectsTraineeMentorTrainee(){
		assertEquals(testUser.getUserID(), manag.getByID(1).getTrainee().getUserID());
		assertEquals(testUser.getUserID(), manag.getByID(2).getMentor().getUserID());
		assertEquals(testUser.getUserID(), manag.getByID(3).getTrainee().getUserID());
		
		assertEquals(testUser.getFullName(), manag.getByID(1).getTrainee().getFullName());
		
		assertEquals(2, manag.getByID(2).getTrainee().getUserID());
		assertEquals(2, manag.getByID(1).getMentor().getUserID());
		assertEquals(2, manag.getByID(3).getMentor().getUserID());
	}
	
	@Test
	public void test(){
		assertTrue("1".equalsIgnoreCase("1"));
	}
}
