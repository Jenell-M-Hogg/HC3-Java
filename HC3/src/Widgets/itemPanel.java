package Widgets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.Constants;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class itemPanel extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public itemPanel() throws IOException {
		setLayout(new GridLayout(1, 0, 0, 0));
		this.setSize(Constants.FRAME_WIDTH/3, Constants.FRAME_HEIGHT/15);
		
		BufferedImage fruitPicture = ImageIO.read(new File("images/Fruit.svg.png"));
		JLabel fruitIcon = new JLabel(new ImageIcon(fruitPicture));
		fruitIcon.setIcon(new ImageIcon(itemPanel.class.getResource("/images/Fruit.svg.png")));
		add(fruitIcon);
	}
}
