package business;

import hibernate.UserManagement;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Connection;
import models.User;

public class SeekUsersWithGivenSubject {
	
	//skal bruken en metode fra Controlleren f�r � f� inn i hvilket faget mentor bli s�kt i
	//tom for n�
	private String subject;
	//skal bruk en metode fra usermanagement for � f�
	private LinkedList<User> mentors;
	
	private UserManagement userM = new UserManagement();
	
	public SeekUsersWithGivenSubject() {
		mentors = (LinkedList<User>) userM.listAllUsers();
	}
	
	private LinkedList<User> findMentors(){
		LinkedList<User> tempFoundMentors = new LinkedList<User>();
		for(User user : mentors){
			ArrayList<Connection> con = (ArrayList<Connection>) user.getConnectionMentor();
			if(con.isEmpty()){
				System.out.println("This user is not a mentor");
			}
			else {
				tempFoundMentors.add(user);
			}
		}
		mentors = tempFoundMentors;
		return mentors;
	}
}
