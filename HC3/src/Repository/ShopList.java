package Repository;

import java.util.ArrayList;
import java.util.List;

public class ShopList {
	private String name="";
	private List<Item> shopListItems = new ArrayList<Item>();
	
	public List<Item> getShopListItems() {
		return shopListItems;
	}

	public void setShopListItems(List<Item> shopListItems) {
		this.shopListItems = shopListItems;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addItem(Item item) {
		shopListItems.add(item);
	}
	
	public void removeItem(Item item) {
		shopListItems.remove(item);
	}
	
	public ShopList(String name){
		this.name= name;
	}
}
