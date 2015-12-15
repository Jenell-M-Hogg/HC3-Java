package Repository;

import java.util.ArrayList;
import java.util.List;

public class ShopList {
	String name="";
	ArrayList<Item> items;
	
	public ShopList(String name){
		this.name= name;
		this.items=new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void setItems(ArrayList<Item> newItems) {
		this.items=newItems;
		
	}
}
