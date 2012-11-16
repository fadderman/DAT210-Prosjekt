<%@page import="language.*,models.*,java.util.ArrayList"%>
<%Language language = (Language)session.getAttribute("lang"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<%
		Field fieldObject = (Field)request.getAttribute("field");
		String fieldString = fieldObject.getTitle();
		pageContext.setAttribute("fieldString", fieldString);
		TraineeWithField t = new TraineeWithField(fieldString);
		ArrayList<User> trainees = t.getTrainee();
		pageContext.setAttribute("traineeExists", !trainees.isEmpty());
	%>
	<div id="showTraineeList" class="modal hide fade in" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>
				<%=language.getFindList_trainee_legend()%>
			</h3>
		</div>
		<div class="modal-body">
		<c:if test="${traineeExists eq true}">
			<table id="ListofMentor" class="table table-hover table-condensed">
			<tr>
				<th><%=language.getProfile_name()%></th>
				<th><%=language.getSearch_location()%></th>
				<th></th>
			</tr>
			<%
				for (User user : trainees) {
			%>

			<tr>
				<td><%=user.getFirstName()%> <%=user.getLastName()%></td>
				<td><%=user.getLocationCity()%>, <%=user.getLocationCountry() %></td>
				<td>
					<form action="RegisterConnection" name="select_user" method="post" style="margin:0px">
						<input type="hidden" name="userID" value=<%=user.getUserID()%>>
						<input type="hidden" name="field" value="${fieldString}">
						<input type="hidden" name="isTraineeList" value="true">
						 <input	type="submit" value="<%=language.getFindList_connect()%>" class="btn btn-primary btn-small">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		</c:if>
		<c:if test="${traineeExists eq false}">
			<%=language.getFindList_no_trainee()%>
		</c:if>
		</div>
	</div>
