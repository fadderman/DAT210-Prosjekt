package hibernate;

import java.util.List;

import models.*;

public class ConnectionManagement extends HibernateUtil{
	
	public ConnectionManagement() {
		sessionFactory = getSessionFactory();
	}
	
<<<<<<< HEAD
	public void createOpenMentor(User mentor, Field field){
		Connection connection = new Connection(field);
		connection.setMentor(mentor);
		addConnection(connection);
	}
	
	public void createOpenTrainee(User trainee, Field field){
		Connection connection = new Connection(field);
		connection.setTrainee(trainee);
		addConnection(connection);
	}
	
	public void createConnection(User mentor, User trainee, Field field){
		Connection connection = new Connection(mentor, trainee, field);
=======
	public void createConnection(User mentor, User trainee, Subject subject){
		Connection connection = new Connection(mentor, trainee, subject);
>>>>>>> origin/lordAlek
		addConnection(connection);
	}
	
	public void createConnection(User mentor, User trainee, Field field, int difficultyLevel){
		Connection connection = new Connection(mentor, trainee, field, difficultyLevel);
		addConnection(connection);
	}

	public void addConnection(Connection connection) {
		addToDatabase(connection);
<<<<<<< HEAD
	}
	
	public List<Connection> getAllConnections(){
		String queryString = ("from models.Connection where active = true"); 
		return fetch(queryString);
	}
	public List<Connection> getAllInactiveConnections(){
		String queryString = ("from models.Connection where active = false"); 
		return fetch(queryString);
	}
	
	public Connection getByID(int id){
		String queryString = "from models.Connection where connectionID = :id";
		String queryVariable = "connectionID";
		return (Connection) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<Connection> getByMentor(User user){
		String queryString = "from models.Connection where mentor = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Connection> getByTrainee(User user){
		String queryString = "from models.Connection where trainee = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
=======
	}
	
	public List<Connection> getByID(int id){
		String queryString = "from models.Connection where id = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, id);
	}
	
>>>>>>> origin/lordAlek
	public void updateDifficultyLevel(Connection connection, int difficultyLevel){
		String queryString = "update models.Connection set difficultyLevel = :difficultyLevel where id = :id";
		String queryVariable = "difficultyLevel";
		updateSingle(queryString, queryVariable, difficultyLevel, connection.getConnectionID());
	}
	
	public void setDifficultyLevel(Connection connection, int difficultyLevel){
		updateDifficultyLevel(connection, difficultyLevel);
	}
	
	public void changeStatus(Connection	connection, boolean active){
		String queryString = "update models.Connection set active = :active where id = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, active, connection.getConnectionID());
	}
	
<<<<<<< HEAD
	public List<Comment> fetchCommentList(Connection connection){
		String queryString = "from models.Comment where connection = :connection";
		String queryVariable = "connection";
		return fetch(queryString, queryVariable, connection);
	}
	
=======
>>>>>>> origin/lordAlek
	
}
