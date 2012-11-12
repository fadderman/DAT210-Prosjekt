<%@page import="models.TraineeWithField"%>
<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mentor seeking trainee</title>
</head>
<body class="container">
	<%
		String field = "Java 2d";
			pageContext.setAttribute("field", field);
			TraineeWithField t = new TraineeWithField(field);
			ArrayList<User> trainees = t.getTrainee();
	
	%>
	<h1 id="Title" style="text-align: center;" class="page-header">List
		of trainees</h1>
	<div class="well">
		<table id="listoftrainees" class="table table-hover table-condensed">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Join</th>
			</tr>
			<%
				for (User user : trainees) {
			%>
			<tr>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getEmail()%></td>
				<td>
					<form action="RegisterConnection" name="select_user" method="post">
						<input type="hidden" name="userID" value=<%=user.getUserID()%>>
						<input type="hidden" name="field" value="${field}"> <input
							type="submit" value="connect" class="btn btn-primary btn-small"
							onclick="self.close();">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>