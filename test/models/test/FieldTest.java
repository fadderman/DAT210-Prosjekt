package models.test;

import static org.junit.Assert.*;

import models.Subject;
import models.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	
	private Field field;

	@Before
	public void setUp() throws Exception {
		field = new Field();
	}

	@After
	public void tearDown() throws Exception {
		field = null;
	}
	
	@Test
	public void testTitle() {
		String title = "Java";
		field.setTitle(title);
		assertEquals(title, field.getTitle());
	}
	
	@Test
	public void testDescription() {
		String description = "Object Oriented Programming Language";
		field.setDescription(description);
		assertEquals(description, field.getDescription());
	}
	
	@Test
	public void testCategory() {
		Subject subject = new Subject();
		field.setSubject(subject);
		assertEquals(subject, field.getSubject());
	}

}
