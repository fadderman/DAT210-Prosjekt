<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<%
	String include = (String) request.getAttribute("include");
	if(include == null) include = "home.jsp";
%>

<body class="contentBox">
	<jsp:include page="menu.jsp"/>
	<br/><br/><br/>
	<jsp:include page="<%= include %>"/>
</body>
</html>