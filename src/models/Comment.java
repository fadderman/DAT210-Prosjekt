package models;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id @GeneratedValue
	@Column(name = "comment_id")
	private int commentID;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "connection_fk")
	private Connection connection;
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User author;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "timestamp")
	private Date timestamp;
	
	
	public Comment(){
	}
	
	public Comment(Connection connection, User author, String text) {
		this.connection = connection;
		this.author = author;
		this.text = text;
		active = true;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return text;
	}

	public void setComment(String comment) {
		this.text = comment;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
