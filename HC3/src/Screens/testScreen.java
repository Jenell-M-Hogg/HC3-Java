package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Global.Constants;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class testScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public testScreen() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		
		JButton test = new JButton("New button");
		test.setHorizontalAlignment(SwingConstants.LEADING);
		test.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				test.setText("Yoooo");
				
			}
			
		});
		add(test);
		
		
		

	}

}
