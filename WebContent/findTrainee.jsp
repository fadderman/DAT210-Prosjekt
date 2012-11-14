<%@page import="models.*,java.util.ArrayList"%>
<!-- Modal -->
<%
		Field fieldObject = (Field)request.getAttribute("field");
		String fieldString = fieldObject.getTitle();
		pageContext.setAttribute("fieldString", fieldString);
		TraineesWithSubject t = new TraineesWithSubject(fieldString);
		ArrayList<User> trainees = t.getTraineesWithSubject();
	%>
	<div id="showTraineeList" class="modal hide fade in" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>
				List of Trainees
			</h3>
		</div>
		<div class="modal-body">
			<table id="ListofMentor" class="table table-hover table-condensed">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Location</th>
				<th>Join</th>
			</tr>
			<%
				for (User user : trainees) {
			%>

			<tr>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastName()%></td>
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
		</div>
	</div>
