<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="language.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="language.jsp" />

<%
	Language language = (Language) session.getAttribute("lang");
%>

<!-- top menu -->
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar">
			<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img alt="" src="img/logo_mini.png" ></a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle btn-inverse btn-large" data-toggle="dropdown"
						href="#"><b class="icon-white icon-th-large" style="margin-right: 2px"></b><small><%=language.getLogin_btn_lang() %> </small><span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<!-- dropdown menu links -->
						<li><a href="<%=response.encodeURL("chosenLanguage?language=english")%>">English</a></li>
						<li><a href="<%=response.encodeURL("chosenLanguage?language=norsk")%>">Norsk</a></li>
					</ul>
				</div>
			</div>
			</div>
		</div>
	</div>
	<div class="padding"></div>

</body>
</html>