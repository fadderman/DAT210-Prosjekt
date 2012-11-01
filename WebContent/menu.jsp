<<<<<<< HEAD
<%@ page import="language.*, java.util.HashMap, models.ActiveMenuItem"%>

<%
	Language language = new Language();
	
	if(CookieUtil.getCookieValue(request.getCookies(), "chosenLanguage").equals("")){
		Cookie chosenLanguageCookie = new Cookie("chosenLanguage",
				"english");
		chosenLanguageCookie.setMaxAge(60 * 60 * 24 * 365 * 2); //set its age to 2 years
		chosenLanguageCookie.setPath("/"); //allow the entire application to access it
		response.addCookie(chosenLanguageCookie);
	}
	else
		language.setLanguage(CookieUtil.getCookieValue(request.getCookies(), "chosenLanguage"));
	if (session.getAttribute("lang") != null)
		language = (Language) session.getAttribute("lang");
%>

<jsp:include page="activemenuitem.jsp"/>

=======
<%@ page import="language.*" %>
<%Language language = (Language)session.getAttribute("lang"); %>
>>>>>>> 2d92f4c1e295fe958f1bac46fecab85de9636e8f
<div class="container">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner shadow">
			<div class="container">

				<a class="brand" href="home">MentorFind</a>
				<!-- NAVIGATION -->
				<ul class="nav">
<<<<<<< HEAD
					<li class="${activeMenuItem.home}"><a href="home"><i class="icon-home"></i> Home</a></li>
					<li class="${activeMenuItem.find}"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="icon-search"></i> Find <i class="icon-chevron-down"></i></a>
=======
					<li class="active"><a href="home"><i class="icon-home"></i>
							<%=language.getMenu_home() %></a></li>
				<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="icon-search"></i> <%=language.getMenu_find() %> <i class="icon-chevron-down"></i>
								</a>
>>>>>>> 2d92f4c1e295fe958f1bac46fecab85de9636e8f
						<ul class="dropdown-menu" role="menu" aria-labelledby="dlabel">
							<!-- dropdown menu links -->
							<li><a href="#"> Mentor</a></li>
							<li><a href="#"> Trainee</a></li>
						</ul>
<<<<<<< HEAD
					</li>
					<li class="${activeMenuItem.profile}"><a href="profile"><i class="icon-user"></i> Profile</a></li>
					<li class="${activeMenuItem.settings}" style="margin-right: 15px"><a href="settings"><i class="icon-cog"></i> Settings</a></li>
					
=======
				</li>
					<li><a href="profile"><i class="icon-user"></i> <%=language.getMenu_profile() %></a></li>
					<li><a href="settings"><i class="icon-cog"></i> <%=language.getMenu_settings() %></a></li>
>>>>>>> 2d92f4c1e295fe958f1bac46fecab85de9636e8f
					<li>
						<!-- SEARCH -->
						<form action="search" method="get" class="navbar-form form-search">
							<div class="input-append">
								<input class="search-query" type="text" name="query" id="search" placeholder="<%=language.getMenu_search() %>..." />
								<button class="btn" type="submit"><%=language.getMenu_search() %></button>
							</div>
							<script>
								$.widget( "custom.catcomplete", $.ui.autocomplete, {
								    _renderMenu: function( ul, items ) {
								        var that = this,
								            currentCategory = "";
								        $.each( items, function( index, item ) {
								            if ( item.category != currentCategory ) {
								                ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
								                currentCategory = item.category;
								            }
								            that._renderItemData( ul, item );
								        });
								    }
								});
							</script>
		
							<script type="text/javascript">
								$(function() {
								    $( "#search" ).catcomplete({
								        delay: 500,
								        minLength: 1,
								        source: 'getsearchjson.jsp'
								    });
								});
							</script>
						</form>
					</li>
				</ul>
				<!-- LANGUAGE -->
				
				<div class="btn-group pull-right">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<%=language.getLogin_btn_lang()%>
						<span class="caret"></span> </a>
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