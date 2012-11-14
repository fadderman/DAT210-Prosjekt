package business.connection;

import hibernate.ConnectionManagement;
import hibernate.RequestManagement;
import models.Connection;
import models.Request;

public class RequestHandler {
	
	private static ConnectionManagement connectionManager = new ConnectionManagement();
	private static RequestManagement requestManager = new RequestManagement();
	
	public static void answerYes(Request request){
		Connection connection = request.getConnection();
		if(!request.isTraineeRequest()){
			connectionManager.addMentorToConnection(connection, request.getRequestTarget());
//			connection.setMentor(request.getRequestTarget());
		}else{
			connectionManager.addTraineeToConnection(connection, request.getRequestTarget());
//			connection.setTrainee(request.getRequestTarget());
		}
		removeRequest(request);
	}
	
	public static void answerNo(Request request){
		removeRequest(request);
	}
		
	private static void removeRequest(Request request){
		requestManager.removeRequest(request);
	}
}
