package models.test;

import static org.junit.Assert.*;

import models.Category;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category;
	
	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	@After
	public void tearDown() throws Exception {
		category = null;
	}

	@Test
	public void testTitle() {
		String title = "Programming Language";
		category.setTitle(title);
		assertEquals(title, category.getTitle());
	}
	
	@Test
	public void testDescription() {
		String description = "Category for all existing programming languages";
		category.setDescription(description);
		assertEquals(description, category.getDescription());
	}

}
