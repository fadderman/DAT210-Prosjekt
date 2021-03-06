<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.* , language.*" %>
<%Language language = (Language)session.getAttribute("lang"); %>
<%
	User currentUser = (User) session.getAttribute("currentUser");
	Connection connection = (Connection) request.getAttribute("connection");
	boolean hasMentor = true;
	boolean hasTrainee = false;
	boolean isCurrentUserMentor = false;
	if(connection.getMentor() != null){
		if(currentUser.getUserID() == connection.getMentor().getUserID()) {
			isCurrentUserMentor = true;
			session.setAttribute("profile", connection.getTrainee());	
			pageContext.setAttribute("profile", connection.getTrainee());
		}
	}else hasMentor = false;
	if(connection.getTrainee() != null){
		hasTrainee = true;
		
		if(!isCurrentUserMentor){
			pageContext.setAttribute("profile", connection.getMentor());
			session.setAttribute("profile", connection.getMentor());
		}
	}
	pageContext.setAttribute("isCurrentUserMentor", isCurrentUserMentor);
	pageContext.setAttribute("hasMentor", hasMentor);
	pageContext.setAttribute("hasTrainee", hasTrainee);
	
%>
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
	<i class="icon-globe"></i>
	<legend><%=language.getConnections_welcome()%></legend>
	<div class="row-fluid">
	<div class="span6">
		<table class="tableBorderless">
			<tr>
				<td><b>Mentor</b></td>
				<c:choose>
					<c:when test="${isCurrentUserMentor eq true }">
						<td><%=language.getConnections_you()%></td>
						<td></td>
					</c:when>
					<c:when test="${isCurrentUserMentor eq false and hasMentor eq true}">
						<td><a href="viewprofile?id=${connection.mentor.userID}">${connection.mentor.firstName } ${connection.mentor.lastName }</a></td>
						<td><a class="btn btn-warning" href="#newMail" data-toggle="modal">Contact</a></td>
					</c:when>
					<c:when test="${isCurrentUserMentor eq false and hasMentor eq false}">
						<td><%=language.getConnections_noMentor()%></td>
						<td></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td><b>Trainee</b></td>
				<c:choose>
					<c:when test="${isCurrentUserMentor eq false}">
						<td><%=language.getConnections_you()%></td>
						<td></td>
					</c:when>
					<c:when test="${isCurrentUserMentor eq true and hasTrainee eq true}">
						<td><a href="viewprofile?id=${connection.trainee.userID}">${connection.trainee.firstName } ${connection.trainee.lastName }</a></td>
						<td><a class="btn btn-warning" href="#newMail" data-toggle="modal"><%=language.getConnections_contact()%></a></td>
					</c:when>
					<c:when test="${isCurrentUserMentor eq true and hasTrainee eq false}">
						<td><%=language.getConnections_noTrainee()%></td>
						<td></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td><b><%=language.getFirsttime_label_field()%></b></td>
				<td><a href="field?id=${connection.field.fieldID}">${connection.field.title }</a></td>
				<td></td>
			</tr>
		</table>
	</div>
 	<div class="span6">
 		<c:choose>
			<c:when test="${isCurrentUserMentor eq false }">
			<img src="http://maps.googleapis.com/maps/api/staticmap?center=${connection.mentor.locationCity},${connection.mentor.locationCountry}&zoom=12&size=500x350&sensor=false">
				<%=language.getProfile_location()%>: ${connection.mentor.firstName } ${connection.mentor.lastName }
			</c:when>
			<c:when test="${isCurrentUserMentor eq true }">
			<img src="http://maps.googleapis.com/maps/api/staticmap?center=${connection.trainee.locationCity},${connection.trainee.locationCountry}&zoom=12&size=500x350&sensor=false">
				<%=language.getProfile_location()%>: ${connection.trainee.firstName } ${connection.trainee.lastName }
				
			</c:when>
		</c:choose>
 	</div>
 	</div>
</div>