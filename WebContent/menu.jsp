<%@ page import="language.*"%><

<%
	Language language = new Language();
	Cookie[] co = request.getCookies();
	if (co == null) {
		Cookie chosenLanguageCookie = new Cookie("chosenLanguage",
				"english");
		chosenLanguageCookie.setMaxAge(60 * 60 * 24 * 365 * 2); //set its age to 2 years
		chosenLanguageCookie.setPath("/"); //allow the entire application to access it
		response.addCookie(chosenLanguageCookie);
	}
	if (session.getAttribute("lang") != null)
		language = (Language) session.getAttribute("lang");
	//String chosenLanguage = CookieUtil.getCookieValue(co, "chosenLanguage");

	// System.out.println("web: " + chosenLanguage);
	//language.setLanguage(chosenLanguage);
%>
<div class="container">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner shadow">
			<div class="container">
					<a class="brand" href="index.jsp">MentorFind</a>
					<!-- NAVIGATION -->
					<ul class="nav">
						<li><a class="dropdown-toggle" data-toggle="dropdown"
							href="#"><i class="icon-search"></i> Find <i
								class="icon-chevron-down"></i></a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dlabel">
								<!-- dropdown menu links -->
								<li><a href="#"><i class="icon-search"></i> Mentor</a></li>
								<li><a href="#"><i class="icon-search"></i> Trainee</a></li>

							</ul></li>
						<li><a href="#"><i class="icon-user"></i> Profile</a></li>
						<li><a href="#"><i class="icon-cog"></i> Settings</a></li>
						<!-- SEARCH -->
					<form action="search" method="get" class="navbar-form">
						<div class="input-append">
							<input type="text" name="query" id="search"
								placeholder="Search.." />
							<button class="btn" type="submit">Search</button>
						</div>
						<script>
							$("#search").autocomplete("getsearch.jsp");
						</script>
					</form>
					</ul>
	
					
					<!-- LANGUAGE -->
				
				<div class="btn-group pull-right">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"><small>
								<%=language.getLogin_btn_lang()%>
						</small><span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<!-- dropdown menu links -->
							<li><a
								href="<%=response.encodeURL("chosenLanguage?language=english")%>">English</a></li>
							<li><a
								href="<%=response.encodeURL("chosenLanguage?language=norsk")%>">Norsk</a></li>
						</ul>
					</div>
			</div>
		</div>
	</div>
	</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.js"></script>