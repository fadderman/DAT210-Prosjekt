<%@ page import="language.*" %>
<%Language language = (Language)session.getAttribute("lang"); %>
<div class="container well" style="box-shadow: 5px 5px 8px -1px #222;">
<i class="icon-home"></i><legend><%=language.getHome_welcome() %></legend>
<p><%=language.getHome_please_search() %></p>
</div>
<%session.setAttribute("CurrentPage", "/index.jsp"); %>