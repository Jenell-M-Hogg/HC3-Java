package Repository;

import java.util.ArrayList;

import Global.FridgeType;

public class Fridge {
	
	String name="";
	FridgeType model;
	ArrayList<Item> items;
	
	public Fridge(String name, FridgeType type){
		this.name= name;
		this.model=type;
		this.items=new ArrayList<Item>();
	}
	
	public String returnName(){
		return this.name;
	}
	
	public void setNewName(String newName){
		this.name = newName;
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
