<%@page import="business.search.SubjectSuggestion"%>
<%@ page language="java" contentType="text/html"%>
<%@page import="business.search.SearchEngine,business.search.UserSuggestion,java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="business.search.SearchSuggestions"%>

<%
	SearchEngine engine = new SearchEngine();
	engine.createDummyData();
	
    String query = (String) request.getParameter("q").toLowerCase();
    
	// temporary solution for norwegian letters
    query = query.replaceAll("у╕", "°");
    query = query.replaceAll("уж", "ц");
    query = query.replaceAll("уе", "х");
    System.out.println(query);
    
    SearchSuggestions suggestions = engine.suggest(query);
    ArrayList<UserSuggestion> userSuggestions = suggestions.getUserSuggestions();
 
    for(int i=0;i<userSuggestions.size();i++) {
    	String suggestion = "";
    	
    	suggestion += userSuggestions.get(i).getFirstname();
    	suggestion += " ";
    	suggestion += userSuggestions.get(i).getLastname();
    	out.println(suggestion);
    	
    	//out.println(userResult + " (User)");
    	//out.println("<i class='icon-user'></i> " + userResult);
    }
    ArrayList<SubjectSuggestion> subjectSuggestions = suggestions.getSubjectSuggestions();
    for(int i=0;i<subjectSuggestions.size();i++){
    	out.println(subjectSuggestions.get(i).getTitle());
    }
    
    
%>