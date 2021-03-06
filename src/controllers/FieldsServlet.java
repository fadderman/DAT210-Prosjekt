package controllers;

import hibernate.FieldManagement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Field;

@WebServlet("/FieldsServlet")
public class FieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FieldManagement fieldManagement;
	
	public FieldsServlet() {
		fieldManagement = new FieldManagement();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Field> allFields = (ArrayList<Field>) fieldManagement.getAllFields();
		
		
		request.setAttribute("active", "fields");
		request.setAttribute("include", "fields.jsp");
		request.setAttribute("allFields", allFields);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
