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

	private static final String servletPathForMentor = "/RegisterMentor";
	private static final String servletPathForTrainee = "/RegisterTrainee";
	/**
	 * placeholder serialnumber
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		if(servletPathForMentor.equalsIgnoreCase(servletPath)){
			createConnectionWithMentor(request, response);
		}
		if(servletPathForTrainee.equalsIgnoreCase(servletPath)){
			createConnectionWithTrainee(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		if(servletPathForMentor.equalsIgnoreCase(servletPath)){
			createConnectionWithMentor(request, response);
		}
		if(servletPathForTrainee.equalsIgnoreCase(servletPath)){
			createConnectionWithTrainee(request, response);
		}
	}

	private void createConnectionWithMentor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String isTraineeList = request.getParameter("isTraineeList");
		
		User trainee = (User) session.getAttribute("currentUser");
		trainee = new User("nils", "pet", "enplass", "enaenplass","", "iD");
		um.addUser(trainee);

		String formUserID = request.getParameter("userID");
		String fieldstring = request.getParameter("field");
		int traineeUserID = Integer.parseInt(formUserID);
		User mentor = um.getByID(traineeUserID);
		
		ArrayList<Field> fields = (ArrayList<Field>) fm.getByTitle(fieldstring);
		Field field = fields.get(0);
		Connection con = new Connection(field);
		con.setTrainee(trainee);
		cm.addConnection(con);
		rm.createRequest(mentor, con, true);

	}

	private static void createConnectionWithTrainee(HttpServletRequest request, HttpServletResponse response){
		System.out.println("gotten into trainee metode");
		HttpSession session = request.getSession();

		User mentor = (User) session.getAttribute("currentUser");
		mentor = new User("johannes", "petter", "enplass1", "enaenplass2","", "iD");
		um.addUser(mentor);

		String formUserID = request.getParameter("userID");
		System.out.println(formUserID);
		int traineeUserID = Integer.parseInt(formUserID);
		User trainee = um.getByID(traineeUserID);

		String fieldstring = request.getParameter("field");
		System.out.println(fieldstring);
		ArrayList<Field> fields = (ArrayList<Field>) fm.getByTitle(fieldstring);
		Field field = fields.get(0);
		Connection con = new Connection(field);
		con.setMentor(mentor);
		cm.addConnection(con);
		rm.createRequest(trainee, con, true);
				
		RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher("/field?id=" + field.getFieldID());
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
