package models;

import java.util.ArrayList;

import javax.persistence.*;


@Entity
@Table(name = "CONNECTION")
public class Connection {

	@Column(name = "mentor")
	private User mentor;
	
	@Column(name = "trainee")
	private User trainee;
	
	@Column(name = "subject")
	private Subject subject;
	
	@Id @GeneratedValue
	@Column(name = "connection_ID")
	private int connectionID;
	


	@Column(name = "difficultyLevel")
	private int difficultyLevel;
	
	//TODO relasjon?
	private ArrayList<Comment> comments;
	
	public Connection(){
		
	}
	
	public Connection(User mentor, User trainee, Subject subject, int difficultyLevel, ArrayList<Comment> comments, int connectionID) {
		this.mentor = mentor;
		this.trainee = trainee;
		this.subject = subject;
		this.difficultyLevel = difficultyLevel;
		this.comments = comments;
		this.connectionID = connectionID;
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

	public int getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}

}
