package hibernate;

import java.util.ArrayList;
import java.util.Iterator;

import models.Category;
import models.Connection;
import models.Subject;
import models.User;

public class CategoryDBTest {


	public static void main(String[] args) {
		
		CategoryManagement cm = new CategoryManagement();
		SubjectManagement sm = new SubjectManagement();
		UserManagement um = new UserManagement();
		ConnectionManagement xm = new ConnectionManagement();
		
		Category catJava = new Category("Java", "THIS IS JAVAAAAA");
		Category catCsharp = new Category("C#", "Kinda like Java but not really");
		Category catCplus = new Category("C++", "Cplusplus");
		Category catJavaScript = new Category("JavaScript", "Programming language for adding dynamic elements in websites");
		Category catPython = new Category("Python", "Programming language, often used as scripting language");
		Category catPerl = new Category("Perl", "Programming language");
		
		cm.addCategory(catJava);
		cm.addCategory(catCsharp);
		cm.addCategory(catCplus);
		
		Subject subJava3D = new Subject("Java 3D", "Old 3D graphics API for n00bs", cm.getByTitle("Java").get(0));
		Subject subJava2D = new Subject("Java 2D", "2D Java graphics API", cm.getByTitle("Java").get(0));
		
		Subject subCSh1 = new Subject("C# subject 1", "C# for everybody", cm.getByTitle("C#").get(0));
		Subject subCSh2 = new Subject("C#", "C# for extreme", cm.getByTitle("C#").get(0));
		Subject subCSh3 = new Subject("C#","C# General",cm.getByTitle("C#").get(0));
		Subject subCpluss = new Subject("C++","C++ General",cm.getByTitle("C++").get(0));
		
		sm.addSubject(subJava3D);
		sm.addSubject(subJava2D);
		sm.addSubject(subCSh1);
		sm.addSubject(subCSh2);
		sm.addSubject(subCSh3);
		sm.addSubject(subCpluss);
		
		User user1 = new User("Bob", "Smith", "bob@smith.com", "here", "345678");
		User user2 = new User("Glen", "Smiths", "basdfg@smith.com", "there", "2323");
		User user3 = new User("Tom", "Smite", "bob@adrbafd.com", "over here", "7865425");
		User user4 = new User("Alex", "Smile", "bob@6ytghj.com", "over there", "456412");
		User user5 = new User("Dave", "Store", "bob@adfbafv.com", "here", "34898745");
		User user6 = new User("John", "Robertson", "65tghj@smith.com", "here", "3893564");
		
		um.addUser(user1);
		xm.createOpenMentor(user1, subCSh3);
		xm.createOpenMentor(user1, subJava2D);
		xm.createOpenTrainee(user1, subCpluss);
		xm.createOpenTrainee(user1, subJava3D);
		
		um.addUser(user2);
		xm.createOpenMentor(user2, subCSh2);
		xm.createOpenMentor(user2, subJava3D);
		xm.createOpenMentor(user2, subJava3D);
		
		um.addUser(user3);
		xm.createOpenTrainee(user3, subCpluss);
		xm.createOpenTrainee(user3, subJava2D);
		
		um.addUser(user4);
		xm.createOpenMentor(user4, subCpluss);
		
		um.addUser(user5);
		xm.createOpenMentor(user5, subCpluss);
		xm.createOpenMentor(user5, subJava3D);
		xm.createOpenTrainee(user5, subCSh1);
		
		um.addUser(user6);
		xm.createOpenMentor(user6, subJava2D);
		xm.createOpenTrainee(user6, subJava3D);

		
		
		cm.getAllCategories();
		
		cm.updateTitle(cm.getSingleByTitle("C#"), "C sharp");
		cm.updateDescription(cm.getSingleByTitle("C sharp"), "Cminusminus");
		
		System.out.println("-----------------------------------------------");
		
		cm.getAllCategories();
		
		System.out.println("-----------------------------------------------");
		System.out.println(sm.getSingleByTitle("Java 3D").getCategory().getTitle());
		
		System.out.println("-----------------------------------------------");
		
		ArrayList<User> mentorTestList = (ArrayList<User>) sm.getByMentorConnection(subCpluss);
		if(mentorTestList.isEmpty()){
			System.out.println("EMPTY");
		}
		for(Iterator<User> iterator = mentorTestList.iterator(); iterator.hasNext();){


			User current = iterator.next();
			System.out.println(current.getFirstName() + " " + current.getLastName());
		}
		
	}
}
