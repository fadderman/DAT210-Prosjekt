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

	@Column(name ="description")
	private String description;

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
	@JoinColumn(name = "field_fk")
	private Field field;

	@OneToMany(mappedBy = "connection")
	@OrderBy("timestamp")
	private List<Comment> comments;

	public Connection(){		
	}

	public Connection(Field field){
		this.field = field;
		active = true;
	}

	public Connection(User mentor, User trainee, Field field) {
		this.mentor = mentor;
		this.trainee = trainee;
		this.field = field;
		active = true;
		comments = new ArrayList<Comment>();
	}

	public Connection(User mentor, User trainee, Field field, String description, int difficultyLevel) {
		this.mentor = mentor;
		this.trainee = trainee;
		this.field = field;
		this.description = description;
		this.difficultyLevel = difficultyLevel;
		active = true;
	}

	public Connection(User mentor, User trainee, Field field, int difficultyLevel) {
		this(mentor, trainee, field);
		this.difficultyLevel = difficultyLevel;
		this.connectionID = connectionID;
		active = true;
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
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