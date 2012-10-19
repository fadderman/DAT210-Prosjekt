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
<form action=""></form>
	<%
		//lagt til en tom dataliste
		//MentorsWithSubject m = new MentorsWithSubject("Java 2D");
		ArrayList<User> mentors = new ArrayList<User>();

		User user1 = new User();
		User user5 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		mentors.add(user1);
		mentors.add(user2);
		mentors.add(user3);
		mentors.add(user4);
		
	%>
	<h1 id="Title">List of Mentor</h1>
	<table id="ListofMentor" border="1" class="row-fluid">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Join</th>
		</tr>
		<%
			for (User user : mentors) {
		%>
		<tr valign="top">
			<td>
				<%=
					user.getFirstName()
				%>
			</td>
			<td>
				<%=
					user.getLastName()
				%>
			</td>
			<td>
				<%=
					user.getEmail()
				%>
			</td>
			<td><form action=""></form></td>
			<!-- legger til en masse EL table data -->
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>