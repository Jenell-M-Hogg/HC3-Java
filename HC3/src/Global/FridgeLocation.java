package Global;

public enum FridgeLocation {

	FREEZER_TOP,
	FREEZER_BOTTOM,
	FREEZER_DOOR,
	TOP_SHELF,
	MIDDLE_SHELF,
	BOTTOM_SHELF,
	CRISPER_RIGHT,
	CRISPER_LEFT,
	DOOR_TOP,
	DOOR_MIDDLE,
	DOOR_BOTTOM;
	
	public static String[] names() {
	    FridgeLocation[] fridgeLocations = values();
	    String[] names = new String[fridgeLocations.length];

	    for (int i = 0; i < fridgeLocations.length; i++) {
	        names[i] = fridgeLocations[i].name();
	    }

	    return names;
	}
	
}
