<%@page import="models.MentorsWithSubject"%>
<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<head>
<meta charset="utf-8">
<title>Trainee Seeking Mentor</title>
</head>
<body class="container">
	<%
		//lagt til en tom dataliste
		MentorsWithSubject m = new MentorsWithSubject("Java 2D");
		ArrayList<User> mentors = m.getMentorsWithSubject();

	%>
	<h1 id="Title" style="text-align: center;" class="page-header">List
		of Mentor</h1>
	<div class="well">
		<table id="ListofMentor" class="table table-hover table-condensed">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Join</th>
			</tr>
			<form action="" name="send_user" method="post">
				<%
					for (User user : mentors) {
				%>

				<tr>
					<td><%=user.getFirstName()%></td>
					<td><%=user.getLastName()%></td>
					<td><%=user.getEmail()%></td>
					<td><input type="button" value="connect" class="btn"
						onclick="self.close();"></td>
					<!-- legger til en masse EL table data -->
				</tr>
				<%
					}
				%>
			</form>
		</table>
	</div>
</body>
</html>