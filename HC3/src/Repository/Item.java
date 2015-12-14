package Repository;

import java.util.Date;
import Global.FridgeLocation;

public class Item {
	
	private String name="";
	private Category category=new Category("");
	private int countDown=0;
	private boolean countDownIsSet = false;
	private double quantity=-1;
	private String units="";
	private Date bestBefore;
	private String ownerShip="";
	private FridgeLocation location;
	
	private int itemPanelIndex;

	public int getItemPanelIndex() {
		return itemPanelIndex;
	}

	public void setItemPanelIndex(int itemPanelIndex) {
		this.itemPanelIndex = itemPanelIndex;
	}

	public Item(String name){
		this.name=name;
	}
	
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double d) {
		this.quantity = d;
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
	
	public int daysBetween(Date d1, Date d2){
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public FridgeLocation getLocation() {
		return location;
	}

	public void setLocation(FridgeLocation location) {
		this.location = location;
	}
}
