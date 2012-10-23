<div class="container">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner shadow">
			<div class="row-fluid">
				<div class="span8">
				<a class="brand" href="home">MentorFind</a>
					<!-- NAVIGATION -->
					<ul class="nav">
						<li class="active"><a href="home"><i class="icon-home"></i> Home</a></li>
						<li><a href="#"><i class="icon-search"></i> Find Mentor</a></li>
						<li><a href="#"><i class="icon-search"></i> Find Trainee</a></li>
						<li><a href="profile"><i class="icon-user"></i> Profile</a></li>
						<li><a href="settings"><i class="icon-cog"></i> Settings</a></li>
					</ul>
				</div>
				<div class="span3">
				<!-- SEARCH -->
					<form action="search" method="get" class="navbar-form pull-right">
						<div class="input-append">
							<input type="text" name="query" id="search" placeholder="Search.."/>
							<button class="btn" type="submit">Search</button>
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
				</div>
				<div class="span1">
					<!-- LANGUAGE -->
					<div class="btn-group pull-right form-inline">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							Language
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>Norwegian</li>
							<li>English</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>