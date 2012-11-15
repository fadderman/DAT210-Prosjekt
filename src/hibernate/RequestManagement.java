package hibernate;

import java.util.List;

import models.Connection;
import models.Request;
import models.User;

public class RequestManagement extends HibernateUtil {

	public RequestManagement(){
		sessionFactory = getSessionFactory();
	}
	
	public boolean createRequest(User requestTarget, Connection connection, boolean isTraineeRequest){
		Request request = new Request(requestTarget, connection, isTraineeRequest);
		return addRequest(request);
		
	}

	private boolean addRequest(Request request) {
		return addToDatabase(request);
	}
	
	public Request getRequestByID(int requestID){
		String queryString ="from models.Request where requestID = :requestID";
		String queryVariable = "requestID";
		return (Request) fetchSingle(queryString, queryVariable, new Integer(requestID));
	}
	
	public List<Request> getRequestByUserID(int userID){
		String queryString = ("from models.Request request where request.requestTarget.userID = :userID");
		String quaryVariable = "userID";
		return fetch(queryString, quaryVariable, new Integer(userID));
	}
	
	public void removeRequest(Request request){
		delete(request);
	}
	
	public List<Request> getAllRequests(){
		String queryString = ("from models.Request"); 
		return fetch(queryString);
	}
}
