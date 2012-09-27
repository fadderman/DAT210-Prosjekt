package models;

import java.util.ArrayList;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "category")
	private Category category;
	
	
	
//TODO ManyToMany relation with User?
	
	
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
	
	
}
