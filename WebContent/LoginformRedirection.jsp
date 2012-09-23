<%@page import="java.util.Map,java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OpenID HTML FORM Redirection</title>
</head>
<body>
<!--<body onload="document.forms['openid-form-redirection'].submit();"> -->
<body> 

  <form name="openid-form-redirection" action="<%= request.getAttribute("destinationUrl") %>" method="post" accept-charset="utf-8"> 
	<% 
	                Map pm=request.getParameterMap(); 
	                Iterator keyit=pm.keySet().iterator(); 
	
	                Object key; 
	                Object value; 
	
	                while (keyit.hasNext()) 
	                { 
	                    key=keyit.next(); 
	                    value=pm.get(key); 
	            %> 
	        <input type="hidden" name="<%= key%>" value="<%= value%>"/> 
	        <% 
	                } 
	        %> 
	        <button type="submit">Continue...</button> 
	    </form>
	</body>
</html>