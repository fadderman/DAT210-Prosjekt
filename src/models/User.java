package models;

import java.util.ArrayList;

public class User {

	private String firstName;
	private String lastName;
	private String identifier;
	private String email;
	private String location;
	
	private ArrayList<Subject> mentorList;
	private ArrayList<Subject> traineeList;
	
	public User() {
		this.firstName = "";
		this.lastName = "";
		this.identifier = "";
		this.email = "";
		this.location = "";
		
		this.mentorList = new ArrayList<Subject>();
		this.traineeList = new ArrayList<Subject>();
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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
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
