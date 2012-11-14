<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="language.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>MentorFind</title>
	<link rel="shortcut icon"  href="img/favicon.ico" ></link>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.catcomplete.css" />
     
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    
	<script src="js/bootstrap.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    
</head>

<jsp:include page="language.jsp"/>
<%
	String include = (String) request.getAttribute("include");
	if(include == null) include = "home.jsp";
	
	Language language = (Language) session.getAttribute("lang");
%>

<body class="contentBox">
<%
	if(session.getAttribute("currentUser") == null) {
		response.sendRedirect("login.jsp");
	} else {
		%>
			<jsp:include page="menu.jsp"/>
			<div style="margin-top: 60px"></div>
			<jsp:include page="showRequests.jsp" />
			<jsp:include page="<%= include %>"/>
			<jsp:include page="newmail.jsp"/>
		<%
	}
%>
	
</body>
</html>