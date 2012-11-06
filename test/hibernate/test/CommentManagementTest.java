package hibernate.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
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
		
		xm.createOpenMentor(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Google tips"));
		xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++"));
		xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall"));
		xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));
		
		cm.createComment(xm.getByID(0), um.getByName("John", "First").get(0), "This is a text");
		cm.createComment(xm.getByID(1), um.getByEmail("johnfirst@gmail.com"), "This is some text");
		cm.createComment(xm.getByID(3), um.getByEmail("bob.second@outlook.com"), "Some random text");
		cm.createComment(xm.getByID(2), um.getByEmail("someguy@somewhere.com"), "Comment about programming");
//		cm.createComment(xm.getByID(4), um.getByEmail("johnfirst@gmail.com"), "This text is a comment from John First");
		
		

		



	}

	@Before
	public void setUp(){

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
			assertEquals(current.getClass(), Comment.class);
//			assertEquals(i.next().getClass(), Comment.class);
		}
		assertEquals(list.size(), 2);
	}

	@Test
	public void testGetCommentByTimestamp(){
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.add(Calendar.HOUR_OF_DAY, -1);
		toDate.setTime(new Date());
		
		


	}
	
	@Test
	public void testGetByConnection(){
	List<Comment> list = cm.getByConnection(xm.getByID(3));
	assertEquals(list.get(0).getAuthor().getEmail(), "bob.second@outlook.com");
	}	

	@Test
	public void testGetByID(){
		assertEquals(cm.createComment(xm.getByID(0), um.getByName("John", "First").get(0), "This is a text"), true);
		assertEquals(cm.createComment(xm.getByID(1), um.getByEmail("johnfirst@gmail.com"), "This is some text"), true);
		assertEquals(cm.createComment(xm.getByID(3), um.getByEmail("bob.second@outlook.com"), "Some random text"), true);
		assertEquals(cm.createComment(xm.getByID(2), um.getByEmail("someguy@somewhere.com"), "Comment about programming"), true);
		assertEquals(cm.getByID(1).getAuthor().getEmail(), "johnfirst@gmail.com");
	}
	
	@Test
	public void testChangeStatus(){
		cm.changeStatus(cm.getByID(1), false);
		cm.changeStatus(cm.getByID(2), false);
		
		List<Comment> list = cm.getAllInactiveComments();
		
		assertEquals(list.get(0).getComment(), "This is a text");
		assertEquals(list.get(1).getComment(), "This is some text");

	}
	
	@Test
	public void testUpdateText(){
		Comment comment = cm.getByID(3);
		cm.updateCommentText(comment, "A comment about programming language");
		
		comment = cm.getByID(3);
		assertEquals(comment.getComment(), "A comment about programming language");
	}
	



}
