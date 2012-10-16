<%@page import="business.search.SearchEngine,business.search.UserSuggestion,java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="business.search.SearchSuggestions"%>
<%
	SearchEngine engine = new SearchEngine();
	engine.createDummyData();
	
    String query = (String) request.getParameter("q");
    //System.out.println(query);
    
    SearchSuggestions suggestions = engine.suggest(query);
    ArrayList<UserSuggestion> userSuggestions = suggestions.getUserResults();
 
    for(int i=0;i<userSuggestions.size();i++) {
    	String suggestion = "";
    	
    	suggestion += userSuggestions.get(i).getFirstname();
    	suggestion += " ";
    	suggestion += userSuggestions.get(i).getLastname();
    	out.println(suggestion);
    	//out.println(userResult + " (User)");
    	//out.println("<i class='icon-user'></i> " + userResult);
    }
%>