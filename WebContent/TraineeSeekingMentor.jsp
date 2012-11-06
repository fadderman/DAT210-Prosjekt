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
		String field = "Java 2d";
		MentorsWithSubject m = new MentorsWithSubject(field);
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
			<%
				for (User user : mentors) {
			%>

			<tr>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getEmail()%></td>
				<td>
					<form action="" name="select_user_as_mentor" method="post">
						<input type="hidden" name="userID" value=<%= user.getUserID() %>>
						<input type="hidden" name="field" value=<%= field %>>
						<input type="button" value="connect" class="btn btn-primary btn-small"
							onclick="connectTrainee();">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>

	</div>
</body>
<script type="text/javascript">
	function connectTrainee() {
		document.getElementById("select_user_as_mentor").submit();
		window.self.close();
	}
</script>
</html>