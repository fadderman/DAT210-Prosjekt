package controllers;

import hibernate.ConnectionManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Connection;

public class ViewConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionManagement connectionManagement;
	
	public ViewConnectionServlet() {
		connectionManagement = new ConnectionManagement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int connectionId;
		try {
			connectionId = Integer.parseInt(request.getParameter("id"));
		} catch(NumberFormatException e) {
			connectionId = -1; // will cause error message to user that invalid arg was given
		}

		Connection connection = connectionManagement.getByID(connectionId);
		if(connection == null){
			connection = new Connection();
		}
		request.setAttribute("connection", connection);
		request.setAttribute("active", "connections");
		request.setAttribute("include", "viewConnection.jsp?id=" + connectionId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
