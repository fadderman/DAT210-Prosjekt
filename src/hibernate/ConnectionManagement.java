package hibernate;

import models.*;

public class ConnectionManagement extends HibernateUtil{
	
	public ConnectionManagement() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void createConnection(User mentor, User trainee, Subject subject){
		Connection connection = new Connection(mentor, trainee, subject);
		addConnection(connection);
	}
	
	public void createConnection(User mentor, User trainee, Subject subject, int difficultyLevel){
		Connection connection = new Connection(mentor, trainee, subject, difficultyLevel);
		addConnection(connection);
	}

	private void addConnection(Connection connection) {
		addToDatabase(connection);
	}
	
	private void getByMentor(){
		//TODO
	}
	
	private void getByTrainee(){
		//TODO
	}
	
	private void getByID(){
		//TODO
	}
	
	private void setDifficultyLevel(){
		//TODO
	}
	
	private void updateDifficultyLevel(){
		//TODO
	}
	
	
}
