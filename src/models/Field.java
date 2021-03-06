package models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "FIELD")
public class Field {

	@Id @GeneratedValue
	@Column(name = "field_id")
	private int fieldID;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description", columnDefinition = "TEXT")
	@Type(type="text")
	private String description;

	@OneToMany(mappedBy = "field")
	@OrderBy("title")
	private List<Connection> connectionList;
	
	public Field(){
		
	}
	
	public Field(String title, String description) {
		this.title = title;
		this.description = description;
		active=true;
	}
	
	public int getFieldID() {
		return fieldID;
	}

	public void setfieldID(int fieldID) {
		this.fieldID = fieldID;
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

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}
}
