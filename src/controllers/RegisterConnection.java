package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterConnection extends HttpServlet {

	/**
	 * placeholder serialnumber
	 */
	private static final long serialVersionUID = 1L;

	public RegisterConnection(){
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnection(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnection(request, response);
	}
	
	private static void createConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String cookiename = "user_id";
		String cookievalue = "";
		
		for(int i = 0; i < cookies.length; i++){
			Cookie cookie = cookies[i];
			if(cookiename.equals(cookie.getName())){
				cookievalue = cookies[i].getValue();
			}
		}
		int userID = Integer.parseInt(cookievalue);
	}
}
