package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import hibernate.*;

import models.*;

import org.junit.*;


public class CommentManagementTest {

	private static CommentManagement cm;
	private static ConnectionManagement xm;
	private static SubjectManagement sm;
	private static FieldManagement fm;
	private static UserManagement um;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();



		sm.createSubject("Programming", "Programming related");
		sm.createSubject("Non-programming", "not programming related");

		fm.createField("Java", "This is Java", sm.getSingleByTitle("Programming"));
		fm.createField("C++", "C plus plus", sm.getSingleByTitle("Programming"));
		fm.createField("Google tips", "Google like a pro", sm.getSingleByTitle("Non-programming"));
		fm.createField("Bathroom Wall", "How to copy code from the internet", sm.getSingleByTitle("Non-programming"));
		fm.createField("COBOL", "Old stuff for old ppl", sm.getSingleByTitle("Programming"));

		um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");



		//		xm.createConnection(mentor, trainee, field, difficultyLevel)
		//		xm.createConnection(um.getByName("", ""), um.getByName("", ""), fm.getByTitle(""), 1);
		//		cm.createComment(connection, author, text)
		//		
	}

	@Before
	public void setUp(){

	}



	//	@Test
	//	public void test() {
	//		fail("Not yet implemented");
	//	}

	@Test
	public void testCreateComment(){
		assertEquals(cm.createComment(xm.getByID(0), um.getByName("John", "First").get(0), "This is a text"), true);
		assertEquals(cm.createComment(xm.getByID(1), um.getByEmail("johnfirst@gmail.com"), "This is some text"), true);
		assertEquals(cm.createComment(xm.getByID(3), um.getByEmail("bob.second@outlook.com"), "Some random text"), true);
		assertEquals(cm.createComment(xm.getByID(2), um.getByEmail("someguy@somewhere.com"), "Comment about programming"), true);
	
	}

	@Test
	public void testGetAllComments(){
		List<Comment> list = cm.getAllComments();
		for(Iterator<Comment> i = list.iterator(); i.hasNext(); ){
			Comment current = i.next();
			System.out.println(current.getAuthor());
			assertEquals(current.getClass(), Comment.class);
			assertEquals(i.next().getClass(), Comment.class);
		}
		assertEquals(list.size(), 4);

	}

	@Test
	public void testGetCommentByAuthor(){
		List<Comment> list = cm.getCommentByAuthor(um.getByEmail("johnfirst@gmail.com"));
	
		for(Iterator<Comment> i = list.iterator(); i.hasNext(); ){
			Comment current = i.next();
			System.out.println(current.getAuthor());
			assertEquals(current.getClass(), Comment.class);
			assertEquals(i.next().getClass(), Comment.class);
		}
	}

	@Test
	public void testGetCommentByTimestamp(){




	}
	
	@Test
	public void testGetCommentByConnection(){
	
	}
//
//	@Test
//	public void testUpdateCommentText(){
//		//		List<Comment> test = cm.getCommentByAuthor(author);
//		//		cm.updateCommentText(test.get(0), "");
//		//		assertEquals(cm.getCommentByAuthor(author), "");
//
//	}

	@Test
	public void testChangeStatus(){
		cm.changeStatus(cm.getByID(1), false);
		cm.changeStatus(cm.getByID(2), false);
		
		List<Field> list = fm.getAllInactiveFields();
		
		assertEquals(list.get(0).getDescription(), "Programming related");
		assertEquals(list.get(1).getDescription(), "not programming related");	
	}
	
	
//	@Test
//	public void testChangeStatus(){
//		cm.changeStatus(cm.getByID(0), false);
//		cm.changeStatus(cm.getByID(1), false);
//		
//		List<Comment> list = cm.getAllInactiveComments();
//		assertEquals(list.get(0).getAuthor().getEmail(), "johnfirst@gmail.com");
//		assertEquals(list.get(1).getAuthor().getEmail(), "bob.second@outlook.com");
//
//	}

	@Test
	public void testGetByID(){
		assertEquals(cm.createComment(xm.getByID(0), um.getByName("John", "First").get(0), "This is a text"), true);
		assertEquals(cm.createComment(xm.getByID(1), um.getByEmail("johnfirst@gmail.com"), "This is some text"), true);
		assertEquals(cm.createComment(xm.getByID(3), um.getByEmail("bob.second@outlook.com"), "Some random text"), true);
		assertEquals(cm.createComment(xm.getByID(2), um.getByEmail("someguy@somewhere.com"), "Comment about programming"), true);
		assertEquals(cm.getByID(1).getAuthor().getEmail(), "johnfirst@gmail.com");
	}
	
	@Test
	public void testUpdateText(){
		Comment comment = cm.getByID(3);
		cm.updateCommentText(comment, "A comment about programming language");
		
		comment = cm.getByID(3);
		assertEquals(comment.getComment(), "A comment about programming language");
	}
	



}
