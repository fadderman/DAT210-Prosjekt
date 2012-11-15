<%@page import="language.*,models.*,java.util.ArrayList"%>
<%Language language = (Language)session.getAttribute("lang"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<%
		Field fieldObject = (Field)request.getAttribute("field");
		String fieldString = fieldObject.getTitle();
		pageContext.setAttribute("fieldString", fieldString);
		TraineesWithSubject t = new TraineesWithSubject(fieldString);
		ArrayList<User> trainees = t.getTraineesWithSubject();
		pageContext.setAttribute("traineeExists", !trainees.isEmpty());
	%>
	<div id="showTraineeList" class="modal hide fade in" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">�</button>
			<h3>
				List of Trainees
			</h3>
		</div>
		<div class="modal-body">
		<c:if test="${traineeExists eq true}">
			<table id="ListofMentor" class="table table-hover table-condensed">
			<tr>
				<th>Name</th>
				<th>Location</th>
				<th></th>
			</tr>
			<%
				for (User user : trainees) {
			%>

			<tr>
				<td><%=user.getFirstName()%> <%=user.getLastName()%></td>
				<td><%=user.getLocationCity()%>, <%=user.getLocationCountry() %></td>
				<td>
					<form action="RegisterConnection" name="select_user" method="post">
						<input type="hidden" name="userID" value=<%=user.getUserID()%>>
						<input type="hidden" name="field" value="${fieldString}">
						<input type="hidden" name="isTraineeList" value="true">
						 <input	type="submit" value="connect" class="btn btn-primary btn-small">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		</c:if>
		<c:if test="${traineeExists eq false}">
			No trainees available
		</c:if>
		</div>
	</div>
