<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="models.User, language.*"%>

<%
	Language language = (Language)session.getAttribute("lang");
	User profile = (User) session.getAttribute("currentUser");
	pageContext.setAttribute("profile", profile);
	
	boolean edit = false;
	
	String editString = request.getParameter("edit");
	if(editString != null) {
		if(editString.equals("true")) {
			edit = true;
		}
	}
	
	pageContext.setAttribute("edit", edit);
	
%>
<form action="editUser" method="post">
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
<<<<<<< HEAD
	<legend>Profile</legend>
	<p>Not yet implemented</p>
</div>
=======
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
						<div class="span4"><b><%= language.getProfile_name() %></b></div>
						<div class="span8">
						<c:choose>
							<c:when test="${edit eq true}"><input type="text" name="name" value="${profile.firstName} ${profile.lastName}" placeholder="<%= language.getProfile_name() %>"></c:when>
							<c:otherwise>
								${profile.firstName} ${profile.lastName}
							</c:otherwise>
						</c:choose>			
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4"><b><%= language.getProfile_location() %></b></div>
						<div class="span8">
						<c:choose>
							<c:when test="${edit eq true}">
								<table class="span8">
									<tr>
										<td class="span4"><input type="text" class="input-small" name="locationCity" value="${profile.locationCity}" placeholder="<%= language.getProfile_city() %>"></td>
										<td>,</td>
										<td class="span4"><input type="text" class="input-small" name="locationCountry" value="${profile.locationCountry}" placeholder="<%= language.getProfile_country() %>"></td>
									</tr>
								</table>
							</c:when>
							<c:otherwise>
								${profile.locationCity}, ${profile.locationCountry}
							</c:otherwise>
						</c:choose>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
						
							<a class="btn btn-warning" type="submit" href="profile?edit=true"><%= language.getProfile_edit() %></a>
							
							<c:if test="${edit eq true}">
								<input type="hidden" name="userId" value="${profile.userID}">
								<input class="btn btn-success" type="submit" value="<%= language.getProfile_save() %>">
							</c:if>
						
						</div>
					</div>
				</div>
				<div class="span6">
					<img src="http://maps.googleapis.com/maps/api/staticmap?center=${profile.locationCity},${profile.locationCountry}&zoom=12&size=500x350&sensor=false">
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>
</form>
>>>>>>> 9ee9347eeecb05c284a3c89bad12e7fed5bb65c8
