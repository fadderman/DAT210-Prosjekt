package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.RequestManagement;
import hibernate.UserManagement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Connection;
import models.Field;
import models.Request;
import models.User;

public class RegisterConnection extends HttpServlet {
 	private static UserManagement um = new UserManagement();
	private static ConnectionManagement cm = new ConnectionManagement();
	private static FieldManagement fm = new FieldManagement();
	private static RequestManagement rm = new RequestManagement();
	
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
		HttpSession session = request.getSession();
		
		User trainee = (User) session.getAttribute("currentUser");
		trainee = new User("nils", "pet", "enplass", "enaenplass","", "iD");
		um.addUser(trainee);

		String formUserID = request.getParameter("userID");
		System.out.println(formUserID);
		int mentorUserID = Integer.parseInt(formUserID);
		User mentor = um.getByID(mentorUserID);

		String fieldstring = request.getParameter("field");
		System.out.println(fieldstring);
		ArrayList<Field> fields = (ArrayList<Field>) fm.getByTitle(fieldstring);
		Field field = fields.get(0);
		Connection con = new Connection(field);
		con.setTrainee(trainee);
		cm.addConnection(con);
		rm.createRequest(mentor, con, true);
		
	}
}
