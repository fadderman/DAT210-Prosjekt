<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="business.search.SearchResults, models.User, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Results</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<%
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
	String query = request.getParameter("query").trim();
	
	pageContext.setAttribute("numResults", users.size());
	pageContext.setAttribute("emptyQuery", query.isEmpty());
	pageContext.setAttribute("query", query);
%>
<body>
<p />
<div class="container well">
	<div class="row-fluid">
		<div class="span12">
			<legend>Search Results</legend>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span2 container well">
			<div class="row-fluid"><i class="icon-filter"></i> Filter results</div>
			<div class="row-fluid" style="margin-left: 20px">
				<label class="checkbox">
					<input type="checkbox" value="User" checked><i class="icon-user"></i> User
				</label>
				<label class="checkbox">
					<input type="checkbox" value="Subject" checked><i class="icon-book"></i> Subject
				</label>
			</div>
		</div>
		<div class="span10">
			<c:choose>
				<c:when test="${emptyQuery eq true}">
					<div class="alert alert-error">
						You did not enter a search query. Please try again.
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults>0}">
					<div class="alert alert-success">
						Your search for '<b>${query}</b>' returned ${numResults} result(s).
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults==0}">
					<div class="alert alert-error">
						Your search for '<b>${query}</b>' did not return any results. Please try again.
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
	<c:forEach var="user" items="${users}">
	
	
		<div class="row-fluid">
			<div class="container well span12">
				
				<div class="span1">
					<div class="row-fluid">
						<i class="icon-user"></i>
					</div>
				</div>
				<div class="span5">
					<div class="row-fluid">
						<div class="span4"><b>Name</b></div>
						<div class="span8"><a href="">${user.firstName} ${user.lastName}</a></div>
					</div>
					<div class="row-fluid">
						<div class="span4"><b>Location</b></div>
						<div class="span8">${user.locationCity}, ${user.locationCountry}</div>
					</div>
				</div>
				<div class="span6">
					<div class="span12">
						<img src="http://maps.googleapis.com/maps/api/staticmap?center=${user.locationCity},${user.locationCountry}&zoom=12&size=500x150&sensor=false">
					</div>
				</div>
				
			</div>
		</div>
	</c:forEach>
</div>

</body>
</html>