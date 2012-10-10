<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="business.search.SearchResults, models.User, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Results</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<%
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
%>
<body>
<p />
<div class="container well">
	<div class="row-fluid">
		<div class="span12">
			<legend>Search Results</legend>
		</div>
	</div>
	<% for(int i=0;i<users.size();i++) { %>
	<div class="row-fluid">
		<div class="span12">
			<div class="container well span12">
				<div class="row-fluid">
					<div class="span2"><%= users.get(i).getFirstName() %> <%= users.get(i).getLastName() %></div>
					<div class="span10"></div>
				</div>
			</div>		
		</div>
	</div>
	<% } %>
</div>

</body>
</html>