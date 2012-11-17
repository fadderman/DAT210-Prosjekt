package controllers;

import hibernate.ConnectionManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Connection;

public class RemoveConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConnectionManagement connectionManager;
	
	public RemoveConnectionServlet() {
		connectionManager = new ConnectionManagement();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionId = request.getParameter("connectionId");
		
		Connection connection = connectionManager.getByID(Integer.parseInt(connectionId));
		connectionManager.removeConnection(connection);
		
		request.setAttribute("include", "connections.jsp");
		request.setAttribute("active", "connections");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
