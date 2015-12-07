package Screens;

import javax.swing.JPanel;

import Global.Constants;
import Widgets.BottomBar;
import Widgets.HeaderBar;

public class ShoppingListView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ShoppingListView() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

		HeaderBar headerBar = new HeaderBar();
		add(headerBar);
		
		BottomBar bottomBar = new BottomBar();
		add(bottomBar);

	}

}
