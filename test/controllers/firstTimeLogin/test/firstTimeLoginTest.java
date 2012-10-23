package controllers.firstTimeLogin.test;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

import org.apache.catalina.connector.Request;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.meterware.servletunit.ServletTestCase;

import controllers.CreateNewUserServlet;

public class firstTimeLoginTest extends JspTestCase{

	public void beginCreateNewUser(){
		RequestDispatcher rd = theConfig.getServletContext().getRequestDispatcher("")
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		User mentor = new User("Bob", "Saget", "bob@saget.com", "LA", "US", "1234");
		User trainee = new User("Joe", "Capri", "joe@capri.com", "SA", "US", "9876");
		
		
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void createOneConnectionAsTrainee(){
		
	}

}
