package business.connection;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.UserManagement;
import models.Connection;
import models.Field;
import models.User;

public class ConnectionHandler {
	public static int globalCounter = 0;
	ConnectionManagement connectionHandler;
	FieldManagement fm;
	UserManagement userHandler;
	User emptyUser, currentUser;

	public ConnectionHandler(User currentUser, String[] field, String[] description, String[] experience, String[] traineeRadioButton, String[] mentorRadioButton){
		this.currentUser = currentUser;
		emptyUser = new User();
		userHandler = new UserManagement();
		userHandler.addUser(currentUser);
		userHandler.addUser(emptyUser);
		connectionHandler = new ConnectionManagement();
		fm = new FieldManagement();
		for(int i = 1; i < field.length; i++){
			Field FIELD = new Field(field[i], description[i]);
			fm.addField(FIELD);
			createConnection(currentUser, field[i], description[i], experience[i], traineeRadioButton[i-1], mentorRadioButton[i-1], emptyUser, FIELD);			
		}
	}

	private void createConnection(User user, String field, String description, String experience, String traineeRadioButton, String mentorRadioButton, User emptyUser, Field FIELD){		
		Connection connection = new Connection();
		if(traineeRadioButton != "" && mentorRadioButton != ""){
			if(traineeRadioButton.equalsIgnoreCase("yes")){
				if(experience.equalsIgnoreCase("expert")){
					connection = new Connection(emptyUser, user, FIELD, description, 2);

				}
				if(experience.equalsIgnoreCase("intermediate")){
					connection = new Connection(emptyUser, user, FIELD, description, 1);

				}
				if(experience.equalsIgnoreCase("novice")){
					connection = new Connection(emptyUser, user, FIELD, description, 0);

				}
			}
			if(mentorRadioButton.equalsIgnoreCase("yes")){
				if(experience.equalsIgnoreCase("expert")){
					connection = new Connection(user, emptyUser , FIELD, description, 2);

				}
				if(experience.equalsIgnoreCase("intermediate")){
					connection = new Connection(user, emptyUser, FIELD, description, 1);

				}
				if(experience.equalsIgnoreCase("novice")){
					connection = new Connection(user, emptyUser, FIELD, description, 0);

				}
			}
			if((traineeRadioButton.equalsIgnoreCase("yes") && mentorRadioButton.equalsIgnoreCase("yes")) || (traineeRadioButton.equalsIgnoreCase("no") && mentorRadioButton.equalsIgnoreCase("no") )){
				if(experience.equalsIgnoreCase("expert")){
					connection = new Connection(emptyUser, user, FIELD, description, 2);

				}
				if(experience.equalsIgnoreCase("intermediate")){
					connection = new Connection(emptyUser, user, FIELD, description, 1);


				}
				if(experience.equalsIgnoreCase("novice")){
					connection = new Connection(emptyUser, user, FIELD, description, 0);


				}			
			}
			connectionHandler.addConnection(connection);
		}
	}
}