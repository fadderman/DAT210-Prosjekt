package models;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id @GeneratedValue
	@Column(name = "category_id")
	private int categoryID;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(
			mappedBy = "category", 
			fetch=FetchType.EAGER)
	@OrderBy("title")
	private List<Subject> subjectList;
	
	public Category(){
		
	}
	
	public Category(String title, String description){
		this.title = title;
		this.description = description;
		active = true;
		subjectList = new ArrayList<Subject>();		
	}
	
	public Category(String title, String description, Subject subject){
		this.title = title;
		this.description = description;
		subjectList = new ArrayList<Subject>();
		subjectList.add(subject);
	}
	
	public Category(String title, String description, ArrayList<Subject> subjectList) {
		this.title = title;
		this.description = description;
		this.subjectList = subjectList;
	}
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	
	public void addSubject(Subject subject){
		subjectList.add(subject);
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
