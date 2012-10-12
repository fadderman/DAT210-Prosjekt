package business;

import hibernate.UserManagement;

import java.util.LinkedList;

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
		
		return mentors;
	}
}
