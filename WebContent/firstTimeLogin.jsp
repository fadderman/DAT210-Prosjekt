<!DOCTYPE html>
<html>
<head>
<title>MentorFind Home</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<link rel="shortcut icon" href="img/favicon.ico"></link>
<body class="contentBox">
	<%@ page import="models.User"%>
	<%User user = (User)request.getAttribute("user"); 
	if(user != null)
		session.setAttribute("user", user);
	else
		user = (User)session.getAttribute("user");
	%>

	<div class="container">
<!-- top menu -->
<%@ include file="loginMenuBar.jsp" %>
<%session.setAttribute("CurrentPage", "/firstTimeLogin.jsp");%>

		<!--left column -->
		<h4 style="text-shadow: #000000 3px 3px 8px; color: white;"><%=language.getFirsttime_label_personal() %></h4>
		<form action="createNewUser" method="POST" id="register">
			<div class="well span11" style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td><label class="pull-right"><%=language.getFirsttime_label_fName() %></label></td>
							<td><input name="firstName" type="text"
								value="<%=user.getFirstName()%>"></td>
							<td><label class="pull-right"><%=language.getFirsttime_label_lName() %></label></td>
							<td><input name="lastName" type="text"
								value="<%=user.getLastName()%>"></td>
						</tr>
						<tr>
							<td><label class="pull-right"><%=language.getFirsttime_label_email() %></label></td>
							<td><input name="email" type="text"
								value="<%=user.getEmail()%>"></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><label class="pull-right"><%=language.getFirsttime_label_country() %></label></td>

							<td><input name="country" type="text" value=""></td>
							<td><label class="pull-right"><%=language.getFirsttime_label_city() %></label></td>
							<td><input name="city" type="text" value=""></td>
						</tr>
						<input type="hidden" name="identifier"
							value="<%=user.getIdentifierOpenID()%>">
					</tbody>
				</table>
			</div>
			<br />
			<h4 style="text-shadow: #000000 3px 3px 8px; color: white;"><%=language.getFirsttime_label_connections() %></h4>
			<div class="well span11" style="box-shadow: 5px 5px 8px -1px #222;">
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td><label class="pull-right"><%=language.getFirsttime_label_field()%></label></td>
							<td><input name="field" type="text" id="field">
							<td><label class="radio inline"><input type="radio"
									name="optionsRadios" id="radioMentor" value="Mentor"><%=language.getFirsttime_radio_mentor()%></label></td>
							<td><label class="radio inline"><input type="radio" checked
									name="optionsRadios" id="radioTrainee" value="Trainee"><%=language.getFirsttime_radio_trainee()%></label></td>									
						</tr>
						<tr>
							<td><label class="pull-right"><%=language.getFirsttime_label_addInfo()%></label></td>
							<td><textarea id="addInfo" name="addInfo"></textarea></td>
							<td><label class="pull-right"><%=language.getFirsttime_label_experience()%></label></td>
							<td>
								<select name="experience" id="experience">
									<option value="novice"> <%=language.getFirsttime_drop_novice()%> </option>
									<option value="intermediate"> <%=language.getFirsttime_drop_intermediate()%> </option>
									<option value="expert"> <%=language.getFirsttime_drop_expert()%> </option>
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
						<th><%=language.getFirsttime_label_field()%></th>
						<th><%=language.getFirsttime_label_addInfo()%></th>
						<th><%=language.getFirsttime_radio_mentor() %></th>
						<th><%=language.getFirsttime_radio_trainee() %></th>
						<th><%=language.getFirsttime_label_experience() %></th>
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
		// oTr.append( 
		//	$('<td>').append($('<input>', { name: "category", type: 'hidden', value: $('#category :selected').val() }))
		//			.append($('<span>').append($('#category :selected').text()))); 

		oTr.append(
				$('<td>').append($('<input>', { name: "field", type: 'hidden', value: $('#field').val() }))
						.append($('<span>').append($('#field').val())));

		oTr.append(
				$('<td>').append($('<input>', { name: "addInfo", type: 'hidden', value: $('#addInfo').val() }))
						.append($('<span>').append($('#addInfo').val())));

		// legger til en TD til TR med data fra fieldselecten
		//oTr.append(
		//	$('<td>').append($('<input>', { name: "field", type: 'hidden', value: $('#field :selected').val() }))
 		//			.append($('<span>').append($('#field :selected').text())));

		// Henter inn valgte option for trainee / mentor
	    var trMen = $("input[name=optionsRadios]:checked");

		// Legger til tekst og verdi i input fra radiobuttonen
		oTr.append(
			$('<td>').append($('<input>', { name: "mentor", type: 'hidden', value: (trMen.val() == 'Mentor'?'Yes':'No') }))
					.append($('<span>').append((trMen.val() == 'Mentor')?'Yes':'No')));

		oTr.append(
			$('<td>').append($('<input>', { name: "trainee", type: 'hidden', value: (trMen.val() == 'Trainee'?'Yes':'No') }))
					.append($('<span>').append((trMen.val() == 'Trainee')?'Yes':'No')));
					//.append($('<input>', { name: "addInfo", type: 'hidden', value: $('#addInfo').val() })));

		oTr.append(
				$('<td>').append($('<input>', { name: "experience", type: 'hidden', value: $('#experience :selected').val() }))
						.append($('<span>').append($('#experience :selected').text())));

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