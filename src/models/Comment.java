package models;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id @GeneratedValue
	@Column(name = "comment_id")
	private int commentID;
	
	@ManyToOne
	@JoinColumn(name = "connection_fk")
	private Connection connection;
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User author;
	
	@Column(name = "comment")
	private String comment;
	
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
