<%@ page import="models.ActiveMenuItem" %>
<%

/*
	This file determines which menu item should be set to active in menu.jsp
	
	To utilize this set an attribute by the name of "active" on the request object 
	in your servlet before forwarding.
	
	Example:
		
		request.setAttribute("active", "home")
		
	This will set the "Home" item in the menu as active, all other items will be reset
*/
	ActiveMenuItem activeMenuItem = new ActiveMenuItem();
	
	String active = (String) request.getAttribute("active");
	
	if(active != null) {
		if(active.equals("home")) {
			activeMenuItem.setHome();
		} else if(active.equals("find")) {
			activeMenuItem.setFind();
		} else if(active.equals("profile")) {
			activeMenuItem.setProfile();
		} else if(active.equals("settings")) {
			activeMenuItem.setSettings();
		} else {
			activeMenuItem.setHome();
		}
	}
	
	
	session.setAttribute("activeMenuItem", activeMenuItem);
%>