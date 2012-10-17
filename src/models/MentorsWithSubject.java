package models;

import java.util.ArrayList;
import java.util.LinkedList;

import business.SeekUsersWithGivenSubject;

public class MentorsWithSubject {
	private ArrayList<User> mentorsWithSubject;
	
	public MentorsWithSubject(){
		
	}
	
	public MentorsWithSubject(String subject){
		mentorsWithSubject = new SeekUsersWithGivenSubject(subject).getMentorsWithSbject();
	}

	public ArrayList<User> getMentorsWithSubject() {
		return mentorsWithSubject;
	}

	public void setMentorsWithSubject(String subject) {
		SeekUsersWithGivenSubject sug = new SeekUsersWithGivenSubject(subject);
		mentorsWithSubject = sug.getMentorsWithSbject();
	}
	
}
