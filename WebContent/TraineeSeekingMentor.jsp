<%@page import="models.Subject"%>
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
		ArrayList<Subject> mentorSubjects;
	%>
	<h1 id="ListofMentor">List of Mentor</h1>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Join</th>
		</tr>
	</table>
</body>
</html>