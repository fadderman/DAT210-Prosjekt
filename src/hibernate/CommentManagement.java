package hibernate;

import java.util.*;

import models.*;

public class CommentManagement extends HibernateUtil{
	
	public CommentManagement() {
		sessionFactory = getSessionFactory();
	}

	public void createComment(Connection connection, User author, String text){
		Comment comment = new Comment(connection, author, text);
		addComment(comment);
	}
	
	public void addComment(Comment comment){
		addToDatabase(comment);
	}
	
	public List<Comment> getAllComments(){
		String queryString = ("from models.Comment where active = true"); 
		List<Comment> results = fetch(queryString);
		return results;
	}

	public List<Comment> getAllInactiveComments(){
		String queryString = ("from models.Comment where active = false"); 
		return fetch(queryString);
	}
	
	public Comment getByID(int id){
		String queryString = "from models.Comment where commentID = :id";
		String queryVariable = "id";
		return (Comment) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<Comment> getByConnection(Connection connection){
		String queryString = "from models.Comment where connection = :connection";
		String queryVariable = "connection";
		return fetch(queryString, queryVariable, connection);
	}
	
	public List<Comment> getCommentByAuthor(User author){
		String queryString = "from models.Comment where author = :author";
		String queryVariable = "author";
		return fetch(queryString, queryVariable, author);
	}
	
	public List<Comment> getCommentByTimestamp(User author, Date fromTime, Date toTime){
		List<Comment> results =	getCommentByAuthor(author);
		
		Calendar wrappedDate = Calendar.getInstance();
		Calendar wrappedFrom = Calendar.getInstance();
		Calendar wrappedTo = Calendar.getInstance();
		wrappedFrom.setTime(fromTime);
		wrappedTo.setTime(toTime);
		
		for(Iterator<Comment> iterator = results.iterator(); iterator.hasNext();){
			Comment current = iterator.next();
			wrappedDate.setTime(current.getTimestamp());
			if(wrappedDate.get(Calendar.HOUR_OF_DAY) < wrappedFrom.get(Calendar.HOUR_OF_DAY) &&
					wrappedDate.get(Calendar.HOUR_OF_DAY) > wrappedTo.get(Calendar.HOUR_OF_DAY));
				iterator.remove();
		}
		return results;
	}
	
	public void updateCommentText(Comment comment, String newText){
		String queryString = "update models.Comment set text = :newText where id = :id";
		String queryVariable = "newText";
		updateSingle(queryString, queryVariable, newText, comment.getCommentID());
	}
	
	public void changeStatus(Comment comment, boolean status){
		String queryString = "update models.Comment set active = :active where id = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, status, comment.getCommentID());
	}
}
