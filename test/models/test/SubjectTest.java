package models.test;

import static org.junit.Assert.*;

import models.Category;
import models.Subject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectTest {
	
	private Subject subject;

	@Before
	public void setUp() throws Exception {
		subject = new Subject();
	}

	@After
	public void tearDown() throws Exception {
		subject = null;
	}
	
	@Test
	public void testTitle() {
		String title = "Java";
		subject.setTitle(title);
		assertEquals(title, subject.getTitle());
	}
	
	@Test
	public void testDescription() {
		String description = "Object Oriented Programming Language";
		subject.setDescription(description);
		assertEquals(description, subject.getDescription());
	}
	
	@Test
	public void testCategory() {
		Category category = new Category();
		subject.setCategory(category);
		assertEquals(category, subject.getCategory());
	}

}
