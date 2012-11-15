package business.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.RequestManagement;
import hibernate.UserManagement;

import models.Connection;
import models.Request;
import models.User;
import models.Field;

import org.junit.BeforeClass;
import org.junit.Test;

import business.SeekUsersWithGivenSubject;

public class SUWGSTest {
	
	private static ConnectionManagement connectionManager;
	private static FieldManagement fieldManager;
	private static UserManagement userManager;
	private static RequestManagement requestManager;
	private static User user1, user2;
	private static Connection connection1, connection2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		connectionManager = new ConnectionManagement();
		fieldManager = new FieldManagement();
		userManager = new UserManagement();
		requestManager = new RequestManagement();
		user1 = new User("Thomas", "Hinna", "email", "locationCity", "locationCountry", "identifierOpenID");
		user2 = new User("Nils", "Hinna", "email2", "locationCity2", "locationCountry2", "identifierOpenID2");
		userManager.addUser(user1);
		userManager.addUser(user2);
		Field field = new Field("Java", "Programming language");
		fieldManager.addField(field);
		connection1 = new Connection(field);
		connection1.setMentor(user1);
		connectionManager.addConnection(connection1);
		requestManager.createRequest(user2, connection1, true);
		connection2 = new Connection(field);
		connection2.setTrainee(user2);
		connectionManager.addConnection(connection2);
		requestManager.createRequest(user2, connection2, false);
		connectionManager.createOpenMentor(user2, field, 1);
		connectionManager.createOpenTrainee(user1, field, 1);
	}

	@Test
	public void testSeekUsersWithGivenSubjectMentors() {
		SeekUsersWithGivenSubject usersSeekingGivenSubject = new SeekUsersWithGivenSubject("Java", true);
		ArrayList<User> mentors = usersSeekingGivenSubject.getMentorsWithSbject();
		assertEquals(mentors.size(), 1);
		assertEquals(mentors.get(0).getUserID(), user2.getUserID());
	}
	
	@Test
	public void testSeekUsersWithGivenSubjectTrainees() {
		SeekUsersWithGivenSubject usersSeekingGivenSubject = new SeekUsersWithGivenSubject("Java", false);
		ArrayList<User> trainees = usersSeekingGivenSubject.getMentorsWithSbject();
		assertEquals(trainees.size(), 1);
		assertEquals(trainees.get(0).getUserID(), user1.getUserID());
	}

}
