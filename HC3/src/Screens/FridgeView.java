package Screens;

import javax.swing.JPanel;

import Global.Constants;
import Widgets.HeaderBar;
import Widgets.BottomBar;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

public class FridgeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public FridgeView() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		setLayout(new BorderLayout(0, 0));
		
		HeaderBar headerBar = new HeaderBar();
		add(headerBar, BorderLayout.NORTH);
		
		BottomBar bottomBar = new BottomBar(null, "FridgeView");
		GridBagLayout gridBagLayout = (GridBagLayout) bottomBar.getLayout();
		gridBagLayout.rowHeights = new int[] {40};
		add(bottomBar, BorderLayout.SOUTH);

	}

}
