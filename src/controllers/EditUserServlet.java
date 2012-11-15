package controllers;

import hibernate.UserManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserManagement userManagement;
	
    public EditUserServlet() {
        userManagement = new UserManagement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User currentUser = null;
		
		int userId = -1;
		try {
			userId = Integer.parseInt(request.getParameter("userId"));
		} catch (NumberFormatException e) {
			System.err.println("Incoming String is not a number");
		}
		
		if(userId != -1) {
			currentUser = userManagement.getByID(userId);
		}
		
		if(currentUser != null) {		
			String fullName = request.getParameter("name");
			String city = request.getParameter("locationCity");
			String country = request.getParameter("locationCountry");
			String email = request.getParameter("email");
			
			String lastName = fullName.substring(fullName.lastIndexOf(" "), fullName.length());
			String firstName = fullName.substring(0, fullName.lastIndexOf(" "));
			
			userManagement.updateFirstName(firstName.trim(), currentUser);
			userManagement.updateLastName(lastName.trim(), currentUser);
			userManagement.updateLocation(city, country, currentUser);
			userManagement.updateEmail(email, currentUser);
			
		}
		
		request.setAttribute("include", "profile");
		request.setAttribute("active", "profile");
		
		currentUser = userManagement.getByID(userId);
		request.getSession().setAttribute("currentUser", currentUser);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
