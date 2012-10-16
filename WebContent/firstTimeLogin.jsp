
<!DOCTYPE html>
<html>
<head>
<title>MentorFind Home</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<link rel="shortcut icon" href="img/favicon.ico"></link>
<body class="contentBox">
	<%@ page import="models.User"%>
	<%User user = (User)request.getAttribute("user"); %>

	<div class="container">
<<<<<<< HEAD
		<!-- top menu -->
		<br />
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
								<li><a type="button" onclick="Validate(en);"
									href="http://localhost:8080/webTest/Languages/loginEN.jsp">English</a></li>
								<li><a type="button" onclick="validate(no);"
									href="http://localhost:8080/webTest/Languages/loginNO.jsp">Norsk</a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="padding"></div>
=======
<!-- top menu -->
<%@ include file="loginMenuBar.jsp" %>
<%session.setAttribute("CurrentPage", "/firstTimeLogin.jsp");%>
>>>>>>> origin/david

		<!--left column -->
		<h4 style="text-shadow: #000000 3px 3px 8px; color: white;">Personal</h4>
		<form action="createNewUser" method="post">
			<div class="well span11" style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td><label class="pull-right">First name:</label></td>
							<td><input name="firstName" type="text"
								value="<%=user.getFirstName()%>"></td>
							<td><label class="pull-right">Last name:</label></td>
							<td><input name="lastName" type="text"
								value="<%=user.getLastName()%>"></td>
						</tr>
						<tr>
							<td><label class="pull-right">Email:</label></td>
							<td><input name="email" type="text"
								value="<%=user.getEmail()%>"></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="pull-right">Country:</label></td>
							<td><input name="country" type="text" value=""></td>
							<td><label class="pull-right">City:</label></td>
							<td><input name="city" type="text" value=""></td>
						</tr>
						<input type="hidden" name="identifier"
							value="<%=user.getIdentifierOpenID()%>">
					</tbody>
				</table>
			</div>	
			<br />
			<h4 style="text-shadow: #000000 3px 3px 8px; color: white;">Connections</h4>
			<div class="well span11" style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td><label class="pull-right">Subject:</label></td>
							<td><select name="category" id="category">
									<option value="java">Java</option>
									<option value="cSharp">C#</option>
									<option value="cplusplus">C++</option>
									<option value="obj-C">Objective C</option>

							</select></td>
							<td><label class="pull-right">Field:</label></td>
							<td><select name="field" id="field">
									<option value="gui">GUI</option>
									<option value="simulation">Simulation</option>
									<option value="threading">Threading</option>
									<option value="basics">Basics</option>
									<option value="other">Other</option>
							</select></td>
							<td><label class="radio inline"><input type="radio"
									name="optionsRadios" id="radioMentor" value="Mentor">Mentor</label></td>
							<td><label class="radio inline"><input type="radio" checked
									name="optionsRadios" id="radioTrainee" value="Trainee">Trainee</label></td>
						</tr>
						<tr>
							<td><label class="pull-right">Additional Info:</label></td>
							<td><textarea id="addInfo"></textarea></td>
							<td><label class="pull-right">Experience:</label></td>
							<td>
								<select name="experience">
									<option value="noob"> Newbie </option>
									<option value="novice"> Novice </option>
									<option value="intermediate"> Intermediate </option>
									<option value="skilled"> Skilled </option>
									<option value="expert"> Expert </option>
									<option value="loreMaster"> Lore Master </option>
								</select>
							</td>
							<td>
								<input type="button" class="btn btn-info" onclick="addCourse();" value="Add" />
							</td>
						</tr>
					</tbody>
				</table>
				<br />
				<table class="table table-hover" id="tblCourse">
					<thead>
						<th>Course</th>
						<th>Subject</th>
						<th>Mentor</th>
						<th>Trainee</th>
						<th></th>
					</thead>
					<tbody>
						
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
<script type="text/javascript">
	$('.dropdown-toggle').dropdown();
	function showValues() {
		var str = $("form").serialize();
		$("#results").text(str);
	}
	$("select").change(showValues);
	showValues();
	
	// Funksjon for å legge til
	function addCourse() {
		// ny tabellrad
		oTr = $('<tr>');

		// legger til en TD til TR med data fra kategoriselecten
		oTr.append(
			$('<td>').append($('<input>', { name: "category", type: 'hidden', value: $('#category :selected').val() }))
					.append($('<span>').append($('#category :selected').text())));

		// legger til en TD til TR med data fra fieldselecten
		oTr.append(
			$('<td>').append($('<input>', { name: "field", type: 'hidden', value: $('#field :selected').val() }))
					.append($('<span>').append($('#field :selected').text())));
		
		// Henter inn valgte option for trainee / mentor
	    var trMen = $("input[name=optionsRadios]:checked");
		
		// Legger til tekst og verdi i input fra radiobuttonen
		oTr.append(
			$('<td>').append($('<input>', { name: "mentor", type: 'hidden', value: (trMen.val() == 'Mentor'?'Yes':'No') }))
					.append($('<span>').append((trMen.val() == 'Mentor')?'Yes':'No')));
			
		oTr.append(
			$('<td>').append($('<input>', { name: "trainee", type: 'hidden', value: (trMen.val() == 'Trainee'?'Yes':'No') }))
					.append($('<span>').append((trMen.val() == 'Trainee')?'Yes':'No'))
					.append($('<input>', { name: "addInfo", type: 'hidden', value: $('#addInfo').val() })));

		// fjerner valgt info
		$('#addInfo').val("");
		trMen.attr('checked',false);

		// legger til removebutton med slettefunskjon
		oTr.append($('<td>').append($('<input>', {type: 'button', value: 'Remove'}).addClass("btn btn-danger btn-small").click(function() { $(this).parent().parent().remove() })));
		
		// legger til selve tabellen
		$('#tblCourse').append(oTr);
	}
</script>

</html>