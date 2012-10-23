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
	private static SubjectManagement sm;
	private static UserManagement um;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
		
		sm.createSubject("Programming", "Programming related");
		sm.createSubject("Non-programming", "not programming related");
		
		um.createUser("John", "First", "johnfirst@gmail.com", "Here", "It exits on Earth", "numero uno");
		um.createUser("Bob", "Second", "bob.second@outlook.com", "Not far away", "Ground", "numero dos");
		um.createUser("Bob", "Last", "phil@last.com", "Here", "It exits on Earth", "numero tres");
		um.createUser("Some", "Guy", "someguy@somewhere.com", "Somewhere", "Place", "numero quatro");
		
		fm.createField("Java", "This is Java", sm.getSingleByTitle("Programming"));
		fm.createField("C++", "C plus plus", sm.getSingleByTitle("Programming"));
		fm.createField("Google tips", "Google like a pro", sm.getSingleByTitle("Non-programming"));
		fm.createField("Bathroom Wall", "How to copy code from the internet", sm.getSingleByTitle("Non-programming"));
		fm.createField("COBOL", "Old stuff for old ppl", sm.getSingleByTitle("Programming"));
		
		fm.createField("Programming", "Parent field for programming related fields", sm.getSingleByTitle("Programming"));
		fm.createField("Non-programming", "parent subject for fields not related to programming directly", sm.getSingleByTitle("Non-programming"));
		
		fm.setParentField(fm.getSingleByTitle("Java"), fm.getSingleByTitle("Programming"));
		fm.setParentField(fm.getSingleByTitle("C++"), fm.getSingleByTitle("Programming"));
		fm.setParentField(fm.getSingleByTitle("COBOL"), fm.getSingleByTitle("Programming"));
		fm.setParentField(fm.getSingleByTitle("Google tips"), fm.getSingleByTitle("Non-programming"));
		fm.setParentField(fm.getSingleByTitle("Bathroom Wall"), fm.getSingleByTitle("Non-programming"));
		
		xm.createOpenMentor(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Java"));
		xm.createOpenMentor(um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Google tips"));
		xm.createOpenTrainee(um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("C++"));
		xm.createOpenTrainee(um.getByEmail("someguy@somewhere.com"), fm.getSingleByTitle("Bathroom Wall"));
		xm.createOpenTrainee(um.getByEmail("phil@last.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("someguy@somewhere.com"), um.getByEmail("bob.secon@outlook.com"), fm.getSingleByTitle("COBOL"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("johnfirst@gmail.com"), fm.getSingleByTitle("Google tips"));
		xm.createConnection(um.getByEmail("phil@last.com"), um.getByEmail("bob.second@outlook.com"), fm.getSingleByTitle("Bathroom Wall"));
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
		assertEquals(list.size(), 4);
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
