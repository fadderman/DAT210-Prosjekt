package hibernate;

import java.util.Iterator;
import java.util.List;

import models.Category;
import models.Subject;
import models.User;

public class CategoryDBTest {


	public static void main(String[] args) {
		
		CategoryManagement cm = new CategoryManagement();
		SubjectManagement sm = new SubjectManagement();
		Category catJava = new Category("Java", "THIS IS JAVAAAAA");
		Category catCsharp = new Category("C#", "Kinda like Java but not really");
		
		cm.addCategory(catJava);
		cm.addCategory(catCsharp);
		
		Subject subJava3D = new Subject("Java 3D", "Old 3D graphics API for n00bs", cm.getByTitle("Java").get(0));
		Subject subJava2D = new Subject("Java 2D", "2D Java graphics API", cm.getByTitle("Java").get(0));
		
		Subject subCSh1 = new Subject("C# subject 1", "C# for everybody", cm.getByTitle("C#").get(0));

		sm.addSubject(subJava3D);
		sm.addSubject(subJava2D);
		sm.addSubject(subCSh1);
		
		cm.listAllCategories();
		
		/*
		List<Category> pulledCats = cm.getByTitle(catJava.getTitle());
		for(Iterator<Category> iterator = pulledCats.iterator(); iterator.hasNext();){
			Category current = iterator.next();
			System.out.println("Pulled Category title: " + current.getTitle());
			System.out.println("Pulled Category description: " + current.getDescription());
			if(current.getSubjectList().isEmpty()){
				System.out.println("Subject list is empty.");
			} else {
				List<Subject> currentSubjectList = sm.getSubjectByTitle(current.getSubjectList().get(1)); //TODO something's wrong here..
				System.out.println("First subject in list: " + currentSubjectList.get(1).getTitle()); 
			}
		}
		*/

	}

}
