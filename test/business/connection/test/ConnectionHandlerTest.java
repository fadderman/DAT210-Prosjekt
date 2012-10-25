package business.connection.test;

import static org.junit.Assert.*;

import models.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.connection.ConnectionHandler;

public class ConnectionHandlerTest {
	String firstName, lastName, email, city, country;
	String[] field = {"boats", "crafting"}, description ={"I like them boats", "gotsa craft"}, experience={"novice", "expert"}, traineeRadioButton={"Yes", "Yes"}, mentorRadioButton={"No", "Yes"};
	User testUser;
	ConnectionHandler handler;
	
	@Before
	public void setUp() throws Exception {
		firstName = "Bob"; lastName = "Saget"; email ="bob@saget.com"; city="LA"; country="USA";
		testUser = new User(firstName, lastName, email, city, country, "123");
		testUser.setMapURL("http://maps.googleapis.com/maps/api/staticmap?center=LA,USA&zoom=12&size=500x150&sensor=false");
		handler = new ConnectionHandler(firstName, lastName, email, city, country, "123", field, description, experience, traineeRadioButton, mentorRadioButton);
	}
	
	@Test
	public void createUserExpectsTestUser(){ 
		assertTrue(handler.getUser().equals(testUser));
	}
}
