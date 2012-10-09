package business.search;
 
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class DummyDB {
    private int numUsers;
    private String usersString = "Morten Salte, Thomas Hinna, David Barka, Glenn Falnes, Aleksander Pettersen, Stephan Svendsson, Bartosz";
    private List<String> usersList;
    
    private int numSubjects;
    private String subjectsString = "Ajax, Java, C#, JavaScript, JQuery, Python, C++, C, Objective C, Ruby on Rails";
    private List<String> subjectsList;
    
    public DummyDB() {
        usersList = new ArrayList<String>();
        subjectsList = new ArrayList<String>();
        
        StringTokenizer st;
        st = new StringTokenizer(usersString, ",");
        
        while(st.hasMoreTokens()) {
            usersList.add(st.nextToken().trim());
        }
        
        numUsers = usersList.size();
        
        st = new StringTokenizer(subjectsString, ",");
        
        while(st.hasMoreTokens()) {
        	subjectsList.add(st.nextToken().trim());
        }
        
        numSubjects = subjectsList.size();
        
    }
     
    public List<String> getUsers(String query) {
        String user = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i<numUsers; i++) {
            user = usersList.get(i).toLowerCase();
            if(user.startsWith(query)) {
                matched.add(usersList.get(i));
            }
        }
        return matched;
    }
    
    public List<String> getSubjects(String query) {
    	String subject = null;
    	query = query.toLowerCase();
    	List<String> matched = new ArrayList<String>();
    	for(int i=0;i<numSubjects;i++) {
    		subject = subjectsList.get(i).toLowerCase();
    		if(subject.startsWith(query)) {
    			matched.add(subjectsList.get(i));
    		}
    	}
    	return matched;
    }
}