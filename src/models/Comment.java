package models;

public class Comment {

	private Connection connection;
	private User author;
	private String comment;
	
	public Comment() {
		this.connection = null;
		this.author = null;
		this.comment = "";
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
