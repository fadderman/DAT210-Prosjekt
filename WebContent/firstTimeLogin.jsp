
<!DOCTYPE html>
<html>
<head>
<title>MentorFind Home</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<link rel="shortcut icon" href="img/favicon.ico"></link>
<body class="contentBox">
<%@ page import="models.User" %>
<%User user = (User)request.getAttribute("user"); %>

	<div class="container">
<!-- top menu -->
<br/>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#"><img alt="" src="img/logo_mini.png"></a>
					<div class="btn-group pull-right">
						<input type="button"
							class="btn dropdown-toggle btn-inverse btn-large"
							data-toggle="dropdown" value="language">
						<ul class="dropdown-menu">
							<!-- dropdown menu links -->
							<li><a type="button" onclick="Validate(en);" href="http://localhost:8080/webTest/Languages/loginEN.jsp">English</a></li>
							<li><a type="button" onclick="validate(no);" href="http://localhost:8080/webTest/Languages/loginNO.jsp">Norsk</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="padding"></div>

		<!--left column -->
		<h4 style="text-shadow: #000000 3px 3px 8px; color: white;">Personal</h4>
		<form action="createNewUser" method="post">
			<div class="well span11"
				style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td>
								<label class="pull-right">First name:</label>
							</td>
							<td><input name="firstName" type="text" value="<%=user.getFirstName()%>"></td>
							<td>
								<label class="pull-right">Last name:</label>
							</td>
							<td><input name="lastName" type="text" value="<%=user.getLastName()%>">
							</td>
						</tr>
						<tr>
							<td>
								<label class="pull-right">Email:</label>
							</td>
							<td><input name="email" type="text" value="<%=user.getEmail()%>">
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>
								<label class="pull-right">Country:</label>
							</td>

							<td><input name="country" type="text" value=""></td>
							<td>
								<label class="pull-right">City:</label>
							</td>
							<td><input name="city" type="text" value=""></td>
						</tr>
						<input type="hidden" name="identifier" value="<%=user.getIdentifierOpenID()%>">
					</tbody>
				</table>
			</div>
			<br />
			<h4 style="text-shadow: #000000 3px 3px 8px; color: white;">Connections</h4>
			<div class="well span11" style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td>
								<label class="pull-right">Course:</label>
							</td>
							<td><input type="text" value="Java"></td>
							<td>
								<label class="pull-right">Subject:</label>
							</td>
							<td><input id="subject" type="text" value="GUI">
							</td>
							<td> <label class="radio inline"><input type="radio" name="optionsRadios" id="radioMentor" value="option1">Mentor</label></td>
							<td> <label class="radio inline"><input type="radio" name="optionsRadios" id="radioTrainee" value="option2">Trainee</label></td>
							<td>
								<button class="btn btn-info">Add</button>
							</td>
						</tr>
					</tbody>
				</table><br/>
				<table class="table table-hover">
					<thead>
						<th>Course</th>
						<th>Subject</th>
						<th>Mentor</th>
						<th>Trainee</th>
						<th></th>
					</thead>
					<tbody>
						<tr>
							<td>C#</td>
							<td>All</td>
							<td>Yes</td>
							<td>No</td>
							<td><button class="btn btn-danger btn-small">Remove</button></td>
						</tr>
						<tr>
							<td>Javascript</td>
							<td>Animations</td>
							<td>No</td>
							<td>Yes</td>
							<td><button class="btn btn-danger btn-small">Remove</button></td>
						</tr>
						<tr>
							<td>Java</td>
							<td>Basic</td>
							<td>Yes</td>
							<td>Yes</td>
							<td><button class="btn btn-danger btn-small">Remove</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input type="submit" class="btn btn-warning btn-large" />


		</form>

		<!--right column -->

		<div class="form-inline">
			<a href="http://glyphicons.com" style="color: gray;"><small>Icons
					by Glyphicons</small></a>
		</div>
	</div>



	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
<script>
	$('.dropdown-toggle').dropdown()
</script>

</html>