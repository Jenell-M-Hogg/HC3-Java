package Repository;

public class Category {
	private String name="";
	private String iconLocation="/images/DefaultCategoryIcon.png";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIconLocation() {
		switch (name) {
		case "Fruits":
			iconLocation = "/images/Fruit.svg.png";
			break;
		default:
			iconLocation="/images/DefaultCategoryIcon.png";
		}
		return iconLocation;
	}
}
