package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.user.UserHandler;

import models.User;

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
		String[] category = request.getParameterValues("category");
		String[] field = request.getParameterValues("field");
		
		User user = new User(identifier, firstName, lastName, email, city);
		String location = new String("http://maps.googleapis.com/maps/api/staticmap?center=");
		location += city + ",";
		location += country + "&zoom=14&size=400x400&sensor=false";
		user.setLocation(location);
		UserHandler userHandler = new UserHandler();
		userHandler.addUser(user);
		request.setAttribute("user", user);
		
		System.out.println(lastName + " " + firstName + " " + email + " " + country);
		for(int i = 0; i < category.length; i++) System.out.println(category[i]);
		String url = "/home.jsp";
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
