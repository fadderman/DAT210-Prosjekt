<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java"
	import="models.Request,models.Connection,models.*,hibernate.*, java.util.ArrayList, business.connection.RequestHandler, language.*"%>
<%
	Language language = (Language) session.getAttribute("lang");
	RequestManagement requestManager = new RequestManagement();
	UserManagement userManagement = new UserManagement();
	User currentUser = (User)session.getAttribute("currentUser");
	ArrayList<Request> requests = (ArrayList<Request>)requestManager.getRequestByUserID(currentUser.getUserID());
	pageContext.setAttribute("requests", requests);	
	pageContext.setAttribute("hasRequests", !requests.isEmpty());
	%>
<c:if test="${hasRequests eq true}">

<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
	<h4><%=language.getRequest_legend()%></h4>
	<table class="table table-hover">
	<c:forEach var="request" items="${requests}" varStatus="table">
		<c:choose>
			<c:when test="${request.traineeRequest eq false}">

				<tr id="${table.index}">
						<td class="span6"><a href="viewprofile?id=${request.connection.trainee.userID}">${request.connection.trainee.firstName} ${request.connection.trainee.lastName}</a>
							<%=language.getRequest_traniee()%>
							<a href="field?id=${request.connection.field.fieldID}">${request.connection.field.title}</a>
						</td>
						<td class="span4">
								<button class="btn btn-success"
									onclick="answerYes('${table.index}','${request.requestID}')"><%=language.getRequest_accept()%></button>
								<button class="btn btn-danger" onclick="answerNo('${table.index}','${request.requestID}')"><%=language.getRequest_deny()%></button>
							
						</td>
					</tr>

			</c:when>
			<c:when test="${request.traineeRequest eq true}">
				<tr id="${table.index}">
					<td class="span6"><a href="viewprofile?id=${request.connection.mentor.userID}">${request.connection.mentor.firstName}
						${request.connection.mentor.lastName}</a> <%=language.getRequest_mentor()%>
						<a href="field?id=${request.connection.field.fieldID}">${request.connection.field.title}</a></td>
					<td class="span4">
					<!-- 	<div class="btn-group">     -->
							<button class="btn btn-success"
								onclick="answerYes('${table.index}','${request.requestID}')"><%=language.getRequest_accept()%></button>
							<button class="btn btn-danger" onclick="answerNo('${table.index}','${request.requestID}')"><%=language.getRequest_deny()%></button>
						
					</td>
				</tr>			
		
			</c:when>
		</c:choose>
	</c:forEach>
	</table>
</div>
</c:if>
<script>
	function answerYes(id, requestID){
		//document.getElementById(id).innerHTML="Request answered yes, connection established";
		//alert("Answered yes" + requestID);
		var url="answerRequest";
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById(id).innerHTML="<div class=\"alert alert-success\">Request accpected</div>";
			}
		}
		xmlhttp.open("POST", "answerRequest?requestId=" + requestID + "&answer=yes&t=" + Math.random(), true);	
		xmlhttp.send();	
	}
</script>
<script>
	function answerNo(id, requestID){
		//document.getElementById(id).innerHTML="Requst denied";
		//alert("Answered no" + id);
		var url="answerRequest";
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById(id).innerHTML="<div class=\"alert alert-error\">Request denied</div>";
			}
		}
		xmlhttp.open("POST", "answerRequest?requestId=" + requestID + "&answer=no&t=" + Math.random(), true);	
		xmlhttp.send();	
	}
</script>