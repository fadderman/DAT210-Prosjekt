<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="models.Field, language.*"%>

<%
	Field field = (Field) request.getAttribute("field");
	
	boolean nullField = false;
	if(field == null) nullField = true;
	
	pageContext.setAttribute("field", field);
	pageContext.setAttribute("nullField", nullField);
	
	Language language = (Language) session.getAttribute("lang");
%>

<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">


	<c:choose>
		<c:when test="${nullField eq true}">
			<div class="alert alert-error">
				Given field does not exist or the given argument is invalid. Please try again.
			</div>
		</c:when>
		<c:otherwise>
			<div class="row-fluid">
				<div class="span12"><i class="icon-book"></i><legend>${field.title}</legend></div>
			</div>
			
			<div class="row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<div class="span3"><b><%=language.getSearch_title()%> </b></div>
						<div class="span9">${field.title}</div>
					</div>
					<div class="row-fluid">
						<div class="span3"><b><%=language.getSearch_description()%> </b></div>
						<div class="span9">${field.description}</div>
					</div>
				</div>
			</div>
			
			<p style="margin-top: 50px" />
			
			<div class="row-fluid">
				<div class="span3"><i class="icon-search"></i><legend><%=language.getFields_findIn()%></legend></div>
			</div>
			
			<div class="row-fluid">
				<div class="span3">
					<div class="row-fluid">
						<div class="span6" align="center"><a class="btn btn-primary" type="submit" href="#showMentorList" data-toggle="modal">Mentor</a></div>
						<div class="span6" align="center"><a class="btn btn-primary" type="submit" href="#showTraineeList" data-toggle="modal">Trainee</a></div>
					</div>
				</div>
			</div>	
		</c:otherwise>
	</c:choose>
	<jsp:include page="findMentor.jsp"></jsp:include>
	<jsp:include page="findTrainee.jsp"></jsp:include>
</div>
