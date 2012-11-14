<%@ page import="language.*, models.User, java.util.List, models.Connection, hibernate.ConnectionManagement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">

<legend>Connections</legend>

<%
	Language language = (Language) session.getAttribute("lang");
	User currentUser = (User) session.getAttribute("currentUser");
	
	ConnectionManagement cManagement = new ConnectionManagement();
	
	List<Connection> currentUserMentor = cManagement.getByMentor(currentUser);
	List<Connection> currentUserTrainee =  cManagement.getByTrainee(currentUser);
	
	boolean hasMentorConnections = false;
	boolean hasTraineeConnections = false;
	
	if(!currentUserMentor.isEmpty()) {
		hasMentorConnections = true;
	}
	
	if(!currentUserTrainee.isEmpty()) {
		hasTraineeConnections = true;
	}
	
	pageContext.setAttribute("mentorList", currentUserMentor);
	pageContext.setAttribute("traineeList", currentUserTrainee);
	pageContext.setAttribute("hasMentorConnections", hasMentorConnections);
	pageContext.setAttribute("hasTraineeConnections", hasTraineeConnections);
%>

<script>
	$.widget( "custom.catcomplete", $.ui.autocomplete, {
	    _renderMenu: function( ul, items ) {
	        var that = this,
	            currentCategory = "";
	        $.each( items, function( index, item ) {
	            if ( item.category != currentCategory ) {
	                ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
	                currentCategory = item.category;
	            }
	            that._renderItemData( ul, item );
	        });
	    }
	});
</script>

<script type="text/javascript">
	$(function() {
	    $( "#field" ).catcomplete({
	        delay: 500,
	        minLength: 1,
	        source: 'getsearchfieldjson.jsp'
	    });
	});
</script>

<form action="addConnection" method="post" style="margin: 0px">
<table class="tableBorderless">
<tbody>
	<tr>
		<td><label class="pull-right"><%=language.getFirsttime_label_field()%></label></td>
		<td><input name="field" type="text" id="field">
		<td><label class="radio inline"><input type="radio" name="optionsRadios" id="radioMentor" value="Mentor"><%=language.getFirsttime_radio_mentor()%></label></td>
		<td><label class="radio inline"><input type="radio" name="optionsRadios" id="radioTrainee" value="Trainee" checked><%=language.getFirsttime_radio_trainee()%></label></td>									
	</tr>
	<tr>
		<td><label class="pull-right"><%=language.getFirsttime_label_addInfo()%></label></td>
		<td><textarea id="addInfo" name="addInfo"></textarea></td>
		<td><label class="pull-right"><%=language.getFirsttime_label_experience()%></label></td>
		<td>
			<select name="experience" id="experience">
				<option value="novice"> <%=language.getFirsttime_drop_novice()%> </option>
				<option value="intermediate"> <%=language.getFirsttime_drop_intermediate()%> </option>
				<option value="expert"> <%=language.getFirsttime_drop_expert()%> </option>
			</select>
		</td>
		<td>
				<input type="submit" value="Add" class="btn btn-info">
		</td>
	</tr>
	</tbody>
</table>
</form>
<br />

<c:if test="${hasMentorConnections eq true or hasTraineeConnections eq true}">
<table class="table table-hover" id="tblCourse">
	<thead>
		<th><%=language.getFirsttime_label_field()%></th>
		<th><%=language.getFirsttime_label_addInfo()%></th>
		<th><%=language.getFirsttime_radio_mentor() %></th>
		<th><%=language.getFirsttime_radio_trainee() %></th>
		<th><%=language.getFirsttime_label_experience() %></th>
	</thead>
	<c:forEach var="traineeItem" items="${traineeList}">
		<tr>
			<td><a href="field?id=${traineeItem.field.fieldID}">${traineeItem.field.title}</a></td>
			<td>${traineeItem.field.description}</td>
			<td>No</td>
			<td>Yes</td>
			<td>
				<c:choose>
					<c:when test="${traineeItem.difficultyLevel eq 0}">
						<%=language.getFirsttime_drop_novice() %>
					</c:when>
					<c:when test="${traineeItem.difficultyLevel eq 1}">
						<%=language.getFirsttime_drop_intermediate() %>
					</c:when>
					<c:when test="${traineeItem.difficultyLevel eq 2}">
						<%=language.getFirsttime_drop_expert() %>
					</c:when>
				</c:choose>
			</td>
			<td>
				<form action="removeConnection" method="post" style="margin: 0px">
					<input type="hidden" name="connectionId" value="${traineeItem.connectionID}"/>
					<input type="submit" value="Remove" class="btn btn-danger btn-small">
				</form>
			</td>
		</tr>
	</c:forEach>
	<c:forEach var="mentorItem" items="${mentorList}">
		<tr>
			<td><a href="field?id=${mentorItem.field.fieldID}">${mentorItem.field.title}</a></td>
			<td>${mentorItem.field.description}</td>
			<td>Yes</td>
			<td>No</td>
			<td>
				<c:choose>
					<c:when test="${mentorItem.difficultyLevel eq 0}">
						<%=language.getFirsttime_drop_novice() %>
					</c:when>
					<c:when test="${mentorItem.difficultyLevel eq 1}">
						<%=language.getFirsttime_drop_intermediate() %>
					</c:when>
					<c:when test="${mentorItem.difficultyLevel eq 2}">
						<%=language.getFirsttime_drop_expert() %>
					</c:when>
				</c:choose>
			</td>
			<td>
				<form action="removeConnection" method="post" style="margin: 0px">
					<input type="hidden" name="connectionId" value="${mentorItem.connectionID}"/>
					<input type="submit" value="Remove" class="btn btn-danger btn-small">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<c:if test="${hasTraineeConnections eq false and hasMentorConnections eq false}">
	You have no connections at this time.
</c:if>
</div>