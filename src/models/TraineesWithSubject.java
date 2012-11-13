package models;

import java.util.ArrayList;
import java.util.LinkedList;

import business.SeekUsersWithGivenSubject;

public class TraineesWithSubject {
	private ArrayList<User> traineesWithSubject;
	
	public TraineesWithSubject(){	
	}
	
	public TraineesWithSubject(String subject){
		traineesWithSubject = new SeekUsersWithGivenSubject(subject, false).getMentorsWithSbject();
	}

	public ArrayList<User> getTraineesWithSubject() {
		return traineesWithSubject;
	}

	public void setTraineesWithSubject(String subject) {
		SeekUsersWithGivenSubject sug = new SeekUsersWithGivenSubject(subject, false);
		traineesWithSubject = sug.getMentorsWithSbject();
	}
	
}
