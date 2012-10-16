
<!DOCTYPE html>
<html>
<head>
<title>MentorFind Home</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<link rel="shortcut icon" href="img/favicon.ico"></link>
<body class="contentBox">
	<%@ page import="models.User"%>
	<!-- <%User user = (User)request.getAttribute("user"); %>  -->
	<% User user2 = new User("openIdTest", "Glenn", "Henriksen", "glenn@henriksen.no", "http://maps.googleapis.com/maps/api/staticmap?center=Stavanger,Norge&zoom=14&size=400x400&sensor=false"); %>

	<div class="container">
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
	
</script>

</html>