package business;

import hibernate.UserManagement;

import java.util.LinkedList;

import models.User;

public class SeekUsersWithGivenSubject {
	
	//skal bruken en metode fra Controlleren får å få inn i hvilket faget mentor bli søkt i
	//tom for nå
	private String subject;
	//skal bruk en metode fra usermanagement for å få
	private LinkedList<User> mentors;
	
	private UserManagement userM = new UserManagement();
	
	public SeekUsersWithGivenSubject() {
		mentors = (LinkedList<User>) userM.listAllUsers();
	}
	
	private LinkedList<User> findMentors(){
		
		return mentors;
	}
}
