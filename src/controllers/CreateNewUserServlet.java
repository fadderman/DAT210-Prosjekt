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
		String[] field = request.getParameterValues("field");
		String[] traineeRadioButton = request.getParameterValues("trainee");
		String[] mentorRadioButton = request.getParameterValues("mentor");
		String[] description = request.getParameterValues("addInfo");
		String[] experience = request.getParameterValues("experience");

		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}


		User user = createNewUser(firstName, lastName, email, city, country, identifier);
		UserHandler userHandler = new UserHandler();
		userHandler.addUser(user);
		request.setAttribute("user", user);

		ConnectionHandler connectionHandler = new ConnectionHandler();
		Connection connection;
		

			String url = "/home.jsp";

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

	private User createNewUser(String firstName, String lastName, String email, String city, String country, String identifier){
		User user = new User(firstName, lastName, email, city, country, identifier);
		String mapURL = new String("http://maps.googleapis.com/maps/api/staticmap?center=");
		mapURL += city + ",";
		mapURL += country + "&zoom=12&size=500x150&sensor=false";
		user.setMapURL(mapURL);
		return user;
	}
	
	private void createConnection(User user, String[] field, String[] description, String[] experience, String[] traineeRadioButton, String[] mentorRadioButton){
		for(int i = 1; i < field.length; i++){
			if(traineeRadioButton[i-1].equals("Yes")){
				if(experience[i-1].equalsIgnoreCase("expert")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 2);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("intermediate")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 1);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("novice")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 0);
					connectionHandler.addConnection(connection);
				}
			}
			if(mentorRadioButton[i-1].equals("Yes")){
				if(experience[i-1].equalsIgnoreCase("expert")){
					connection = new Connection(user, new User("null") , new Field(field[i]), description[i], 2);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("intermediate")){
					connection = new Connection(user, new User("null"), new Field(field[i]), description[i], 1);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("novice")){
					connection = new Connection(user, new User("null"), new Field(field[i]), description[i], 0);
					connectionHandler.addConnection(connection);
				}
			}
			if((traineeRadioButton[i-1].equals("Yes") && mentorRadioButton[i-1].equals("Yes")) || (traineeRadioButton[i-1].equals("No") && mentorRadioButton[i-1].equals("No") )){
				if(experience[i-1].equalsIgnoreCase("expert")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 2);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("intermediate")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 1);
					connectionHandler.addConnection(connection);
				}
				if(experience[i-1].equalsIgnoreCase("novice")){
					connection = new Connection(new User("null"), user, new Field(field[i]), description[i], 0);
					connectionHandler.addConnection(connection);
				}
	}
	
}