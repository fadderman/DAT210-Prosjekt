package models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "FieldTree")
public class FieldTree{

	@Id @GeneratedValue
	@Column(name = "field_tree_id")
	private int fieldTreeID;

	@ManyToOne
	@JoinColumn(name = "child_fk")
	private Field child;
	
	@ManyToOne
	@JoinColumn(name = "parent_fk")
	private Field parent;
	
	@Column(name = "active")
	private boolean active;
	
	public FieldTree(){

	}
	
	public FieldTree(Field child, Field parent){
		this.parent = parent;
		this.setChild(child);
		active = true;
	}

	public int getFieldTreeID() {
		return fieldTreeID;
	}

	public void setFieldTreeID(int fieldTreeID) {
		this.fieldTreeID = fieldTreeID;
	}

	public Field getChild() {
		return child;
	}

	public void setChild(Field child) {
		this.child = child;
	}

	public Field getParent() {
		return parent;
	}

	public void setParent(Field parent) {
		this.parent = parent;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
