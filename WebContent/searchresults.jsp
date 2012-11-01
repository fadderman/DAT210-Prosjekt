<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="business.search.SearchResults, models.User, models.Field, java.util.ArrayList, language.*"%>
<%Language language = (Language)session.getAttribute("lang"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Results</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<%
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
	ArrayList<Field> fields = (ArrayList<Field>) request.getAttribute("fields");
	String query = request.getParameter("query").trim();
	
	pageContext.setAttribute("numResults", users.size() + fields.size());
	pageContext.setAttribute("emptyQuery", query.isEmpty());
	pageContext.setAttribute("query", query);
%>
<body>
<p />
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
	<div class="row-fluid">
		<div class="span12">
			<legend><%=language.getSearch_sResult()%></legend>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3 container well" style="box-shadow: 1px 1px 8px -1px #222;" >
			<div class="row-fluid"><i class="icon-filter"></i> <%=language.getSearch_fResult()%></div>
			<div class="row-fluid" style="margin-left: 20px">
				<label class="checkbox">
					<input type="checkbox" value="User" checked><i class="icon-user"></i> <%=language.getSearch_user()%>
				</label>
				<label class="checkbox">
					<input type="checkbox" value="Field" checked><i class="icon-book"></i> <%=language.getFirsttime_label_field()%>
				</label>
			</div>
		</div>
		<div class="span9">
			<c:choose>
				<c:when test="${emptyQuery eq true}">
					<div class="alert alert-error">
						<%=language.getSearch_error()%>
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults>0}">
					<div class="alert alert-success">
						<%=language.getSearch_resultStart()%><b>${query}</b><%=language.getSearch_returned()%> ${numResults} <%=language.getSearch_success()%>
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults==0}">
					<div class="alert alert-error">
						<%=language.getSearch_resultStart()%><b>${query}</b><%=language.getSearch_noResults()%>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
	<c:forEach var="user" items="${users}">
		<div class="row-fluid">
			<div class="container well span12" style="box-shadow: 1px 1px 8px -1px #222;" >
				
				<div class="span1">
					<div class="row-fluid">
						<i class="icon-user"></i>
					</div>
				</div>
				<div class="span5">
					<div class="row-fluid">
<<<<<<< HEAD
						<div class="span4"><b>Name</b></div>
						<div class="span8"><a href="viewprofile?id=${user.userID}">${user.firstName} ${user.lastName}</a></div>
=======
						<div class="span4"><b><%=language.getSearch_name()%></b></div>
						<div class="span8"><a href="">${user.firstName} ${user.lastName}</a></div>
>>>>>>> 2d92f4c1e295fe958f1bac46fecab85de9636e8f
					</div>
					<div class="row-fluid">
						<div class="span4"><b><%=language.getSearch_location()%></b></div>
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
	
	<c:forEach var="field" items="${fields}">
		<div class="row-fluid">
			<div class="container well span12">
				
				<div class="span1">
					<div class="row-fluid">
						<i class="icon-book"></i>
					</div>
				</div>
				<div class="span11">
					<div class="row-fluid">
<<<<<<< HEAD
						<div class="span2"><b>Title</b></div>
						<div class="span10"><a href="field?id=${field.fieldID}">${field.title}</a></div>
=======
						<div class="span2"><b><%=language.getSearch_title()%></b></div>
						<div class="span10"><a href="">${field.title}</a></div>
>>>>>>> 2d92f4c1e295fe958f1bac46fecab85de9636e8f
					</div>
					<div class="row-fluid">
						<div class="span2"><b><%=language.getSearch_description()%></b></div>
						<div class="span10">${field.description}</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

</body>
</html>