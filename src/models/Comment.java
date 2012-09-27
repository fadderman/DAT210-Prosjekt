package models;


import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "COMMENT")
public class Comment {

	@Column
	private Connection connection;
	private User author;
	
	@Column(name = "comment")
	private String comment;
	
	
	//TODO sjer her? 
	@Column(name = "timestamp")
	private Date timestamp;
	
	public Comment(){
		
	}
	
	public Comment(Connection connection, User author, String comment) {
		this.connection = connection;
		this.author = author;
		this.comment = comment;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
