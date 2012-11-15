package hibernate;

import java.util.List;

import models.*;

public class ConnectionManagement extends HibernateUtil{
	
	public ConnectionManagement() {
		sessionFactory = getSessionFactory();
	}
	
	public boolean createOpenMentor(User mentor, Field field){
		Connection connection = new Connection(field);
		connection.setMentor(mentor);
		return addConnection(connection);
	}
	
	public boolean createOpenMentor(User mentor, Field field, int difficultyLevel){
		Connection connection = new Connection(field);
		connection.setMentor(mentor);
		connection.setDifficultyLevel(difficultyLevel);
		return addConnection(connection);
	}
	
	public boolean createOpenTrainee(User trainee, Field field, int difficultyLevel){
		Connection connection = new Connection(field);
		connection.setTrainee(trainee);
		connection.setDifficultyLevel(difficultyLevel);
		return addConnection(connection);
	}
	
	public boolean createOpenTrainee(User trainee, Field field){
		Connection connection = new Connection(field);
		connection.setTrainee(trainee);
		return addConnection(connection);
	}
	
	public boolean createConnection(User mentor, User trainee, Field field){
		Connection connection = new Connection(mentor, trainee, field);
		return addConnection(connection);
	}
	
	public boolean createConnection(User mentor, User trainee, Field field, int difficultyLevel){
		Connection connection = new Connection(mentor, trainee, field, difficultyLevel);
		return addConnection(connection);
	}

	public boolean addConnection(Connection connection) {
		return addToDatabase(connection);
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
		String queryString = "from models.Connection where connectionID = :connectionID";
		String queryVariable = "connectionID";
		return (Connection) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<Connection> getByMentor(User user){
		String queryString = "from models.Connection where mentor = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Connection> getByField(Field field){
		String queryString = "from models.Connection where field = :fieldID";
		String queryVariable = "fieldID";
		return fetch(queryString, queryVariable, new Integer(field.getFieldID()));
	}
	
	public List<Connection> getByTrainee(User user){
		String queryString = "from models.Connection where trainee = :userID";
		String queryVariable = "userID";
		return fetch(queryString, queryVariable, new Integer(user.getUserID()));
	}
	
	public List<Connection> getOpenTraineeConnections(Field field){
		String queryString = "from models.Connection where field = :fieldID and mentor = null";
		String queryVariable = "fieldID";
		return fetch(queryString, queryVariable, new Integer(field.getFieldID()));
	}
	
	public List<Connection> getOpenMentorConnections(Field field){
		String queryString = "from models.Connection where field = :fieldID and trainee = null";
		String queryVariable = "fieldID";
		return fetch(queryString, queryVariable, new Integer(field.getFieldID()));
	}
	
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
	
	public List<Comment> fetchCommentList(Connection connection){
		String queryString = "from models.Comment where connection = :connectionID";
		String queryVariable = "connectionID";
		return fetch(queryString, queryVariable, connection);
	}
	
	public void addMentorToConnection(Connection connection, User mentorToAdd){
		String queryString = "update models.Connection set mentor =:mentorToAdd where id =:id";
		String queryVariable = "mentorToAdd";
		updateSingle(queryString, queryVariable, mentorToAdd, connection.getConnectionID());
	}
	
	public void addTraineeToConnection(Connection connection, User traineeToAdd){
		String queryString = "update models.Connection set trainee =:traineeToAdd where id =:id";
		String queryVariable = "traineeToAdd";
		updateSingle(queryString, queryVariable, traineeToAdd, connection.getConnectionID());
	}
	public void removeConnection(Connection connection) {
		delete(connection);
	}
}
