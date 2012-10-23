package controllers.firstTimeLogin.test;

import com.meterware.httpunit.*;
import com.meterware.servletunit.*;
import java.util.*;
import junit.framework.*;

public class CreateNewUserServletTest extends TestCase {
	public static void main( String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static TestSuite suite() {
		return new TestSuite( CreateNewUserServletTest.class);
	}

	public CreateNewUserServletTest( String s){
		super(s);
	}

	public void testGetForm() throws Exception {
		ServletRunner sr = new ServletRunner("../DAT210-Prosjekt/WebContent/WEB-INF/web.xml");
		ServletUnitClient client = sr.newClient();
		try{
			System.out.println("Test av test");
			client.getResponse("/createNewUser");			
			
		} catch (AuthorizationRequiredException e) {
			System.out.println("finner ikke /createNewUser");
			fail("CreateNewUserSevlet is not protected");
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		client.setAuthorization("aUser", "mentor-password");
		client.getResponse("http://localhost/createNewUser");
	}

	/*public void testFormAction() throws Exception {
		ServletRunner sr = new ServletRunner( "../DAT210-Prosjekt/WebContent/WEB-INF/web.xml" );
		ServletUnitClient client = sr.newClient();
		client.setAuthorization( "aUser", "mentor-password");
		WebResponse response = client.getResponse( "http://localhost/createNewUser" );
		
		WebForm form = response.getFormWithID("register");
		assertNotNull("No form found with ID 'register'", form);
		assertEquals("Form method", "POST", form.getMethod());
		assertEquals("Form action", "", form.getAction());
	}
	*/
}