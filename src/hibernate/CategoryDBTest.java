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

		cm.listAllCategories();
		
		List<Category> pulledCats = cm.getCategoryByTitle(catJava);
		for(Iterator<Category> iterator = pulledCats.iterator(); iterator.hasNext();){
			Category current = iterator.next();
			System.out.println("Pulled Category title: " + current.getTitle());
			System.out.println("Pulled Category description: " + current.getDescription());
			if(current.getSubjectList().isEmpty()){
				System.out.println("Subject list is empty.");
			} else {
				List<Subject> currentSubjectList = sm.getSubjectByTitle(current.getSubjectList().get(1));
				System.out.println("First subject in list: " + current.getSubjectList().get(1).); 
			}
				

		}

	}

}
