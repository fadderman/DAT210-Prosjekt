package models;

import java.util.ArrayList;

public class Connection {
	private ArrayList<User> mentorList;
	private ArrayList<User> traineeList;
	private Subject subject;
	private int difficultyLevel;
	private ArrayList<Comment> comments;
	
	public Connection() {
		this.mentorList = null;
		this.traineeList = null;
		this.subject = null;
		this.difficultyLevel = 0;
		this.comments = null;
	}

	public ArrayList<User> getMentorList() {
		return mentorList;
	}

	public void setMentorList(ArrayList<User> mentorList) {
		this.mentorList = mentorList;
	}

	public ArrayList<User> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(ArrayList<User> traineeList) {
		this.traineeList = traineeList;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
