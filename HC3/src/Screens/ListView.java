package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Global.Constants;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import Widgets.HeaderBar;
import Widgets.BottomBar;

public class ListView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListView() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		
		BottomBar bottomBar = new BottomBar();
		add(bottomBar);
		
		
		

	}

}
