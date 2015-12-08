package Widgets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.Constants;
import Repository.Category;
import Repository.Item;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

public class ItemPanel extends JPanel {
	private JTextField txtSdf;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public ItemPanel(Item item) throws IOException, URISyntaxException {
		this.setSize(Constants.FRAME_WIDTH/2, 25);

		String categoryIconFileLocation = item.getCategory().getIconLocation();
		String name = item.getName();
		int quantity = item.getQuantity();
		int countDown = item.getCountDown();
		String expiryIconFileLocation = "/images/ExpiryCountdown.png";
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Item " + name + "was clicked; open item details pop-up");
			}
		});
		
		BufferedImage itemCategoryPicture = ImageIO.read(new File(getClass().getResource(categoryIconFileLocation).toURI()));
		BufferedImage itemExpiryPicture = ImageIO.read(new File(getClass().getResource(expiryIconFileLocation).toURI()));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{25, 37, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JLabel itemCategoryIcon = new JLabel(new ImageIcon(itemCategoryPicture));
		itemCategoryIcon.setText(name);
		itemCategoryIcon.setHorizontalAlignment(SwingConstants.LEFT);
		itemCategoryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(categoryIconFileLocation)));
		GridBagConstraints gbc_itemCategoryIcon = new GridBagConstraints();
		gbc_itemCategoryIcon.anchor = GridBagConstraints.WEST;
		gbc_itemCategoryIcon.insets = new Insets(0, 0, 0, 5);
		gbc_itemCategoryIcon.gridwidth = 5;
		gbc_itemCategoryIcon.gridx = 3;
		gbc_itemCategoryIcon.gridy = 0;
		add(itemCategoryIcon, gbc_itemCategoryIcon);
		
		/*JLabel itemExpiryIcon = new JLabel(new ImageIcon(itemExpiryPicture));
		itemExpiryIcon.setText("");
		itemExpiryIcon.setHorizontalAlignment(SwingConstants.LEFT);
		itemExpiryIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		itemExpiryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(expiryIconFileLocation)));
		GridBagConstraints gbc_itemExpiryIcon = new GridBagConstraints();
		gbc_itemExpiryIcon.insets = new Insets(0, 0, 0, 5);
		gbc_itemExpiryIcon.anchor = GridBagConstraints.NORTHWEST;
		gbc_itemExpiryIcon.gridx = 10;
		gbc_itemExpiryIcon.gridy = 0;
		add(itemExpiryIcon, gbc_itemExpiryIcon);*/
		
		JLabel lblQty = new JLabel("Qty: " + quantity);
		
		GridBagConstraints gbc_lblQty = new GridBagConstraints();
		gbc_lblQty.insets = new Insets(0, 0, 0, 5);
		gbc_lblQty.anchor = GridBagConstraints.CENTER;
		gbc_lblQty.gridx = 8;
		gbc_lblQty.gridy = 0;
		add(lblQty, gbc_lblQty);
		
		ExpiryCountDown expiryCountDown = new ExpiryCountDown(countDown);
		GridBagConstraints gbc_expiryCountDown = new GridBagConstraints();
		gbc_expiryCountDown.insets = new Insets(0, 0, 0, 5);
		gbc_expiryCountDown.fill = GridBagConstraints.EAST;
		gbc_expiryCountDown.gridx = 10;
		gbc_expiryCountDown.gridy = 0;
		add(expiryCountDown, gbc_expiryCountDown);
	}
}