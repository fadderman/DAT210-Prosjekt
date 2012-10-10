<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
.contentBox {
	overflow: scroll;
	background: url("img/bg.png");
	background-repeat: repeat-x;
	background-attachment: fixed;
}
.fullBG {
	background: url("img/login_bg.jpg");
	background-attachment: fixed;
		background-repeat:no-repeat;
	background-size:cover;
	-moz-background-size: cover;
}
.loginLetter{
  padding: 60px;
  margin-bottom: 30px;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
          color: white;
          text-shadow: #000000 3px 3px 8px;
}

.shadow {
  box-shadow: 5px 5px 8px -1px #222;
}
.padding {
	padding: 90px;
}
</style>
<body class="fullBG">

<!-- top menu -->
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar">
			<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img alt="" src="img/logo_mini.png" ></a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle btn-inverse btn-large" data-toggle="dropdown"
						href="#"><small> Language </small><span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<!-- dropdown menu links -->
						<li><a href="<%=response.encodeURL("chosenLanguage?language=english")%>">English</a></li>
						<li><a href="<%=response.encodeURL("chosenLanguage?language=norsk")%>">Norsk</a></li>
					</ul>
				</div>
			</div>
			</div>
		</div>
	</div>
	<div class="padding"></div>
	<div class="container">

			<div class="row-fluid">
				<!-- left side -->
				<div class="loginLetter span8 ">
					<h1>MentorFind</h1>
					<p style="font-size: 14pt;">Find mentors and trainees with the right qualifications and share knowledge, all
						in one place.</p>
					<p>
						<a class="btn btn-info" href="#dropDownMsg" data-toggle="modal">Learn more</a>
						<!-- <a href="#" id="example" class="btn btn-info btn-large" rel="popover"  
						data-content=""data-original-title="Twitter Bootstrap Popover">Info</a> -->
					</p>
				</div>
				<!-- right side -->
				<div class="span4">
					<div>
						<form class="well shadow">
						<p style="font-size:16pt;">Sign in with:</p>
							<hr>
							<p>
							<input type="Submit" class="btn btn-large btn-primary span12" value="Facebook"></input>
							</p><p>
							<input type="Submit"  class="btn btn-large btn-info span12" value="Twitter"></input>
							</p><p>
							<input type="Submit"  class="btn btn-large btn-warning span12" value="Google"></input>
							</p>
							<input type="Submit"  class="btn btn-large btn-success span12" value="Windows Live"></input>
						</form>
					</div>
				</div>
			</div>

		<br/><br/>
		<!-- <div class="padding"></div> -->
		<div class="form-inline pagination-centered" style="text-shadow: #000000 3px 3px 8px;">
			<a href="mailto:mentorfind@outlook.com" style="color: white;">Feedback</a> 
			<a href="http://interfacelift.com/wallpaper/details/3062/stormy_ocean.html" style="color:white;">Wallpaper</a>
			<label style="color: #dcdcdc;"><small>© 2012 MentorFind</small></label>
		</div>
	</div>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.js"></script>

</body>

<!-- Modal -->
<div id="dropDownMsg" class="modal hide fade in" style="display: none;">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3><img alt="" src="img/logo_black.png">Info</h3>
	</div>
	<div class="modal-body">
		<iframe width="525" height="315" src="http://www.youtube.com/embed/nJ6r1XufCQU" ></iframe>
	</div>
</div>
</html>