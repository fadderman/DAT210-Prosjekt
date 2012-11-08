package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.UserManagement;

import java.io.IOException;
import java.util.ArrayList;

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

//		for(int i = 0; i < cookies.length; i++){
//			Cookie cookie = cookies[i];
//			System.out.println(cookie.getValue());
//			if(cookiename.equals(cookie.getName())){
//				cookievalue = cookies[i].getValue();
//			}
//		}
//		int traineeUserID = Integer.parseInt(cookievalue);
//		User trainee = (User) request.getAttribute("user");
		User trainee = um.getByID(4);

		String formUserID = request.getParameter("userID");
		System.out.println(formUserID);
		int mentorUserID = Integer.parseInt(formUserID);
		User mentor = um.getByID(mentorUserID);

		String fieldstring = request.getParameter("field");
		System.out.println(fieldstring);
		ArrayList<Field> fields = (ArrayList<Field>) fm.getByTitle(fieldstring);
		Field field = fields.get(0);
		cm.createOpenTrainee(trainee, field);

	}
}
