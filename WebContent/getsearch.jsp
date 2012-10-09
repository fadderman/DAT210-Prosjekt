<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="business.search.DummyDB"%>
<%
	DummyDB db = new DummyDB();
 
    String query = request.getParameter("q");
     
    List<String> userResults;
    List<String> subjectResults;
    
    userResults = db.getUsers(query);
 
    for(int i=0;i<userResults.size();i++) {
    	String userResult = userResults.get(i);
    	out.println(userResult);
    	//out.println("<i class='icon-user'></i> " + userResult);
    }
    
    subjectResults = db.getSubjects(query);
    
    for(int i=0;i<subjectResults.size();i++) {
    	String subjectResult = subjectResults.get(i);
    	out.println(subjectResult);
    	//out.println("<i class='icon-book'></i> " + subjectResult);
    }
%>