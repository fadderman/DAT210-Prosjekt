package controllers.firstTimeLogin.test;

import org.springframework.mock.web.MockHttpServletRequest;

import sun.rmi.server.Dispatcher;

import junit.framework.TestCase;

public class testCases extends TestCase{
		public void testReadOpContext() throws Exception {
			MockHttpServletRequest request = new MockHttpServletRequest();
			request.setContextPath("/MentorFind");
			request.setRequestURI("/MentorFind/createNewUser");
			
			Dispatcher dispatcher = new Dispatcher();
			Map map = dispatcher.readOpContext(request);
		}
}
