package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "active")
	private boolean active;
		
	@Column(name = "identifier_openID")
	private String identifierOpenID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_Name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "location")
	private String location;

	@OneToMany(mappedBy = "mentor")
	private List<Connection> mentorConnection;
	
	@OneToMany(mappedBy = "trainee")
	private List<Connection> traineeConnection;
	
	@OneToMany(mappedBy = "author")
	private List<Comment>  commentList;
	
	public User() {}
	
	//TODO Business methods pass empty variables if fields are to be left empty
	public User(String firstName, String lastName, String email, String location, String identifierOpenID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.identifierOpenID = identifierOpenID;
		active = true;

		commentList = new ArrayList<Comment>();
		
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getIdentifierOpenID() {
		return identifierOpenID;
	}

	public void setIdentifierOpenID(String identifierOpenID) {
		this.identifierOpenID = identifierOpenID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Connection> getConnectionMentor() {
		return mentorConnection;
	}

	public void setConnectionMentor(List<Connection> connectionMentor) {
		this.mentorConnection = connectionMentor;
	}

	public List<Connection> getConnectionTrainee() {
		return traineeConnection;
	}

	public void setConnectionTrainee(List<Connection> connectionTrainee) {
		this.traineeConnection = connectionTrainee;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}
	
	/*//TODO broken may to many relationship
	//TODO setup indexing
	@ManyToMany(targetEntity = models.Field.class,
			cascade = CascadeType.ALL)
	@JoinTable(name = "USER_FIELD_MENTOR", joinColumns = { @JoinColumn(name = "user_id")}, 
			inverseJoinColumns = { @JoinColumn(name = "field_id")})
	@OrderBy("lastName")
	private List<Field> mentorList;
	
	//TODO setup indexing
	@ManyToMany(targetEntity = models.Field.class,
			cascade = CascadeType.ALL)
	@JoinTable(name = "USER_FIELD_TRAINEE", joinColumns = { @JoinColumn(name = "user_id")}, 
			inverseJoinColumns = { @JoinColumn(name = "field_id")})
	@OrderBy("lastName")
	private List<Field> traineeList;
	*/
	/*
	public void addMentorField(Field field){
		mentorList.add(field);
	}

	public List<Field> getMentorList() {
		return mentorList;
	}

	public void setMentorList(ArrayList<Field> mentorList) {
		this.mentorList = mentorList;
	}
	
	public void addTraineeField(Field field){
		traineeList.add(field);
	}

	public List<Field> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(ArrayList<Field> traineeList) {
		this.traineeList = traineeList;
	}
	*/
	
}

