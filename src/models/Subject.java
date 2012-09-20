package models;

public class Subject {

	private String title;
	private String description;
	private Category category;
	
	public Subject() {
		this.title = "";
		this.description = "";
		this.category = null;
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
