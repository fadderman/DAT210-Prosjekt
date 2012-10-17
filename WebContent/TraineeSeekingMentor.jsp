<%@page import="org.apache.catalina.Session"%>
<%@page import="models.MentorsWithSubject"%>
<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<head>
<meta charset="utf-8">
<title>Trainee Seeking Mentor</title>
</head>
<body>
	<%
		//har enda ikke forstått ossen jeg får data fra databasen så har jeg
		//lagt til en tom dataliste
		MentorsWithSubject m = new MentorsWithSubject();
		ArrayList<User> mentors = m.getMentorsWithSubject();
	%>
	<h1 id="Title">List of Mentor</h1>
	<table id="ListofMentor" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Join</th>
		</tr>
		<%for(User user : mentors){						
			%>
		<tr valign="top">
		<td><%user.getFirstName(); %></td>
		<td><%user.getLastName(); %></td>
		<td><%user.getEmail(); %></td>
		<td>empty</td>
		<!-- legger til en masse EL table data -->
		</tr>
		<% } %>
	</table>
</body>
</html>