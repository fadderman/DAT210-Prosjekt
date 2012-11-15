package controllers;

import hibernate.RequestManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Request;

import business.connection.RequestHandler;


public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RequestManagement requestManager;
    public RequestServlet() {
        super();
    }
    public void init() throws ServletException {
    	super.init();
    	 requestManager = new RequestManagement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestID = request.getParameter("requestId");
		int reqID;
		try{
			reqID = Integer.parseInt(requestID);
		}catch(NumberFormatException e){
			return;
		}	
		Request requestToBeAnswered = requestManager.getRequestByID(reqID);
		String answer = request.getParameter("answer");
		if(answer.equals("yes")){
		RequestHandler.answerYes(requestToBeAnswered);
		}else{
			RequestHandler.answerNo(requestToBeAnswered);
		}
	}

}
