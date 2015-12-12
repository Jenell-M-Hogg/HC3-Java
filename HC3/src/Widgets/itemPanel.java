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
	private Item item;
	private BufferedImage itemCategoryPicture;
	private JLabel itemCategoryIcon;
	private JLabel lblQty;
	private ExpiryCountDown expiryCountDown;
	
	private String tempActionListenerString = "";
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public ItemPanel(Item item) throws IOException, URISyntaxException {
		this.item = item;
		this.setSize(Constants.FRAME_WIDTH/2, 25);
		
		itemCategoryPicture = ImageIO.read(new File(getClass().getResource(item.getCategory().getIconLocation()).toURI()));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(tempActionListenerString);
			}
		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{25, 37, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		itemCategoryIcon = new JLabel(new ImageIcon(itemCategoryPicture));
		
		//itemCategoryIcon.setText(item.getName());
		itemCategoryIcon.setHorizontalAlignment(SwingConstants.LEFT);
		//itemCategoryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(item.getCategory().getIconLocation())));
		GridBagConstraints gbc_itemCategoryIcon = new GridBagConstraints();
		gbc_itemCategoryIcon.anchor = GridBagConstraints.WEST;
		gbc_itemCategoryIcon.insets = new Insets(0, 0, 0, 5);
		gbc_itemCategoryIcon.gridwidth = 5;
		gbc_itemCategoryIcon.gridx = 3;
		gbc_itemCategoryIcon.gridy = 0;
		add(itemCategoryIcon, gbc_itemCategoryIcon);
		
		lblQty = new JLabel(" x" + item.getQuantity());
		
		GridBagConstraints gbc_lblQty = new GridBagConstraints();
		gbc_lblQty.insets = new Insets(0, 0, 0, 5);
		gbc_lblQty.anchor = GridBagConstraints.CENTER;
		gbc_lblQty.gridx = 8;
		gbc_lblQty.gridy = 0;
		add(lblQty, gbc_lblQty);
		
		expiryCountDown = new ExpiryCountDown(item.getCountDown());
		GridBagConstraints gbc_expiryCountDown = new GridBagConstraints();
		gbc_expiryCountDown.insets = new Insets(0, 0, 0, 5);
		gbc_expiryCountDown.fill = GridBagConstraints.EAST;
		gbc_expiryCountDown.gridx = 10;
		gbc_expiryCountDown.gridy = 0;
		add(expiryCountDown, gbc_expiryCountDown);
		
		update();
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) throws IOException, URISyntaxException {
		this.item = item;
		
		String name = item.getName();
		int quantity = item.getQuantity();
		int countDown = item.getCountDown();
		String categoryIconFileLocation = item.getCategory().getIconLocation();
		
		BufferedImage itemCategoryPicture = ImageIO.read(new File(getClass().getResource(categoryIconFileLocation).toURI()));

		update();
	}

	private void update() throws IOException, URISyntaxException {
		
		itemCategoryIcon.setText(item.getName());
		itemCategoryIcon.setIcon(new ImageIcon(ItemPanel.class.getResource(item.getCategory().getIconLocation())));
		
		String qtyText = " x" + item.getQuantity();
		if (this.item.getQuantity() == -1) {
			lblQty.setVisible(false); 
		} else {
			lblQty.setVisible(true);
		}
		lblQty.setText(qtyText);
		
		expiryCountDown.setCountDown(item.getCountDown());
		expiryCountDown.update();
		
		tempActionListenerString = "Item " + this.item.getName() + "was clicked; open item details pop-up";
	}
}