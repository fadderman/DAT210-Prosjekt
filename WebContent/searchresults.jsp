<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="business.search.SearchResults, models.User, models.Field, business.sort.*, java.util.ArrayList, language.*, java.util.Collections"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Results</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<%
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
	if(users != null) {
		Collections.sort(users, new UserComparator());
	}
	ArrayList<Field> fields = (ArrayList<Field>) request.getAttribute("fields");
	if(fields != null) {
		Collections.sort(fields, new FieldComparator());
	}
	String query = request.getParameter("query").trim();
	
	pageContext.setAttribute("numResults", users.size() + fields.size());
	pageContext.setAttribute("emptyQuery", query.isEmpty());
	pageContext.setAttribute("query", query);
	pageContext.setAttribute("userResults", !users.isEmpty());
	pageContext.setAttribute("fieldsResults", !fields.isEmpty());
	
	Language language = (Language) session.getAttribute("lang");
	
	boolean showUsers = true;
	boolean showFields = true;
	
	String showUsersString = request.getParameter("users");
	if(showUsersString != null) {
		if(showUsersString.equals("true")) {
			showUsers = true;
		} else {
			showUsers = false;
		}
	}
	
	String showFieldsString = request.getParameter("fields");
	if(showFieldsString != null) {
		if(showFieldsString.equals("true")) {
			showFields = true;
		} else {
			showFields = false;
		}
	}
	
	pageContext.setAttribute("showFields", showFields);
	pageContext.setAttribute("showUsers", showUsers);
	
%>


<script type="text/javascript">
	function toggleCheckbox() {
		if(document.filter.user.checked == true && document.filter.field.checked == true) {
			location.href = "search?query=${query}&users=true&fields=true";
		} else if(document.filter.user.checked == true && document.filter.field.checked == false) {
			location.href = "search?query=${query}&users=true&fields=false";
		} else if(document.filter.user.checked == false && document.filter.field.checked == true) {
			location.href = "search?query=${query}&users=false&fields=true";
		} else if(document.filter.user.checked == false && document.filter.field.checked == false) {
			location.href = "search?query=${query}&users=false&fields=false";
		} 
		
		else if(document.filter.user.checked == true) {
			location.href = "search?query=${query}&users=true";
		} else if(document.filter.user.checked == false) {
			location.href = "search?query=${query}&users=false";
		} else if(document.filter.field.checked == true) {
			location.href = "search?query=${query}&fields=true";
		} else if(document.filter.field.checked == false) {
			location.href = "search?query=${query}&fields=false";
		}
		
	}
</script>

<body>
<p />
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
	<div class="row-fluid">
		<div class="span12">
			<i class="icon-search"></i><legend><%= language.getSearch_sResult() %></legend>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3 container well">
			<div class="row-fluid"><i class="icon-filter"></i> <%= language.getSearch_fResult() %></div>
			<div class="row-fluid" style="margin-left: 20px">
				<form name="filter">
				<label class="checkbox">
					<input type="checkbox" value="User" id="user" onclick="toggleCheckbox()" <% if(showUsers) { %>checked<% } %>><i class="icon-user"></i> <%= language.getSearch_user() %>
				</label>
				<label class="checkbox">
					<input type="checkbox" value="Field" id="field" onclick="toggleCheckbox()" <% if(showFields) { %>checked<% } %>><i class="icon-book"></i> <%= language.getFirsttime_label_field() %>
				</label>
				</form>
			</div>
		</div>
		<div class="span9">
			<c:choose>
				<c:when test="${emptyQuery eq true}">
					<div class="alert alert-error">
						<%= language.getSearch_error() %>
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults>0}">
					<div class="alert alert-success">
						<%= language.getSearch_resultStart() %><b>${query}</b><%= language.getSearch_returned() %> ${numResults} <%= language.getSearch_success() %>
					</div>
				</c:when>
				<c:when test="${emptyQuery eq false and numResults==0}">
					<div class="alert alert-error">
						<%= language.getSearch_resultStart() %><b>${query}</b><%= language.getSearch_noResults() %>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
	
	<c:if test="${showUsers eq true}">
	<c:if test="${userResults eq true}">
		<legend><%= language.getSearch_user() %></legend>
		<c:forEach var="user" items="${users}">
			<div class="row-fluid">
				<div class="container well span12" style="box-shadow: 0px 0px 5px -1px #222;">
					
					<div class="span1">
						<div class="row-fluid">
							<i class="icon-user"></i>
						</div>
					</div>
					<div class="span5">
						<div class="row-fluid">
							<div class="span4"><b><%= language.getSearch_name() %></b></div>
							<div class="span8"><a href="viewprofile?id=${user.userID}">${user.firstName} ${user.lastName}</a></div>
						</div>
						<div class="row-fluid">
							<div class="span4"><b><%= language.getSearch_location() %></b></div>
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
	</c:if>
	</c:if>
	
	<c:if test="${showFields eq true}">
	<c:if test="${fieldsResults eq true}">
	<legend><%= language.getFirsttime_label_field() %></legend>
		<c:forEach var="field" items="${fields}">
			<div class="row-fluid">
				<div class="container well span12" style="box-shadow: 0px 0px 5px -1px #222;">
					
					<div class="span1">
						<div class="row-fluid">
							<i class="icon-book"></i>
						</div>
					</div>
					<div class="span11">
						<div class="row-fluid">
							<div class="span2"><b><%= language.getSearch_title() %></b></div>
							<div class="span10"><a href="field?id=${field.fieldID}">${field.title}</a></div>
						</div>
						<div class="row-fluid">
							<div class="span2"><b><%= language.getSearch_description() %></b></div>
							<div class="span10">${field.description}</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
	</c:if>
</div>

</body>
</html>