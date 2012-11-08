package models.test;

import static org.junit.Assert.*;

import models.Request;
import org.junit.*;

public class RequestTest {
	
	private Request request;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		request = new Request();
	}
	
	@After
	public void tearDown() throws Exception{
		request = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	

}
