package business.search;

import hibernate.FieldManagement;
import hibernate.HibernateUtil;
import hibernate.SubjectManagement;
import hibernate.UserManagement;

import java.util.ArrayList;
import java.util.List;

import models.Field;
import models.Subject;
import models.User;
import business.subject.SubjectHandler;
import business.user.UserHandler;

public class SearchEngine extends HibernateUtil{

	UserManagement userManager = new UserManagement();
	FieldManagement fieldManagment = new FieldManagement();
	SubjectManagement subMang = new SubjectManagement();
	
	public SearchEngine(){
		sessionFactory = getSessionFactory();
	}
	
	private static boolean hasBeenRun = false;
	public void createDummyData(){
		if(!hasBeenRun){
			userManager.addUser(new User("Thomas", "Hinna", "email", "Sandnes", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Thomas", "Nilsen", "email", "Liverpool", "United Kingdom", "identifierOpenID"));
			userManager.addUser(new User("Morten", "Salte", "email", "Lyefjell", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Steve", "Jobs", "email", "Silicon Valley", "USA", "identifierOpenID"));
			userManager.addUser(new User("Anders", "Mikkelsen", "email", "Bergen", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Bill", "Gates", "email", "Silicon Valley", "USA", "identifierOpenID"));
			userManager.addUser(new User("Morten", "Nilsen", "email", "Oslo", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Petter", "Salte", "email", "Stockholm", "Sweden", "identifierOpenID"));
			userManager.addUser(new User("Alexander", "Rybak", "email", "Oslo", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Åge", "Alexandersen", "email", "Stavanger", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Ørjan", "Rørheim", "email", "Stavanger", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Åge", "Håland", "email", "Ålesund", "Norway", "identifierOpenID"));
			userManager.addUser(new User("Tom", "Nærland", "email", "Nærbø", "Norway", "identifierOpenID"));

			/*Subject sub = new Subject("titleeee", "descpritionnnn");
			subMang.addSubject(sub);
			fieldManagment.addField(new Field("Java", "description", sub));
			fieldManagment.addField(new Field("JavaScript", "description", sub));
			fieldManagment.addField(new Field("C++", "description", sub));
			fieldManagment.addField(new Field("C#", "description", sub));
			fieldManagment.addField(new Field("Python", "description", sub));
			fieldManagment.addField(new Field("Go", "description", sub));
			fieldManagment.addField(new Field("C", "description", sub));
			fieldManagment.addField(new Field("MySQL", "description", sub));
			hasBeenRun=true;
			*/
		}
	}

	public SearchResults search(String query){
		query = query.toLowerCase();
		query = query.trim();
		SearchResults results = new SearchResults();
		results.setUserResults(searchForUsers(query));
		results.setFieldResults(searchForFields(query));
		return results;
	}

	private ArrayList<User> searchForUsers(String query){
		ArrayList<User> userResults = searchForUsersUsingString(query);
		return userResults;
	}
	
	private String addPercentagesToString(String string){
		string="%" + string;
		string = string + "%";
		return string;
	}
	
	private ArrayList<User> searchForUsersUsingString(String query) {
		List<User> userResults;
		if(query.contains(" ")){
			List<String> queryVariables = new ArrayList<String>();
			List<Object> criterias = new ArrayList<Object>();
			String firstQuery = query.substring(0, query.lastIndexOf(" "));
			String lastQuery = query.substring(query.lastIndexOf(" ")+1);
			firstQuery = addPercentagesToString(firstQuery);
			lastQuery = addPercentagesToString(lastQuery);
			query = addPercentagesToString(query);
			criterias.add(query);
			criterias.add(query);
			criterias.add(firstQuery);
			criterias.add(lastQuery);			
			String queryString = "from models.User where (firstName like :query1 or lastName like :query2 and active = true) " + 
			"or (firstName like :firstQuery and lastName like :lastQuery and active = true)";
			String queryVariable1 = "query1";
			String queryVariable2 = "query2";
			String queryVariable3 = "firstQuery";
			String queryVariable4 = "lastQuery";
			queryVariables.add(queryVariable1);
			queryVariables.add(queryVariable2);
			queryVariables.add(queryVariable3);
			queryVariables.add(queryVariable4);
			userResults =multiFetch(queryString, queryVariables, criterias);
		}else{
			query=addPercentagesToString(query);
			String queryString = "from models.User where (firstName like :query or lastName like :query and active = true)";
			String queryVariable1 = "query";
			userResults =fetch(queryString, queryVariable1, query);
		}
		return (ArrayList<User>)userResults;
	}
	
	private ArrayList<Field> searchForFields(String query) {
		ArrayList<Field> fieldtResults=searchForFieldUsingString(query);
		return fieldtResults;
	}

	
	private ArrayList<Field> searchForFieldUsingString(String query) {
		List<Field> fieldResults;
		query=addPercentagesToString(query);
		String queryString = "from models.Field where title like :query and active = true";
		String queryVariable1 = "query";
		fieldResults =fetch(queryString, queryVariable1, query);
		return (ArrayList<Field>)fieldResults;
	}	

}
