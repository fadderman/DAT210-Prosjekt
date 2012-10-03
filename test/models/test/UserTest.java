package models.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.Subject;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testFirstName() {
		String firstName = "Morten";
		user.setFirstName(firstName);
		assertEquals(firstName, user.getFirstName());
	}
	
	@Test
	public void testLastName() {
		String lastName = "Salte";
		user.setLastName(lastName);
		assertEquals(lastName, user.getLastName());
	}
	
	@Test
	public void testLocation() {
		String location = "Stavanger";
		user.setLocation(location);
		assertEquals(location, user.getLocation());
	}
	
	@Test
	public void testIdentifier() {
		String identifier = "sapodkasodk";
		user.setIdentifierOpenID(identifier);
		assertEquals(identifier, user.getIdentifierOpenID());
	}
	
	public void testEmail() {
		String email = "msalte86@gmail.com";
		user.setEmail(email);
		assertEquals(email, user.getEmail());
	}
	
	public void testMentorList() {
		ArrayList<Subject> mentorList = new ArrayList<Subject>();
		user.setMentorList(mentorList);
		assertEquals(mentorList, user.getMentorList());
	}

	public void testTraineeList() {
		ArrayList<Subject> traineeList = new ArrayList<Subject>();
		user.setTraineeList(traineeList);
		assertEquals(traineeList, user.getTraineeList());
	}
}
