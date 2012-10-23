package business.connection;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.UserManagement;
import models.Connection;
import models.Field;
import models.User;

public class ConnectionHandler {
	private User theUser;
	ConnectionManagement connectionHandler = new ConnectionManagement();
	FieldManagement fm = new FieldManagement();
	Connection connection;
	
	public ConnectionHandler(String firstName, String lastName, String email, String city, String country, String identifier, String[] field, String[] description, String[] experience, String[] traineeRadioButton, String[] mentorRadioButton){
		theUser = createNewUser(firstName, lastName, email, city, country, identifier);
		User emptyUser = new User();
		UserManagement userHandler = new UserManagement();
		userHandler.addUser(theUser);
		userHandler.addUser(emptyUser);
		
		for(int i = 1; i < field.length; i++){
			Field FIELD = new Field(field[i], description[i]);
			fm.addField(FIELD);
			connection = createConnection(theUser, field[i], description[i], experience[i], traineeRadioButton[i-1], mentorRadioButton[i-1], emptyUser, FIELD);
			connectionHandler.addConnection(connection);
		}
	}
	
	public User createNewUser(String firstName, String lastName, String email, String city, String country, String identifier){
		User user = new User(firstName, lastName, email, city, country, identifier);
		String mapURL = new String("http://maps.googleapis.com/maps/api/staticmap?center=");
		mapURL += city + ",";
		mapURL += country + "&zoom=12&size=500x150&sensor=false";
		user.setMapURL(mapURL);
		return user;
	}
	
	private Connection createConnection(User user, String field, String description, String experience, String traineeRadioButton, String mentorRadioButton, User emptyUser, Field FIELD){
		Connection connection = new Connection();
		System.out.println("user: " + user);
		System.out.println("field: " + field);
		System.out.println("des: " + description);
		System.out.println("exp: " + experience);
		System.out.println("tra: " + traineeRadioButton);
		System.out.println("men: " + mentorRadioButton);
		
		if(traineeRadioButton.equalsIgnoreCase("yes")){
			if(experience.equalsIgnoreCase("expert")){
				connection = new Connection(emptyUser, user, FIELD, description, 2);
				System.out.println("11");
			}
			else if(experience.equalsIgnoreCase("intermediate")){
				connection = new Connection(emptyUser, user, FIELD, description, 1);
				System.out.println("12");
			}
			else if(experience.equalsIgnoreCase("novice")){
				System.out.println(connection.getField());
				connection = new Connection(emptyUser, user, FIELD, description, 0);
				System.out.println("13");
				System.out.println(connection.getField());
			}
		}
		else if(mentorRadioButton.equalsIgnoreCase("yes")){
			if(experience.equalsIgnoreCase("expert")){
				connection = new Connection(user, emptyUser , FIELD, description, 2);
				System.out.println("21");
			}
			else if(experience.equalsIgnoreCase("intermediate")){
				connection = new Connection(user, emptyUser, FIELD, description, 1);
				System.out.println("22");
			}
			else if(experience.equalsIgnoreCase("novice")){
				connection = new Connection(user, emptyUser, FIELD, description, 0);
				System.out.println("23");
			}
		}
		else if((traineeRadioButton.equalsIgnoreCase("yes") && mentorRadioButton.equalsIgnoreCase("yes")) || (traineeRadioButton.equalsIgnoreCase("no") && mentorRadioButton.equalsIgnoreCase("no") )){
			if(experience.equalsIgnoreCase("expert")){
				connection = new Connection(emptyUser, user, FIELD, description, 2);
				System.out.println("31");
			}
			else if(experience.equalsIgnoreCase("intermediate")){
				connection = new Connection(emptyUser, user, FIELD, description, 1);
				System.out.println("32");

			}
			else if(experience.equalsIgnoreCase("novice")){
				connection = new Connection(emptyUser, user, FIELD, description, 0);
				System.out.println("33");

			}
		}
		System.out.println(connection.getField()+"LOTTTTTTTTTTTTTTTTTSA SPAC");
		return connection;
	}
	
	public User getUser(){
		return theUser;
	}
}
