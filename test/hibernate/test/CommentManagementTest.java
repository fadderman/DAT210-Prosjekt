package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import hibernate.*;

import models.Comment;

import org.junit.Before;
import org.junit.Test;

public class CommentManagementTest {
	
	private CommentManagement cm;
	private ConnectionManagement xm;
	private SubjectManagement sm;
	private FieldManagement fm;
	private UserManagement um;
	
	@Before
	public void setUp() throws Exception{
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
		
		
//		xm.createConnection(mentor, trainee, field, difficultyLevel)
//		xm.createConnection(um.getByName("", ""), um.getByName("", ""), fm.getByTitle(""), 1);
//		cm.createComment(connection, author, text)
//		
	}
	
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateComment(){
//		assertEquals(cm.createComment(connection, author, text), true);
//		assertEquals(cm.createComment(connection, author, text), true);
//		assertEquals(cm.createComment(connection, author, text), true);
//		assertEquals(cm.createComment(connection, author, text), true);
		
	}
	
	@Test
	public void testGetAllComments(){
		List<Comment> list = cm.getAllComments();
		for(Iterator<Comment> i = list.iterator(); i.hasNext(); ){
			Comment current = i.next();
			System.out.println(current.getAuthor());
			assertEquals(current.getClass(), String.class);
		}
		
	}
	
	@Test
	public void testGetCommentByAuthor(){
		List<Comment> list = cm.getCommentByAuthor(null);
		assertEquals(list.get(0).getCommentID(), 0);	//getCommentID? ok?
		
	}
	
	@Test
	public void testGetCommentByTimestamp(){
		
		
		
		
	}
	
	@Test
	public void testUpdateCommentText(){
//		List<Comment> test = cm.getCommentByAuthor(author);
//		cm.updateCommentText(test.get(0), "");
//		assertEquals(cm.getCommentByAuthor(author), "");
		
	}
	
	@Test
	public void testChangeStatus(){
		Comment test = cm.getByID(3);
		cm.changeStatus(test, false);
		
		List<Comment> list = cm.getAllInactiveComments();
		for(Iterator<Comment> iterator = list.iterator(); iterator.hasNext();){
			Comment current = iterator.next();
			System.out.println(current.getAuthor());
			assertEquals(current.isActive(), false);
		}
		
	}

}
