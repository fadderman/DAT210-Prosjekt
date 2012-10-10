package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "CONNECTION")
public class Connection {
	
	@Id @GeneratedValue
	@Column(name = "connection_id")
	private int connectionID;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "difficulty_level")
	private int difficultyLevel;
	
	@ManyToOne
	@JoinColumn(name = "mentor_connection_fk")
	private User mentor;

	@ManyToOne
	@JoinColumn(name = "trainee_connection_fk")
	private User trainee;
	
	@ManyToOne
	@JoinColumn(name = "subject_fk")
	private Subject subject;
	
	@OneToMany(mappedBy = "connection")
	@OrderBy("timestamp")
	private List<Comment> comments;
	
	public Connection(){
		
	}
	
	public Connection(Subject subject){
		this.subject = subject;
		active = true;
	}
	
	public Connection(User mentor, User trainee, Subject subject) {
		this.mentor = mentor;
		this.trainee = trainee;
		this.subject = subject;
		active = true;
		comments = new ArrayList<Comment>();
	}
	
	public Connection(User mentor, User trainee, Subject subject, int difficultyLevel) {
		this(mentor, trainee, subject);
		this.difficultyLevel = difficultyLevel;
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

	public List<Comment> getComments() {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
