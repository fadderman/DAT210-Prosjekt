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
		
		cm.getAllCategories();
		
		cm.updateTitle(cm.getSingleByTitle("C#"), "C sharp");
		cm.updateDescription(cm.getSingleByTitle("C sharp"), "Cminusminus");
		
		System.out.println("-----------------------------------------------");
		
		cm.getAllCategories();
		
		System.out.println("-----------------------------------------------");
		System.out.println(sm.getSingleByTitle("Java").getCategory().getTitle());
	}
}
