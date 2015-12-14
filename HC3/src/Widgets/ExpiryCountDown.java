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

	private int countDown;

	private JLabel lblNewLabel;
	/**
	 * Create the panel.
	 */
	public ExpiryCountDown(int countDown) {
		this.countDown = countDown;
		
		if (countDown > 20) {
			this.setBackground(Color.GREEN);
		} else if (countDown > 10) {
			this.setBackground(Color.YELLOW);
		} else if (countDown > 5) {
			this.setBackground(Color.ORANGE);
		} else {
			this.setBackground(Color.RED);
		}
		this.setSize(25, 25);

		setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblNewLabel = new JLabel(countDown + "d");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setIcon(new ImageIcon(ExpiryCountDown.class.getResource("/images/ExpiryCountdown.png")));
		add(this.lblNewLabel);
	}
	
	public int getCountDown() {
		return countDown;
	}

	public void setCountDown(int countDown) {
		this.countDown = countDown;
	}
	
	public void update(boolean countDownIsSet) {
		if (countDown > 20) {
			this.setBackground(Color.GREEN);
		} else if (countDown > 10) {
			this.setBackground(Color.YELLOW);
		} else if (countDown > 5) {
			this.setBackground(Color.ORANGE);
		} else {
			this.setBackground(Color.RED);
		}
		this.lblNewLabel.setText("" + countDown);
		
		if (countDownIsSet) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}
}
