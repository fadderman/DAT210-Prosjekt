package models;

import java.util.ArrayList;

public class Category {
	private String title;
	private String description;
	private ArrayList<Subject> subjectList;
	
	public Category() {
		this.title = "";
		this.description = "";
		this.subjectList = null;
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
