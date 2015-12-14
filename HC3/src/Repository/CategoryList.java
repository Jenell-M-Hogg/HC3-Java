package Repository;

import java.util.ArrayList;

public class CategoryList {
	private static final CategoryList instance = new CategoryList();
	ArrayList<Category> list;

	private CategoryList() {
		list = new ArrayList<Category>();
		list.add(new Category("Default"));
		list.add(new Category("Fruits"));
	}
	
	public static CategoryList getInstance() {
		return instance;
	}
	
	public ArrayList<Category> getCategories() {
		return instance.list;
	}

	public void setCategories(ArrayList<Category> list) {
		instance.list = list;
	}
	
	public void addCategory(Category category){
		list.add(category);
	}
	
	public void removeCategory(Category category) {
		list.remove(category);
	}
}
