<%@page import="java.util.LinkedList"%>
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
		//har enda ikke forstått ossen jeg får data fra databasen så har jeg
		//lagt til en tom dataliste
		LinkedList<User> mentors = new LinkedList<User>();
	%>
	<h1 id="Title">List of Mentor</h1>
	<table id="ListofMentor" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Join</th>
		</tr>
		<%for(User users : mentors){
			//legger til en sjekk etter
			
				/*få data om hvilken bruker som har det faget det blir spurt etter
				må sikkert får inn noe info fra siden før, lager en ny user
				objekt ut fra dataen i mentorSubject men fåreløpig så tar jeg og bare
				lage en tom user*/
				User mentor = new User();
				
			%>
		<tr>
		<!-- legger til en masse EL table data -->
		</tr>
		<%  } %>
	</table>
</body>
</html>