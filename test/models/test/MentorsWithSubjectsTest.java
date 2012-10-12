package models.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MentorsWithSubjectsTest {
	private LinkedList<User> mentors;

	@Before
	public void setUp() throws Exception {
		mentors = new LinkedList<User>();
	}

	@After
	public void tearDown() throws Exception {
		mentors = null;
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
