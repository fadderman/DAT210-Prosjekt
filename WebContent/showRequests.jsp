<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java"
	import="models.Request,models.Connection,models.*,hibernate.*, java.util.ArrayList, business.connection.RequestHandler"%>
<%
	//ConnectionManagement connectionManager = new ConnectionManagement();
	RequestManagement requestManager = new RequestManagement();
	UserManagement userManagement = new UserManagement();
	/*User currentUser = new User("Thomas", "Hinna", "email", "city", "Norge", "testIdentifier");
=======
	User currentUser = new User("Thomas", "Hinna", "email", "city", "Norge", "testIdentifier");
>>>>>>> 1f2712cfd6576c7d1ca32e5dfee911b271dff8dd
	userManagement.addUser(currentUser);
	User wannabeTrainee = new User("Nils", "Pettersen", "email", "Oslo", "Norge", "OpenID2");
	userManagement.addUser(wannabeTrainee);
	Field java = new Field("Java", "Yes, this is java");
	Field cSharp = new Field("C#", "Yes, this is C#");
	FieldManagement fieldManager = new FieldManagement();
	fieldManager.addField(java);
	fieldManager.addField(cSharp);
	Connection connection = new Connection(java);
	connection.setTrainee(wannabeTrainee);
	connectionManager.addConnection(connection);
	Connection connection2 = new Connection(cSharp);
	connection2.setMentor(wannabeTrainee);
	connectionManager.addConnection(connection2);
	requestManager.createRequest(currentUser, connection, true);
	requestManager.createRequest(currentUser, connection2, false);
<<<<<<< HEAD
	*/
	User currentUser = userManagement.getByOpenId("testIdentifier");
	
	//User currentUser = userManagement.getByOpenId("testIdentifier");
	ArrayList<Request> requests = (ArrayList<Request>)requestManager.getRequestByUserID(currentUser.getUserID());
	pageContext.setAttribute("requests", requests);	
	pageContext.setAttribute("hasRequests", !requests.isEmpty());
	%>
<c:if test="${hasRequests eq true}">

<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
	<h4>You have request(s)</h4>
	<table class="table table-hover">
	<c:forEach var="request" items="${requests}" varStatus="table">
		<c:choose>
			<c:when test="${request.traineeRequest eq true}">

				<tr id="${table.index}">
						<td class="span6">${request.connection.trainee.firstName}
							${request.connection.trainee.lastName} wants to be your trainee in
							${request.connection.field.title}
						</td>
						<td class="span4">
								<button class="btn btn-success"
									onclick="answerYes('${table.index}','${request.requestID}')">Accept</button>
								<button class="btn btn-danger" onclick="answerNo('${table.index}','${request.requestID}')">Deny</button>
							
						</td>
					</tr>

			</c:when>
			<c:when test="${request.traineeRequest eq false}">
				<tr id="${table.index}">
					<td class="span6">${request.connection.mentor.firstName}
						${request.connection.mentor.lastName} wants to be your mentor in
						${request.connection.field.title}</td>
					<td class="span4">
					<!-- 	<div class="btn-group">     -->
							<button class="btn btn-success"
								onclick="answerYes('${table.index}','${request.requestID}')">Accept</button>
							<button class="btn btn-danger" onclick="answerNo('${table.index}','${request.requestID}')">Deny</button>
						
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
				document.getElementById(id).innerHTML="Request answered yes, connection in DB";
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
				document.getElementById(id).innerHTML="Request denied";
			}
		}
		xmlhttp.open("POST", "answerRequest?requestId=" + requestID + "&answer=no&t=" + Math.random(), true);	
		xmlhttp.send();	
	}
</script>