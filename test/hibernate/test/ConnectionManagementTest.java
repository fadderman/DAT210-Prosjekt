package hibernate.test;

import static org.junit.Assert.*;
import hibernate.CommentManagement;
import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.SubjectManagement;
import hibernate.UserManagement;

import org.junit.Before;
import org.junit.Test;

public class ConnectionManagementTest {

	private CommentManagement cm;
	private ConnectionManagement xm;
	private FieldManagement fm;
	private SubjectManagement sm;
	private UserManagement um;

	@Before
	public void setUp() throws Exception {
		
		cm = new CommentManagement();
		xm = new ConnectionManagement();
		fm = new FieldManagement();
		sm = new SubjectManagement();
		um = new UserManagement();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
