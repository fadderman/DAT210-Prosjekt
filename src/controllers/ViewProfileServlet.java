package controllers;

import hibernate.UserManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManagement userManagement;
	
	public ViewProfileServlet() {
		userManagement = new UserManagement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId;
		try {
			userId = Integer.parseInt(request.getParameter("id"));
		} catch(NumberFormatException e) {
			userId = -1; // will cause error message to user that invalid arg was given
		}

		User user = userManagement.getByID(userId);
		
		request.setAttribute("profile", user);
		request.setAttribute("active", "find");
		request.setAttribute("include", "viewprofile.jsp?id=" + userId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
