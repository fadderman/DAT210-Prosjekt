<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="business.search.SearchEngine, business.search.SearchResults, java.util.ArrayList, models.User"%>

<% 
	response.setContentType("application/json");
%>

<%
	SearchEngine engine = new SearchEngine();
	//engine.createDummyData();
	
	SearchResults result = engine.search(request.getParameter("term"));
%>

[
<% 
	out.print(result.getSearchResultsAsJSON());	
%>
]