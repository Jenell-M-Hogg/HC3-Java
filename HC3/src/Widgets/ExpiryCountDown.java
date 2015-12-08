package Widgets;

import javax.swing.JPanel;

import java.awt.Canvas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import Global.Constants;

import java.awt.GridLayout;

public class ExpiryCountDown extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExpiryCountDown(int countDown) {
		if (countDown > 20) {
			setBackground(Color.GREEN);
		} else if (countDown > 10) {
			setBackground(Color.YELLOW);
		} else if (countDown > 5) {
			setBackground(Color.ORANGE);
		} else {
			setBackground(Color.RED);
		}
		this.setSize(25, 25);

		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("" + countDown);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ExpiryCountDown.class.getResource("/images/ExpiryCountdown.png")));
		add(lblNewLabel);
		
	}
}
