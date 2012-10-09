<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Search</title>

	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="js/jquery.autocomplete.js"></script>  
</head>
<body>
<p />
	<div class="container well">
		<div class="row-fluid">
			<input type="text" name="search" id="search" class="span5" />
			<script>
		        $("#search").autocomplete("getsearch.jsp");
		    </script>
		</div>
	</div>

</body>
</html>