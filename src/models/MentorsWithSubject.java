package models;

import java.util.ArrayList;
import java.util.LinkedList;

import business.SeekUsersWithGivenSubject;

public class MentorsWithSubject {
	private ArrayList<User> mentorsWithSubject;
	
	public MentorsWithSubject(){
		
	}
	
	public MentorsWithSubject(String subject){
		mentorsWithSubject = new SeekUsersWithGivenSubject(subject, true).getMentorsWithSbject();
	}

	public ArrayList<User> getMentorsWithSubject() {
		return mentorsWithSubject;
	}

	public void setMentorsWithSubject(String subject) {
		SeekUsersWithGivenSubject sug = new SeekUsersWithGivenSubject(subject, true);
		mentorsWithSubject = sug.getMentorsWithSbject();
	}
	
}
