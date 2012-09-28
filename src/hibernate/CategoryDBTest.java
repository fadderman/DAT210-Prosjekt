package hibernate;

import models.Category;
import models.Subject;

public class CategoryDBTest {


	public static void main(String[] args) {
		
		CategoryManagement cm = new CategoryManagement();
		Category catJava = new Category("Java", "THIS IS JAVAAAAA");
		Category catCsharp = new Category("C#", "Kinda like Java but not really");
		
		cm.addCategory(catJava);
		cm.addCategory(catCsharp);

		cm.listAllCategories();
		
		Category pulledCat = cm.getCategory("Java");
		System.out.println("Pulled Category title: " + pulledCat.getTitle());
		System.out.println("Pulled Category description: " + pulledCat.getDescription());
		if(pulledCat.getSubjectList().isEmpty()){
			System.out.println("Subject list is empty.");
		} else
		System.out.println("First subject in list: " + pulledCat.getSubjectList().get(1).getTitle());

	}

}
