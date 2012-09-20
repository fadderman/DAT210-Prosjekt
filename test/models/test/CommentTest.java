package models.test;

import static org.junit.Assert.*;

import models.Comment;
import models.Connection;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommentTest {

	private Comment comment;
	
	@Before
	public void setUp() throws Exception {
		comment = new Comment();
	}

	@After
	public void tearDown() throws Exception {
		comment = null;
	}

	@Test
	public void testConnection() {
		Connection connection = new Connection();
		comment.setConnection(connection);
		assertEquals(connection, comment.getConnection());
	}
	
	@Test
	public void testAuthor() {
		User author = new User();
		comment.setAuthor(author);
		assertEquals(author, comment.getAuthor());
	}
	
	@Test
	public void testComment() {
		String c = "Dette var bra!";
		comment.setComment(c);
		assertEquals(c, comment.getComment());
	}

}
