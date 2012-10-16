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
<!-- top menu -->
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar">
			<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img alt="" src="img/logo_mini.png" ></a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle btn-inverse btn-large" data-toggle="dropdown"
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
	</div>
	<div class="padding"></div>

</body>
</html>