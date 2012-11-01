package controllers;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.UserManagement;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Connection;
import models.Field;
import models.User;
import business.connection.ConnectionHandler;
import business.user.UserHandler;

public class CreateNewUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String identifier = request.getParameter("identifier");
		String[] field = request.getParameterValues("field");
		String[] traineeRadioButton = request.getParameterValues("trainee");
		String[] mentorRadioButton = request.getParameterValues("mentor");
		String[] description = request.getParameterValues("addInfo");
		String[] experience = request.getParameterValues("experience");

		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}

		ConnectionHandler handler;
		
		User user = new User(firstName, lastName, email, city, country, identifier);
		request.setAttribute("user", user);
		handler = new ConnectionHandler(user, field, description, experience, traineeRadioButton, mentorRadioButton);
		
		String url = "/index.jsp";

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}