<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="language.*" %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MentorFind</title>
<link rel="shortcut icon"  href="img/favicon.ico" ></link>
</head>
<!-- login_bg taken from interfacelift.com by thekidder. url: http://interfacelift.com/wallpaper/details/3062/stormy_ocean.html -->
<style type="text/css">

</style>
<body class="fullBG">

<%@ include file="loginMenuBar.jsp"%>
<%
	session.setAttribute("CurrentPage", "/login.jsp"); 
%>

	<div class="container">

		<div class="row-fluid">
			<!-- left side -->
			<div class="loginLetter span8 ">
				<h1>MentorFind</h1>
				<p style="font-size: 14pt;"><%=language.getLogin_moto()%></p>
				<p>
					<a class="btn btn-info" href="#dropDownMsg" data-toggle="modal"><%=language.getLogin_btn_learn()%></a>
					<!-- <a href="#" id="example" class="btn btn-info btn-large" rel="popover"  
						data-content=""data-original-title="Twitter Bootstrap Popover">Info</a> -->
				</p>
			</div>
			<!-- right side -->
			<div class="span4">
				<div>
					<form class="well shadow">
						<p style="font-size: 16pt;"><%=language.getLogin_signIn()%></p>
						<hr>
						<a type="Submit" class="btn btn-large btn-warning span12"
							style="margin-bottom: 5px" href="<%=response.encodeURL("login?openid_identifier=https://www.google.com/accounts/o8/id")%>">Google</a>
							<a type="Submit" class="btn btn-large btn-success span12"
							style="margin-bottom: 5px" href="<%=response.encodeURL("login?openid_identifier=https://me.yahoo.com/")%>">Yahoo</a>
						<!-- <a type="Submit" class="btn btn-large btn-primary disabled span12"
							style="margin-bottom: 5px">Facebook</a> <a type="Submit"
							class="btn btn-large btn-info span12 disabled" style="margin-bottom: 5px">Twitter</a> -->
						<div class="padding"></div>
					</form>
				</div>
			</div>
		</div>

		<br /> <br /> <br />
		<!-- <div class="padding"></div> -->
		<div class="form-inline pagination-centered"
			style="text-shadow: #000000 1px 1px 12px;">
			<a href="mailto:mentorfind@outlook.com" style="color: white;">Feedback</a>
			<a
				href="http://interfacelift.com/wallpaper/details/3062/stormy_ocean.html"
				style="color: white;">Wallpaper</a> <label style="color: #dcdcdc;"><small>©
					2012 MentorFind</small></label>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.js"></script>

</body>

<!-- Modal -->
<div id="dropDownMsg" class="modal hide fade in" style="display: none;">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>
			<img alt="" src="img/logo_black.png">Info
		</h3>
	</div>
	<div class="modal-body">
		<iframe width="525" height="315"
			src="http://www.youtube.com/embed/nJ6r1XufCQU"></iframe>
	</div>
</div>
</html>