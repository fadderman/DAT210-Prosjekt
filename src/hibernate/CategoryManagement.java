package hibernate;

import java.util.List;

import models.Category;
import models.Field;

public class CategoryManagement extends HibernateUtil{

	public CategoryManagement() {
		sessionFactory = getSessionFactory();
	}

	public void createCategory(String title, String description){
		createCategory(title, description, null);
	}

	public void createCategory(String title, String description, Field field) {
		Category category = new Category(title, description, field);
		addCategory(category);
	}

	public void addCategory(Category category){
		addToDatabase(category);
	}

	public List<Category> getAllCategories(){
		String queryString = ("from models.Category where active = true"); 
		List<Category> results = fetch(queryString);
		return results;
	}

	public List<Category> getAllInactiveCategories(){
		String queryString = ("from models.Category where active = false"); 
		List<Category> results = fetch(queryString);
		return results;
	}
	
	public Category getByID(int id){
		String queryString = "from models.Category where categoryID = :id";
		String queryVariable = "id";
		return (Category) fetchSingle(queryString, queryVariable, new Integer(id));
	}
	
	public List<Category> getByTitle(String title){
		String queryString = "from models.Category where title = :title";
		String queryVariable = "title";
		return fetch(queryString, queryVariable, title);
	}
	
	public Category getSingleByTitle(String title){
		String queryString = "from models.Category where title = :title";
		String queryVariable = "title";
		return (Category) fetchSingle(queryString, queryVariable, title);
	}

	public void updateTitle(Category category, String newTitle){
		String queryString = "update models.Category set title = :newTitle where id = :id";
		String queryVariable = "newTitle";
		updateSingle(queryString, queryVariable, newTitle, category.getCategoryID());
	}

	public void updateDescription(Category category, String newDescription){
		String queryString = "update models.Category set description = :newDescription where id = :id";
		String queryVariable = "newDescription";
		updateSingle(queryString, queryVariable, newDescription, category.getCategoryID());
	}
	
	public void changeStatus(Category category, boolean active){
		String queryString = "update models.Category set active = :active where id = :id";
		String queryVariable = "active";
		updateSingle(queryString, queryVariable, active, new Integer(category.getCategoryID()));
	}
	
	public List<Field> fetchFieldList(Category category){
		String queryString = "from models.Field where category = :categoryID";
		String queryVariable = "categoryID";
		return fetch(queryString, queryVariable, new Integer(category.getCategoryID()));
	}
	
	/* TODO for testing
	public void toString(List<Category> categories){
		for (Iterator<Category> iterator = categories.iterator(); iterator.hasNext();){
			Category category = (Category) iterator.next(); 
			System.out.println("This has been pulled from the database:");
			System.out.println("Category: " + category.getTitle());
			System.out.println("Description: " + category.getDescription());
			if(category.getFieldList().isEmpty()){
				System.out.println("Field list is empty.");
			} else {
				List<Field> pulledFieldList = category.getFieldList();
				for(Iterator<Field> itS = pulledFieldList.iterator(); itS.hasNext();)
					System.out.println("Field in list: " + itS.next().getTitle());
			}
		}
	}*/
}
