<%@page import="language.*,models.*,java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%Language language = (Language)session.getAttribute("lang"); %>
<!-- Modal -->
<%
		Field fieldObject = (Field)request.getAttribute("field");
		String fieldString = fieldObject.getTitle();
		pageContext.setAttribute("fieldString", fieldString);
		MentorsWithField m = new MentorsWithField(fieldString);
		ArrayList<User> mentors = m.getMentorsWithSubject();
		pageContext.setAttribute("mentorExists", !mentors.isEmpty());
	%>
<!--  <form method="post" action="RegisterConnection" style="margin:0px"> -->
	<div id="showMentorList" class="modal hide fade in" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">�</button>
			<h3>
				<%=language.getFindList_mentor_legend()%>
			</h3>
		</div>
		<div class="modal-body">
		<c:if test="${mentorExists eq true}">
			<table id="ListofMentor" class="table table-hover table-condensed">
			<tr>
				<th><%=language.getProfile_name()%></th>
				<th><%=language.getSearch_location()%></th>
				<th></th>
			</tr>
			<%
				for (User user : mentors) {
			%>

			<tr>
				<td><%=user.getFirstName()%> <%=user.getLastName()%></td>
				
				<td><%=user.getLocationCity()%>, <%=user.getLocationCountry() %></td>
				<td>
					<form action="RegisterConnection" name="select_user" method="post" style="margin:0px">
						<input type="hidden" name="userID" value=<%=user.getUserID()%>>
						<input type="hidden" name="field" value="${fieldString}"> 
						<input type="hidden" name="isTraineeList" value="false">
						<input type="submit" value="<%=language.getFindList_connect()%>" class="btn btn-primary btn-small">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		</c:if>
		<c:if test="${mentorExists eq false}">
			<%=language.getFindList_no_mentor()%>
		</c:if>
		</div>
	</div>
