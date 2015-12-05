package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Global.Constants;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Test extends JPanel {

	/**
	 * Create the panel.
	 */
	public Test() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 
				btnOk.setText("YOU PRESSED ME");
				
			}
			
		});
		add(btnOk);
		

	}

}
