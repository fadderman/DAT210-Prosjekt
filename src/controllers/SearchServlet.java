package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Field;
import models.User;
import business.search.SearchEngine;
import business.search.SearchResults;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SearchResults searchResults;
	private SearchEngine engine;
	
	public SearchServlet() {
		engine = new SearchEngine();
//		engine.createDummyData();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
	
		if(query != null) {
			if(!query.trim().equals("")) {
				searchResults = querySearchEngine(query);
			} else {
				searchResults = new SearchResults();
			}
		} else {
			searchResults = new SearchResults();
		}

		ArrayList<User> users = searchResults.getUserResults();
		if(users != null) {
			request.setAttribute("users", users);
		}
		
		ArrayList<Field> fields = searchResults.getFieldResults();
		if(fields != null) {
			request.setAttribute("fields", fields);
		}
		
		request.setAttribute("active", "find");
		request.setAttribute("include", "searchresults.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private SearchResults querySearchEngine(String query) {
		return engine.search(query);
	}

}
