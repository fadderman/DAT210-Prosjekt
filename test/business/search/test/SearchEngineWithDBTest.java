package business.search.test;

import java.util.ArrayList;

import models.User;
import models.Field;
import business.search.SearchEngine;
import business.search.SearchResults;

public class SearchEngineWithDBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.createDummyData();
		System.out.println("starting");
		SearchResults result = searchEngine.search("alexander");
		ArrayList<User> userRes = result.getUserResults();
		if(!userRes.isEmpty()){
			for(int i = 0;i<userRes.size();i++){
				System.out.println(userRes.get(i).getFirstName() + " " + userRes.get(i).getLastName());
			}
		}
		ArrayList<Field> fieldRes = result.getFieldResults();
		if(!fieldRes.isEmpty()){
			for(int i=0;i<fieldRes.size();i++){
				System.out.println(fieldRes.get(i).getTitle());
			}
		}
	}

}
