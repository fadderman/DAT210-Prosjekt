package models;

import java.util.ArrayList;

import business.SeekUsersWithGivenSubject;

public class MentorsWithField{
	private ArrayList<User> mentorsWithSubject;
	
	public MentorsWithField(){
	}

	public MentorsWithField(String subject){
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
