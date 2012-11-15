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
	private ArrayList<User> mentors = new ArrayList<User>();
	private static FieldManagement fm = new FieldManagement();
	private static UserManagement um = new UserManagement();
	private static ConnectionManagement xm = new ConnectionManagement();
	private Field foundsubject;
	private ArrayList<Connection> connections;
	private RequestManagement rm = new RequestManagement();

	public SeekUsersWithGivenSubject(String subject, boolean isLookingForMentors) {
		foundsubject = fm.getSingleByTitle(subject);
		if(foundsubject != null){
			if(isLookingForMentors){
				connections = (ArrayList<Connection>) xm.getOpenMentorConnections(foundsubject);
			}else{
				connections = (ArrayList<Connection>) xm.getOpenTraineeConnections(foundsubject);
			}
			ArrayList<Request> requests = (ArrayList<Request>) rm.getAllRequests();
			for(int k=0; k<requests.size();k++){
				for(int i = 0; i<connections.size();i++){
					if(requests.get(k).getConnection().getConnectionID()==connections.get(i).getConnectionID()){
						connections.remove(i);
					}
				}
			}
			for(Connection conn : connections){
				if(isLookingForMentors){
					mentors.add(conn.getMentor());
				}else{
					mentors.add(conn.getTrainee());
				}
			}	
		}
	}

	public ArrayList<User> getMentorsWithSbject() {
		return mentors;
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
