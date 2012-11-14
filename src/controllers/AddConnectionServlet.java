package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Connection;
import models.Field;
import models.User;

/**
 * Servlet implementation class AddConnectionServlet
 */
@WebServlet("/AddConnectionServlet")
public class AddConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionManagement connectionManagement;
	private FieldManagement fieldManagement;
	
	private boolean mentor = false;
	private int difficultyLevel = 0;

    public AddConnectionServlet() {
        connectionManagement = new ConnectionManagement();
        fieldManagement = new FieldManagement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = new Connection();
		Field field;
		
		String fieldTitle = request.getParameter("field");
		String mentorTrainee = request.getParameter("optionsRadios");
		String description = request.getParameter("addInfo");
		String experience = request.getParameter("experience");
		if(experience.equals("novice")) {
			difficultyLevel = 0;
		} else if(experience.equals("intermediate")) {
			difficultyLevel = 1;
		} else if(experience.equals("expert")) {
			difficultyLevel = 2;
		}
		
		if(mentorTrainee.equals("Mentor")) {
			mentor = true;
		} else {
			mentor = false;
		}
		
		User currentUser = (User) session.getAttribute("currentUser");
		
		if(mentor) {
			connection.setMentor(currentUser);
		} else {
			connection.setTrainee(currentUser);
		}
		
		field = fieldManagement.getSingleByTitle(fieldTitle);
		if(field == null) {
			field = new Field();
			field.setActive(true);
			field.setTitle(fieldTitle);
			field.setDescription(description);
			fieldManagement.addField(field);
		}
		
		connection.setActive(true);
		connection.setField(field);
		connection.setDifficultyLevel(difficultyLevel);

		connectionManagement.addConnection(connection);
		
		request.setAttribute("active", "connections");
		request.setAttribute("include", "connections.jsp");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
