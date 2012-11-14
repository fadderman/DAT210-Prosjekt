<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="models.User"%>

<%
	User profile = (User) request.getAttribute("profile");
	pageContext.setAttribute("profile", profile);
	
	boolean nullUser = false;
	if(profile == null) nullUser = true;
	
	pageContext.setAttribute("nullUser", nullUser);
%>

<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">

	<c:choose>
		<c:when test="${nullUser eq true}">
			<div class="alert alert-error">
				Given user does not exist or the given argument is invalid. Please try again.
			</div>
		</c:when>
		<c:otherwise>
			<div class="row-fluid">
				<div class="span12"><i class="icon-user"></i><legend>${profile.firstName} ${profile.lastName}</legend></div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<div class="row-fluid">
						<div class="span4"><b>Name</b></div>
						<div class="span8">${profile.firstName} ${profile.lastName}</div>
					</div>
					<div class="row-fluid">
						<div class="span4"><b>Location</b></div>
						<div class="span8">${profile.locationCity}, ${profile.locationCountry}</div>
					</div>
					<div class="row-fluid">
						<div class="span12"><a class="btn btn-primary" type="submit" href="mailto:${profile.email}">Contact</a></div>
					</div>
				</div>
				<div class="span6">
					<img src="http://maps.googleapis.com/maps/api/staticmap?center=${profile.locationCity},${profile.locationCountry}&zoom=12&size=500x350&sensor=false">
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
</div>