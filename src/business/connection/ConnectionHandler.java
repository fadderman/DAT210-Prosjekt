package business.connection;

import hibernate.ConnectionManagement;

import java.util.ArrayList;

import models.Connection;

public class ConnectionHandler {
	private static ArrayList<Connection> connectionList= new ArrayList<Connection>();
	private static ConnectionManagement connectionMananger;
	
	public ConnectionHandler(){
	}

	public void addUser(Connection connection) {
		synchronized (connectionList) {
			connectionList.add(connection);
		}
	}

}
