package models;

import java.util.LinkedList;

import business.SeekUsersWithGivenSubject;

public class MentorsWithSubject {
	private LinkedList<User> mentorsWithSubject;
	
	public MentorsWithSubject(String subject){
		mentorsWithSubject = new SeekUsersWithGivenSubject(subject).getMentorsWithSbject();
	}

	public LinkedList<User> getMentorsWithSubject() {
		return mentorsWithSubject;
	}

	public void setMentorsWithSubject(LinkedList<User> mentorsWithSubject) {
		this.mentorsWithSubject = mentorsWithSubject;
	}
	
}
