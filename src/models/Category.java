package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//TODO refactor to Field
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
	private List<Field> fieldList;
	
	public Category(){
		
	}
	
	public Category(String title, String description){
		this.title = title;
		this.description = description;
		active = true;
		fieldList = new ArrayList<Field>();		
	}
	
	public Category(String title, String description, Field field){
		this.title = title;
		this.description = description;
		fieldList = new ArrayList<Field>();
		fieldList.add(field);
	}
	
	public Category(String title, String description, ArrayList<Field> fieldList) {
		this.title = title;
		this.description = description;
		this.fieldList = fieldList;
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
	
	public void addField(Field field){
		fieldList.add(field);
	}

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(ArrayList<Field> fieldList) {
		this.fieldList = fieldList;
	}
	
}
