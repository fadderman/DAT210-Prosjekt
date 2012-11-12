<%@ page import="language.*"%>
<%
	Language language = new Language();

	Cookie[] currentCookies = request.getCookies();
	
	String chosenLanguageString = "";
	if(currentCookies != null) {
		chosenLanguageString = CookieUtil.getCookieValue(currentCookies, "chosenLanguage");
	}
	
	if(!chosenLanguageString.equals("")) {
		language.setLanguage(chosenLanguageString);
	} else {
		Cookie languageCookie = new Cookie("chosenLanguage", "english");
		languageCookie.setMaxAge(60*60*24*365*2); // 2 years
		languageCookie.setPath("/"); // enable for entire application
		response.addCookie(languageCookie);
	}
	
	if(session.getAttribute("lang") != null) language = (Language) session.getAttribute("lang");
	
	session.setAttribute("lang", language);
%>