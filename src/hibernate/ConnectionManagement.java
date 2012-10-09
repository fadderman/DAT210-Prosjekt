package hibernate;

import java.util.List;

import models.*;

public class ConnectionManagement extends HibernateUtil{
	
	public ConnectionManagement() {
		sessionFactory = getSessionFactory();
	}
	
	public void createConnection(User mentor, User trainee, Subject subject){
		Connection connection = new Connection(mentor, trainee, subject);
		addConnection(connection);
	}
	
	public void createConnection(User mentor, User trainee, Subject subject, int difficultyLevel){
		Connection connection = new Connection(mentor, trainee, subject, difficultyLevel);
		addConnection(connection);
	}

	public void addConnection(Connection connection) {
		addToDatabase(connection);
	}
	
	public List<Connection> getByID(int id){
		String queryString = "from models.Connection where id = :id";
		String queryVariable = "id";
		return fetch(queryString, queryVariable, id);
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
	
	
}
