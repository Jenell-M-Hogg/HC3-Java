package Repository;

import java.util.Date;
import Global.FridgeLocation;

public class Item {
	
	private String name="";
	private Category category=new Category();
	private int countDown=0;
	private boolean countDownIsSet = false;
	private int quantity=-1;
	private String units="";
	private Date bestBefore;
	private String ownerShip="";
	private FridgeLocation location;

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCountDown() {
		return countDown;
	}

	public void setCountDown(int countDown) {
		this.countDown = countDown;
	}
	
	public boolean getCountDownIsSet() {
		return countDownIsSet;
	}
	
	public void setCountDownIsSet(boolean countDownIsSet) {
		this.countDownIsSet = countDownIsSet;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Date getBestBefore() {
		return bestBefore;
	}

	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}

	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(String name){
		this.name=name;
	}
	
	

}
