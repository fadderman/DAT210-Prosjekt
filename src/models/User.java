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
	
	//TODO setup indexing
	@ManyToMany(targetEntity = models.Subject.class,
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	@JoinTable(name = "USER_SUBJECT_MENTOR", joinColumns = { @JoinColumn(name = "user_id")}, 
			inverseJoinColumns = { @JoinColumn(name = "subject_id")})
	@OrderBy("lastName")
	private List<Subject> mentorList;
	
	//TODO setup indexing
	@ManyToMany(targetEntity = models.Subject.class,
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	@JoinTable(name = "USER_SUBJECT_TRAINEE", joinColumns = { @JoinColumn(name = "user_id")}, 
			inverseJoinColumns = { @JoinColumn(name = "subject_id")})
	@OrderBy("lastName")
	private List<Subject> traineeList;
	
	@OneToMany(mappedBy = "mentor")
	private List<Connection> connectionMentor;
	
	@OneToMany(mappedBy = "trainee")
	private List<Connection> connectionTrainee;
	
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
		
		mentorList = new ArrayList<Subject>();
		traineeList = new ArrayList<Subject>();
		commentList = new ArrayList<Comment>();
		
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public List<Subject> getMentorList() {
		return mentorList;
	}

	public void setMentorList(ArrayList<Subject> mentorList) {
		this.mentorList = mentorList;
	}

	public List<Subject> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(ArrayList<Subject> traineeList) {
		this.traineeList = traineeList;
	}

	public List<Connection> getConnectionMentor() {
		return connectionMentor;
	}

	public void setConnectionMentor(List<Connection> connectionMentor) {
		this.connectionMentor = connectionMentor;
	}

	public List<Connection> getConnectionTrainee() {
		return connectionTrainee;
	}

	public void setConnectionTrainee(List<Connection> connectionTrainee) {
		this.connectionTrainee = connectionTrainee;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
}
