package hibernate.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import hibernate.*;

import models.*;

import org.junit.*;

public class FieldManagementTest {

	private static ConnectionManagement xm;
	private static FieldManagement fm;
	private static UserManagement um;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xm = new ConnectionManagement();
		fm = new FieldManagement();

		um = new UserManagement();

		um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");
		
		fm.createField("Java", "This is Java");
		fm.createField("C++", "C plus plus");
		fm.createField("Google tips", "Google like a pro");
		fm.createField("Bathroom Wall", "How to copy code from the internet");
		fm.createField("COBOL", "Old stuff for old ppl");
		
		fm.createField("Programming", "Parent field for programming related fields");
		fm.createField("Non-programming", "parent subject for fields not related to programming directly");
		
		xm.createOpenMentor(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Google tips"));
		xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++"));
		xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall"));
		xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));
		
		fm.buildTree(fm.getSingleByTitle("Java"), fm.getSingleByTitle("Programming"));
		fm.buildTree(fm.getSingleByTitle("C++"), fm.getSingleByTitle("Programming"));
		fm.buildTree(fm.getSingleByTitle("COBOL"), fm.getSingleByTitle("Programming"));
		fm.buildTree(fm.getSingleByTitle("Google tips"), fm.getSingleByTitle("Non-programming"));
		fm.buildTree(fm.getSingleByTitle("Bathroom Wall"), fm.getSingleByTitle("Non-programming"));
		fm.buildTree(fm.getSingleByTitle("Bathroom Wall"), fm.getSingleByTitle("Programming"));
	}
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testGetAllFields(){
		List<Field> list = fm.getAllFields();
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			assertEquals(i.next().getClass(), Field.class);
		}
		assertEquals(list.size(), 7);
	}
	
	@Test
	public void testChangeStatus(){
		fm.changeStatus(fm.getSingleByTitle("COBOL"), false);
		fm.changeStatus(fm.getSingleByTitle("Bathroom Wall"), false);
		
		List<Field> list = fm.getAllInactiveFields();
		
		assertEquals(list.get(0).getTitle(), "Bathroom Wall");
		assertEquals(list.get(1).getTitle(), "COBOL");	
	}

	@Test
	public void testGetByID(){
		assertEquals(fm.getByID(1).getTitle(), "Java");
	}
	
	@Test
	public void testGetByTitle(){
		List<Field> list = fm.getByTitle("Google tips");
		assertEquals(list.get(0).getTitle(), "Google tips");
		
	}
	
	@Test
	public void testGetSingleByTitle(){
		Field f = fm.getSingleByTitle("C++");
		assertEquals(f.getTitle(), "C++");
	}
	
	@Test
	public void testUpdateTitle(){
		Field f = fm.getSingleByTitle("C++");
		fm.updateTitle(f, "C--");
		
		assertEquals(fm.getByID(2).getTitle(), "C--");
	}
	
	@Test
	public void testUpdateDescription(){
		List<Field> list = fm.getByTitle("Google tips");
		
		fm.updateDescription(list.get(0), "Pro Googling tips for n00bs");
		
		assertEquals(fm.getSingleByTitle("Google tips").getDescription(), "Pro Googling tips for n00bs");
	}
	
	@Test
	public void testGetFieldByParent(){
		List<Field> list = fm.getByParent(fm.getSingleByTitle("Programming"));
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			Field current = i.next();
			assertEquals(current.getClass(), Field.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetFieldByChild(){
		fm.changeStatus(fm.getByID(4), true);
		List<Field> list = fm.getByChild(fm.getSingleByTitle("Bathroom Wall"));
		for(Iterator<Field> i = list.iterator(); i.hasNext();){
			Field current = i.next();
			System.out.println(current.getTitle());
			assertEquals(current.getClass(), Field.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetSingleBranch(){
		FieldTree result = fm.getSingleBranch(fm.getSingleByTitle("C--"), fm.getSingleByTitle("Programming"));
		assertEquals(result.getClass(), FieldTree.class);
		System.out.println("FieldTree id: " + result.getFieldTreeID() + " connects " + result.getParent().getTitle() + " as a parent and " + result.getChild().getTitle() + " as a child.");
		assertEquals(result.getFieldTreeID(), 2);
	}
	
	@Test
	public void testToggleBranchStatus(){
		fm.toggleBranchStatus(fm.getSingleByTitle("C--"), fm.getSingleByTitle("Programming"), false);
		FieldTree branch = fm.getSingleBranch(fm.getSingleByTitle("C--"), fm.getSingleByTitle("Programming"));
		assertEquals(branch.isActive(), false);
	}
	
	@Test
	public void testFetchConnectionList(){
		List<Connection> list = fm.fetchConnectionList(fm.getSingleByTitle("Java"));
		for(Iterator<Connection> i = list.iterator(); i.hasNext();){
			Connection current = i.next();
			assertEquals(current.getClass(), Connection.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetMentors(){
		List<User> list = fm.getMentors(fm.getSingleByTitle("Java"));
		for(Iterator<User> i = list.iterator(); i.hasNext();){
			User current = i.next();
			assertEquals(current.getClass(), User.class);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetTrainees(){
		List<User> list = fm.getTrainees(fm.getSingleByTitle("Google tips"));
		for(Iterator<User> i = list.iterator(); i.hasNext();){
			User current = i.next();
			assertEquals(current.getClass(), User.class);
		}
		assertEquals(list.size(), 1);
	}
}
