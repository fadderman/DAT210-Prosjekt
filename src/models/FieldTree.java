package models;

import javax.persistence.*;

@Entity
@Table(name = "FieldTree")
public class FieldTree {

	@ManyToOne
	@JoinColumn(name = "peon_fk")
	private Field peon;
	
	@ManyToOne
	@JoinColumn(name = "parent_fk")
	private Field parent;
	
	@Column(name = "active")
	private boolean active;
	
	public FieldTree(){

	}
	
	public FieldTree(Field parent, Field peon){
		this.parent = parent;
		this.setPeon(peon);
		active = true;
	}

	public Field getPeon() {
		return peon;
	}

	public void setPeon(Field peon) {
		this.peon = peon;
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
