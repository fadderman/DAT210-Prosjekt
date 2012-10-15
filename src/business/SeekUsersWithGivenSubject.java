package business;

import hibernate.SubjectManagement;
import hibernate.UserManagement;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Connection;
import models.Subject;
import models.User;

public class SeekUsersWithGivenSubject {
	
	//skal bruk en metode fra usermanagement for å få en liste med brukere
	private static LinkedList<User> mentors;
	private LinkedList<Subject> subjects; 
	
	private UserManagement userM = new UserManagement();
	private SubjectManagement subjectm = new SubjectManagement();
	
	public SeekUsersWithGivenSubject(String subject) {
		mentors = (LinkedList<User>) userM.listAllUsers();
		subjects = (LinkedList<Subject>) subjectm.getByTitle(subject);
	}
	
	private static LinkedList<User> findMentors(){
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
		return tempFoundMentors;
	}
	
	public LinkedList<User> getMentorsWithSbject() {
		LinkedList<User> mentorsWithSubject = findMentors();
		for (User user: mentors){
			
		}
		return mentorsWithSubject;
		
	}
}
