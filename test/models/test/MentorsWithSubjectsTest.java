package models.test;

import static org.junit.Assert.*;

import hibernate.UserManagement;

import java.util.ArrayList;
import java.util.LinkedList;

import models.MentorsWithSubject;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MentorsWithSubjectsTest {
	private ArrayList<User> mentorswithsubject;

	@Before
	public void setUp() throws Exception {
		mentorswithsubject =  new MentorsWithSubject().getMentorsWithSubject();
	}

	@After
	public void tearDown() throws Exception {
		mentorswithsubject = null;
	}
	@Test
	public void getMentorWithSubjectTest() {
		assertFalse(mentorswithsubject.isEmpty());
	}

}
