package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.UserManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Field;
import models.User;

public class RegisterConnection extends HttpServlet {
 	private static UserManagement um = new UserManagement();
	private static ConnectionManagement cm = new ConnectionManagement();
	private static FieldManagement fm = new FieldManagement();

	/**
	 * placeholder serialnumber
	 */
	private static final long serialVersionUID = 1L;

	public RegisterConnection(){

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnectionWithMentor(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnectionWithMentor(request, response);
	}

	private static void createConnectionWithMentor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		int traineeUserID = Integer.parseInt(cookievalue);
		User trainee = um.getByID(traineeUserID);

		String formUserID = request.getParameter("userID");
		int mentorUserID = Integer.parseInt(formUserID);
		User mentor = um.getByID(mentorUserID);

		String fieldstring = request.getParameter("field");
		Field field = (Field) fm.getByTitle(fieldstring);

		cm.createConnection(mentor, trainee, field);

	}
}
