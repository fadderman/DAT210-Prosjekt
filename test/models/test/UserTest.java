package models.test;

import static org.junit.Assert.*;

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
	public void test() {
		assertEquals("hei", "hei");
	}

}
