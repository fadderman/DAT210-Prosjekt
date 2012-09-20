package models.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.Comment;
import models.Connection;
import models.Subject;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {

	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		connection = new Connection();
	}

	@After
	public void tearDown() throws Exception {
		connection = null;
	}

	@Test
	public void testMentorList() {
		User mentor = new User();
		connection.setMentor(mentor);
		assertEquals(mentor, connection.getMentor());
	}
	
	@Test
	public void testTrainee() {
		User trainee = new User();
		connection.setTrainee(trainee);
		assertEquals(trainee, connection.getTrainee());
	}
	
	@Test
	public void testSubject() {
		Subject subject = new Subject();
		connection.setSubject(subject);
		assertEquals(subject, connection.getSubject());
	}
	
	@Test
	public void testDifficultyLevel() {
		int difficultyLevel = 5;
		connection.setDifficultyLevel(difficultyLevel);
		assertEquals(difficultyLevel, connection.getDifficultyLevel());
	}
	
	@Test
	public void testComments() {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		connection.setComments(comments);
		assertEquals(comments, connection.getComments());
	}

}
