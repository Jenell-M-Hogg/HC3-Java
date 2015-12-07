package Widgets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.Constants;
import Repository.Item;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ItemPanel extends JPanel {
	private JTextField txtSdf;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public ItemPanel(Item item) throws IOException {
		int panelWidth, panelHeight;
		boolean isFridgeView = true; // Should check current screen
		if (isFridgeView) {
			panelWidth = Constants.FRAME_WIDTH/2;
			panelHeight = 25+10;
		} else {
			panelWidth = 3*Constants.FRAME_WIDTH/4;
			panelHeight = 25+10;
		}
		
		this.setSize(panelWidth, panelHeight);
		
		String categoryIconFileLocation = "/images/Fruit.svg.png"; //item.Category.iconLocation
		String name = "Apples Long Name"; //item.name
		int quantity = 99; //item.quantity
		int countDown = 66; //item.countDown
		String expiryPictureFileLocation = "/images/ExpiryCountdown.png"; //item.expiryPictureFileLocation
		
		BufferedImage itemCategoryPicture = ImageIO.read(new File(categoryIconFileLocation));
		JLabel itemCategoryIcon = new JLabel(new ImageIcon(itemCategoryPicture));
		itemCategoryIcon.setText(name);
		itemCategoryIcon.setHorizontalAlignment(SwingConstants.LEFT);
		itemCategoryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(categoryIconFileLocation)));
		//add(itemCategoryIcon);
		
		JLabel lblQty = new JLabel("Qty: " + quantity);
		//add(lblQty);
		
		BufferedImage itemExpiryPicture = ImageIO.read(new File(expiryPictureFileLocation));
		JLabel itemExpiryIcon = new JLabel(new ImageIcon(itemExpiryPicture));
		itemExpiryIcon.setText("");
		itemExpiryIcon.setHorizontalAlignment(SwingConstants.LEFT);
		itemExpiryIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		itemExpiryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(expiryPictureFileLocation)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(itemCategoryIcon)
					.addGap(5)
					.addComponent(lblQty)
					.addGap(5)
					.addComponent(itemExpiryIcon))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(itemCategoryIcon))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblQty))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(itemExpiryIcon))
		);
		setLayout(groupLayout);
	}
}
