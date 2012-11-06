package controllers;

import hibernate.FieldManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Field;

public class ViewFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FieldManagement fieldManagement;
	
	public ViewFieldServlet() {
		fieldManagement = new FieldManagement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fieldId;
		
		try {
			fieldId = Integer.parseInt(request.getParameter("id"));
		} catch(NumberFormatException e) {
			fieldId = -1; // will cause error message to user that invalid arg was given
		}
		
		Field field = fieldManagement.getByID(fieldId);
		
		request.setAttribute("field", field);
		request.setAttribute("active", "find");
		request.setAttribute("include", "field.jsp?id=" + fieldId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
