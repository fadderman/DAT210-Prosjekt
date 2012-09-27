package models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "username")
	private String username;
	
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
	
	//TODO should these be ordered or indexed?
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_SUBJECT_MENTOR", joinColumns = { @JoinColumn(name = "user_id")}, 
			inverseJoinColumns = { @JoinColumn(name = "subject_id")})
	@OrderBy("title")
	private ArrayList<Subject> mentorList;
	
	//TODO should these be ordered or indexed?
//	@ManyToMany
//	@OrderBy("title")
	private ArrayList<Subject> traineeList;
	
	//TODO Needs normalization
//	@OneToOne
//	private Connection connection;
	
	public User() {}
	
	//TODO Business methods pass empty variables if fields are to be left empty
	public User(String username, String firstName, String lastName, String email, String location) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		
		this.mentorList = new ArrayList<Subject>();
		this.traineeList = new ArrayList<Subject>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public ArrayList<Subject> getMentorList() {
		return mentorList;
	}

	public void setMentorList(ArrayList<Subject> mentorList) {
		this.mentorList = mentorList;
	}

	public ArrayList<Subject> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(ArrayList<Subject> traineeList) {
		this.traineeList = traineeList;
	}
	
	
}
