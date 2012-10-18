package business.connection;

import hibernate.ConnectionManagement;

import java.util.ArrayList;

import models.Connection;

public class ConnectionHandler {
	private static ArrayList<Connection> connectionList= new ArrayList<Connection>();
	private static ConnectionManagement connectionMananger = new ConnectionManagement();
	
	public ConnectionHandler(){
	}

	public void addConnection(Connection connection) {
		synchronized (connectionList) {
			connectionList.add(connection);
			/* Kommentar fjernes når Hibernate kjører.
			connectionMananger.addConnection(connection);			
			*/
		}
	}
}
