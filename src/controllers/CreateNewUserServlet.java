package controllers;

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
		String[] category = request.getParameterValues("category");
		String[] field = request.getParameterValues("field");
		String[] radioTrainee = request.getParameterValues("trainee");
		String[] radioMentor = request.getParameterValues("mentor");
		String[] extraInfo = request.getParameterValues("addInfo");
		String[] experience = request.getParameterValues("experience");

		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}
		
		
		User user = new User(firstName, lastName, email, city, country, identifier);
		String mapURL = new String("http://maps.googleapis.com/maps/api/staticmap?center=");
		mapURL += city + ",";
		mapURL += country + "&zoom=14&size=400x400&sensor=false";
		user.setMapURL(mapURL);
		UserHandler userHandler = new UserHandler();
		userHandler.addUser(user);
		request.setAttribute("user", user);
		
		int SessionInt = 0;
		ConnectionHandler connectionHandler = new ConnectionHandler();
		Connection connection;
		for(int i = 1; i < category.length; i++){
			if(radioTrainee[i].equals("Yes")){
				if(experience[i].equalsIgnoreCase("expert")){
					connection = new Connection(new User(), user, new Field(field[i]), 2, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("intermediate")){
					connection = new Connection(new User(), user, new Field(field[i]), 1, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("novice")){
					connection = new Connection(new User(), user, new Field(field[i]), 0, SessionInt++);
					connectionHandler.addConnection(connection);
				}				
			}
			if(radioMentor[i].equals("Yes")){
				if(experience[i].equalsIgnoreCase("expert")){
					connection = new Connection(user, new User(), new Field(field[i]), 2, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("intermediate")){
					connection = new Connection(user, new User(), new Field(field[i]), 1, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("novice")){
					connection = new Connection(user, new User(), new Field(field[i]), 0, SessionInt++);
					connectionHandler.addConnection(connection);
				}				
			}
			
			if(radioTrainee[i].equals("Yes") && radioMentor[i].equals("Yes") || radioTrainee[i].equals("No") && radioMentor[i].equals("No")){
				if(experience[i].equalsIgnoreCase("expert")){
					connection = new Connection(new User(), user, new Field(field[i]), 2, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("intermediate")){
					connection = new Connection(new User(), user, new Field(field[i]), 1, SessionInt++);
					connectionHandler.addConnection(connection);
				}
				if(experience[i].equalsIgnoreCase("novice")){
					connection = new Connection(new User(), user, new Field(field[i]), 0, SessionInt++);
					connectionHandler.addConnection(connection);
				}				
			}
			
		}
		
		System.out.println(lastName + " " + firstName + " " + email + " " + country);
		for(int i = 0; i < category.length; i++){
			System.out.print("Sub: " + category[i] + " field: " + field[i]);
			System.out.println(" extra: " + extraInfo[i]);
		}
		for(int i = 0; i < radioTrainee.length; i++) if(radioTrainee[i] != null) System.out.println(radioTrainee[i]);
		String url = "/home.jsp";
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
