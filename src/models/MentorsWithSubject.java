package models;

import java.util.ArrayList;
import java.util.LinkedList;

import business.SeekUsersWithGivenSubject;

public class MentorsWithSubject {
	private ArrayList<User> mentorsWithSubject;
	
	public MentorsWithSubject(String subject){
		mentorsWithSubject = new SeekUsersWithGivenSubject(subject).getMentorsWithSbject();
	}

	public ArrayList<User> getMentorsWithSubject() {
		return mentorsWithSubject;
	}

	public void setMentorsWithSubject(ArrayList<User> mentorsWithSubject) {
		this.mentorsWithSubject = mentorsWithSubject;
	}
	
}
