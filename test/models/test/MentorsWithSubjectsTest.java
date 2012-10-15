package models.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MentorsWithSubjectsTest {
	private LinkedList<User> mentorswithsubject;

	@Before
	public void setUp() throws Exception {
		mentorswithsubject = new LinkedList<User>();
	}

	@After
	public void tearDown() throws Exception {
		mentorswithsubject = null;
	}
	@Test
	public void getMentorWithSubjectTest() {
		assertNotNull(mentorswithsubject);
	}

}
