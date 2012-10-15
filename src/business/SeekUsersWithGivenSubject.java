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
	private LinkedList<User> mentors;
	private LinkedList<Subject> subjects;
	
	private String subject;
	
	
	public SeekUsersWithGivenSubject(String subject) {
		mentors = findMentors();
		this.subject = subject;
	}
	
	private static LinkedList<User> findMentors(){
		LinkedList<User> users = (LinkedList<User>)  (new UserManagement().listAllUsers());
		LinkedList<User> tempFoundMentors = new LinkedList<User>();
		for(User user : users){
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
		LinkedList<User> mentorsWithSubject = new LinkedList<User>();
		for (User user: mentors){
			ArrayList<Connection> con = (ArrayList<Connection>) user.getConnectionMentor();
			for (Connection conn : con){
				if(subject == conn.getField().getSubject().getTitle()){
					mentorsWithSubject.add(user);
				} 
				if(subject == conn.getField().getTitle()) {
					mentorsWithSubject.add(user);
				}
				else {
					System.out.println("this mentor has not look for subject");
				}
			}
			
		}
		return mentorsWithSubject;
	}
}
