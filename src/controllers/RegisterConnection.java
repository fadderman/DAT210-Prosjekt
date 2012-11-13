package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.RequestManagement;
import hibernate.UserManagement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnectionWithMentor(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnectionWithMentor(request, response);
	}

	private void createConnectionWithMentor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String isTraineeList = request.getParameter("isTraineeList");
		String formUserID = request.getParameter("userID");
		String fieldstring = request.getParameter("field");
		ArrayList<Field> fields = (ArrayList<Field>) fm.getByTitle(fieldstring);
		Field field = fields.get(0);
		Connection con = new Connection(field);
		
		if(isTraineeList.equalsIgnoreCase("true")){
			User trainee = (User) session.getAttribute("currentUser");
			int mentorUserID = Integer.parseInt(formUserID);
			User mentor = um.getByID(mentorUserID);
			con.setTrainee(trainee);
			cm.addConnection(con);
			rm.createRequest(mentor, con, true);
		}else{
			User mentor = (User) session.getAttribute("currentUser");
			int traineeUserID = Integer.parseInt(formUserID);
			User trainee = um.getByID(traineeUserID);
			con.setMentor(mentor);
			cm.addConnection(con);
			rm.createRequest(trainee, con, true);
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/field?id=" + field.getFieldID());
		dispatcher.forward(request, response);
	}
}
