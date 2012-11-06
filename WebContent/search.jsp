<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Search</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.catcomplete.css" />
    
    <script type="text/javascript" src="js/bootstrap.js"></script>    
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

</head>
<body>

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
	        minLength: 0,
	        source: 'getsearchjson.jsp'
	    });
	});
</script>

<p />

<div class="container well">
	<div class="row-fluid">
		<form action="search" method="get">
			<div class="input-append">
				<input type="text" name="query" id="search" placeholder="Search.."/>
				<button class="btn" type="submit">Search</button>
			</div>

		</form>
	</div>
</div>

</body>
</html>