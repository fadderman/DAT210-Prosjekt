<%@page import="business.search.SearchEngine,business.search.UserResult,java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="business.search.SearchResult"%>
<%
 	SearchEngine engine = new SearchEngine();
	engine.createDummyData();
	
    String query = (String) request.getParameter("q");
    //System.out.println(query);
    
    SearchResult result = engine.search(query);
    ArrayList<UserResult> userResults = result.getUserResults();
 
    for(int i=0;i<userResults.size();i++) {
    	String userResult = "";
    	
    	userResult += userResults.get(i).getFirstname();
    	userResult += " ";
    	userResult += userResults.get(i).getLastname();
    	out.println(userResult);
    	//out.println(userResult + " (User)");
    	//out.println("<i class='icon-user'></i> " + userResult);
    }
%>