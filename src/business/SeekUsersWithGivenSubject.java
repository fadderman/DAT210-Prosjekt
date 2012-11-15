package business;

import hibernate.ConnectionManagement;
import hibernate.FieldManagement;
import hibernate.RequestManagement;
import hibernate.UserManagement;

import java.util.ArrayList;
import java.util.List;

import models.Connection;
import models.Field;
import models.Request;
import models.User;

public class SeekUsersWithGivenSubject {

	//skal bruk en metode fra usermanagement for å få en liste med brukere
	private ArrayList<User> mentors;
	private ArrayList<User> trainee;
	private static FieldManagement fm = new FieldManagement();
	private static UserManagement um = new UserManagement();
	private static ConnectionManagement xm = new ConnectionManagement();
	private Field foundsubject;
	private ArrayList<Connection> connections;
	private RequestManagement rm = new RequestManagement();

	public SeekUsersWithGivenSubject(String subject) {
		foundsubject = fm.getSingleByTitle(subject);
		connections = new ArrayList<Connection>();
		mentors = new ArrayList<User>();
		trainee = new ArrayList<User>();
	}

	public ArrayList<User> getMentorsWithSbject() {
		connections = (ArrayList<Connection>) xm.getOpenMentorConnections(foundsubject);
		for(Connection conn : connections){
			mentors.add(conn.getMentor());
		}
		return mentors;
	}
	
	public ArrayList<User> getTrainee() {
		connections = (ArrayList<Connection>) xm.getOpenTraineeConnections(foundsubject);
		for(Connection conn : connections){
			trainee.add(conn.getTrainee());
		}
		
		return trainee;
	}

	public void setTrainee(ArrayList<User> trainee) {
		this.trainee = trainee;
	}
	
	public Field getFoundsubject() {
		return foundsubject;
	}

	public void setFoundsubject(Field foundsubject) {
		this.foundsubject = foundsubject;
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
	
	
}
