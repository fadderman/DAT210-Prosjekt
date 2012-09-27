package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECT")
public class Subject {

	@Id @GeneratedValue
	@Column(name = "subject_id")
	private int subjectID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_fk")
	private Category category;
	
	@ManyToMany(
			targetEntity = models.User.class,
			cascade = {CascadeType.ALL},
			mappedBy = "mentorList")
	private List<User> mentorUserList;
	
	@ManyToMany(
			targetEntity = models.User.class,
			cascade = {CascadeType.ALL},
			mappedBy = "traineeList")
	private List<User> traineeUserList;
	
	//TODO Ordered or indexed?
	@OneToMany(mappedBy = "subject")
	@OrderBy("title")
	private List<Connection> connectionList;
	
	public Subject(){
		
	}
	
	public Subject(String title, String description, Category category) {
		this.title = title;
		this.description = description;
		this.category = category;
	}
	
	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<User> getMentorUserList() {
		return  mentorUserList;
	}

	public void setMentorUserList(ArrayList<User> mentorUserList) {
		this.mentorUserList = mentorUserList;
	}

	public List<User> getTraineeUserList() {
		return traineeUserList;
	}

	public void setTraineeUserList(ArrayList<User> traineeUserList) {
		this.traineeUserList = traineeUserList;
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}
	
	
}
