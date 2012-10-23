package models.test;

import static org.junit.Assert.*;

import models.Subject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectTest {
	private Subject subject;

	@Before
	public void setUp() throws Exception{
	subject = new Subject();
	}
	
	@After
	public void tearDown() throws Exception{
		subject = null;
	}
	
	@Test
	public void testActive() {
		
	}
	
	@Test
	public void testTitle(){
		String title = "Java3D";
		subject.setTitle(title);
		assertEquals(title, subject.getTitle());
	}
	@Test
	public void testDescription(){
		String description = "Programming language";
		subject.setTitle(description);
		assertEquals(description, subject.getDescription());
	}


}
