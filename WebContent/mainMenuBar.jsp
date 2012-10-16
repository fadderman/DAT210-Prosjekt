<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="language.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	Language language = new Language();
    Cookie[] co = request.getCookies();
    if(co == null){
    	Cookie chosenLanguageCookie = new Cookie("chosenLanguage", "english");
		chosenLanguageCookie.setMaxAge(60*60*24*365*2); //set its age to 2 years
		chosenLanguageCookie.setPath("/"); //allow the entire application to access it
		response.addCookie(chosenLanguageCookie);
    }
    if(session.getAttribute("lang") != null)
    	language = (Language)session.getAttribute("lang");
    //String chosenLanguage = CookieUtil.getCookieValue(co, "chosenLanguage");
  
	
   // System.out.println("web: " + chosenLanguage);
    //language.setLanguage(chosenLanguage);
    
%>

<div class="container">
		<!-- top menu -->
		<br />

		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner shadow">
			<div class="container">
				<a class="brand" href="#"></i>MentorFind</a>
				<ul class="nav">
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i
							class="icon-user"></i> Profile <i class="icon-chevron-down"></i></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dlabel">
							<!-- dropdown menu links -->
							<li class="active"><a href="#"><i class="icon-home"></i> Home</a></li>
							<li><a href="#"><i class="icon-wrench"></i> Preferences</a></li>
							<li><hr></li>
							<li><a href="logIn.html"><i class="icon-off"></i> Log out</a></li>
						</ul></li>
				</ul>
				<form class="navbar-search form-inline">
					<input type="text" class="search-query" placeholder="Search">
				</form>
				<div class="btn-group pull-right form-inline">
					<a class="btn dropdown-toggle" data-toggle="dropdown"
						href="#"><small> <%=language.getLogin_btn_lang() %> </small><span class="caret"></span>
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
			<div class="padding"></div>

</body>
</html>