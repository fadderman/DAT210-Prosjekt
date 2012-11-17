<%@ page import="language.*, java.util.ArrayList, models.Field, business.sort.*, java.util.Collections" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" %>
<%

	Language language = (Language)session.getAttribute("lang");
	
	ArrayList<Field> allFields = (ArrayList<Field>) request.getAttribute("allFields");
	Collections.sort(allFields, new FieldComparator());
	
	String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	
	pageContext.setAttribute("alphabet", alphabet);
	pageContext.setAttribute("allFields", allFields);

%>
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
<legend><%=language.getFields_header() %></legend>
<p><%=language.getFields_welcome() %></p>
<p>
<% for(int i=0;i<alphabet.length;i++) { %>
	<a href="#<%=alphabet[i]%>"><%= alphabet[i] %></a>&nbsp;
<% } %>
</p>
<table class="table table-hover">
	<thead>
	<tr>
		<th><%= language.getSearch_title() %></th>
		<th><%= language.getSearch_description() %></th>
	</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<allFields.size();i++) { %>
	<tr>
		<td><a name="<%=allFields.get(i).getTitle().charAt(0)%>" href="field?id=<%=allFields.get(i).getFieldID()%>"><%=allFields.get(i).getTitle()%></a></td>
		<td><%=allFields.get(i).getDescription()%></td>
	</tr>
	
	<% } %>
	</tbody>
	
</table>

</div>