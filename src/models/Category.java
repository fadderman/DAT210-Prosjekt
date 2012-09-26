package models;

import java.util.ArrayList;

import javax.persistence.*;


@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	
	//TODO ManyToMany or ManyToOne?
	@ManyToOne
	@OrderBy("title")
	private ArrayList<Subject> subjectList;
	
	
	public Category(){
		
	}
	
	public Category(String title, String description, ArrayList<Subject> subjectList) {
		this.title = title;
		this.description = description;
		this.subjectList = subjectList;
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

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
