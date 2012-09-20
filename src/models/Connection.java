package models;

import java.util.ArrayList;

public class Connection {
	private User mentor;
	private User trainee;
	private Subject subject;
	private int difficultyLevel;
	private ArrayList<Comment> comments;
	
	public Connection() {
		this.mentor = null;
		this.trainee = null;
		this.subject = null;
		this.difficultyLevel = 0;
		this.comments = null;
	}
	
	public User getMentor() {
		return mentor;
	}

	public void setMentor(User mentor) {
		this.mentor = mentor;
	}

	public User getTrainee() {
		return trainee;
	}

	public void setTrainee(User trainee) {
		this.trainee = trainee;
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
