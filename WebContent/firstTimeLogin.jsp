
<!DOCTYPE html>
<%@page import="models.User"%>
<html>
<head>
<title>MentorFind Home</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
</head>
<link rel="shortcut icon" href="img/favicon.ico"></link>

<%User user = (User)request.getAttribute("user"); %>

<body class="contentBox">
	<div class="container">
		<!-- top menu -->
		<br />
	
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner shadow">
				<div class="container">
					<a class="brand" href="#"> <i class="icon-home"></i>MentorFind
					</a>
					<ul class="nav">
						<li><a class="dropdown-toggle" data-toggle="dropdown"
							href="#"><i class="icon-user"></i> Profile <i
								class="icon-chevron-down"></i></a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dlabel">
								<!-- dropdown menu links -->
								<li class="active"><a href="#"><i class="icon-home"></i>
										Home</a></li>
								<li><a href="#"><i class="icon-wrench"></i> Preferences</a></li>
								<li><hr></li>
								<li><a href="logIn.html"><i class="icon-off"></i> Log
										out</a></li>
							</ul></li>
						<li><a href="inbox.html"><i class="icon-envelope"></i>
								Inbox</a></li>
						<li><a href="Contacts.html"><i class="icon-th-list"></i>
								Contacts</a></li>
						<li><a href="#"><i class="icon-briefcase"></i> CV</a></li>
					</ul>
					<form class="navbar-search pull-right">
						<input type="text" class="search-query" placeholder="Search">
					</form>
				</div>
			</div>
		</div>
		<div class="padding"></div>
		<div class="row-fluid">
			<!--left column -->
			<h4 style="text-shadow: #000000 3px 3px 8px; color:white;">Personal</h4>
			<form class="well span12 shadow">

				
				<table class="tableBorderless">
					<tbody>
						<tr>
							<td>
								<p class="pull-right">First name:</p>
							</td>
							<td>
								<input class="textarea" value="<%=user.getFirstName()%>">
							</td>
							<td>
								<p class="pull-right">Last name:</p>
							</td>
							<td>
								<input id="lastName" class="textarea" value="<%=user.getLastName()%>">
							</td>
						</tr>
						<tr>
							<td>
								<p class="pull-right">Epost:</p>
							</td>
							<td><input class="textarea" value="<%=user.getEmail()%>">
							</td>
							<td></td><td></td>
						</tr>
						<tr>
							<td>
								<p class="pull-right">Country:</p>
							</td>
							
							<td>
								<input class="textarea" value="">
							</td>
							<td>
								<p class="pull-right">City:</p>
							</td>
								<td>
									<input class="textarea" value="">
								</td>
						</tr>
					</tbody>
				</table>
			<input type="submit" class="btn btn-primary"/>
			</form>

			<!--right column -->


		</div>

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
<!-- Modal -->
<div id="dropDownMsg" class="modal hide fade in" style="display: none;">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>New message</h3>
	</div>
	<div class="modal-body">
		<table>
			<tr>
				<td><textarea rows="6" class="textarea span4"
						placeholder="Write your message here..."></textarea></td>
				<td><img alt="" src="img/user.png" class="img-rounded offset1"></td>
			</tr>
		</table>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn btn-success"><strong>Send</strong></a> <a
			href="#" class="btn" data-dismiss="modal">Cancel</a>
	</div>
</div>
</html>