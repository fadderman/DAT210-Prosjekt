<%@ page import="language.*, java.util.HashMap, models.ActiveMenuItem"%>

<% Language language = (Language) session.getAttribute("lang"); %>

<jsp:include page="activemenuitem.jsp"/>

<div>
	<div class="navbar navbar-fixed-top">
	
	<a class="brand" href="home">&nbsp;&nbsp;MentorFind</a>
		<div class="navbar-inner shadow">
			<div class="container">
				<!-- NAVIGATION -->
				<ul class="nav">
					<li class="${activeMenuItem.home}"><a href="home"><i class="icon-home"></i> <%= language.getMenu_home() %></a></li>
					<li class="${activeMenuItem.fields}"><a href="fields"><i class="icon-book"></i> <%=language.getMenu_fields()%></i></a></li>
					<li class="${activeMenuItem.profile}"><a href="profile"><i class="icon-user"></i> <%= language.getMenu_profile() %></a></li>
					<li class="${activeMenuItem.connections}"><a href="connections"><i class="icon-globe"></i> <%= language.getMenu_connections() %></a></li>
					<li><a  href="logout"><i class="icon-off"></i> <%= language.getMenu_logout() %></a></li>
					<li>
						<!-- SEARCH -->
						<form action="search" method="get" class="navbar-form form-search">
							<div class="input-append">
								<input class="search-query span2" type="text" name="query" id="search" placeholder="<%= language.getMenu_search() %>..." />
								<button class="btn" type="submit"><%= language.getMenu_search() %></button>
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
								<b class="icon-th-large" style="margin-right: 2px"></b><small><%=language.getLogin_btn_lang()%></small>
						<span class="caret"></span></a>
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