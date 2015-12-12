package Widgets;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Global.Constants;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BottomBar extends JPanel {

	JButton homeButton;
	JButton changeViewButton;
	JButton searchByCategoryButton;
	private JTextField txtGfhgfhg;
	
	/**
	 * Create the panel.
	 */
	public BottomBar(String currentScreen) {
		String homeIconLocation = "/images/Home.png";
		String listViewIconLocation = "/images/ListIcon.png";
		String fridgeViewIconLocation = "/images/singleDoorIcon.png";
		
		this.setSize((int) (Constants.FRAME_WIDTH), Constants.FRAME_HEIGHT/15);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 60, 100, 160};
		gridBagLayout.rowHeights = new int[]{40, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		homeButton = new JButton();
		homeButton.setIcon(new ImageIcon(BottomBar.class.getResource(homeIconLocation)));
		GridBagConstraints gbc_homeButton = new GridBagConstraints();
		gbc_homeButton.fill = GridBagConstraints.VERTICAL;
		gbc_homeButton.insets = new Insets(0, 0, 5, 5);
		gbc_homeButton.gridx = 0;
		gbc_homeButton.gridy = 0;
		
		
		//Add action listener
		homeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//go to main menu
			}
		});

		add(homeButton, gbc_homeButton);
		
		changeViewButton = new JButton();
		if (currentScreen.equals("FridgeView")) {
			changeViewButton.setVisible(true);
			changeViewButton.setIcon(new ImageIcon(BottomBar.class.getResource(listViewIconLocation)));
		} else if (currentScreen.equals("ListView")) {
			changeViewButton.setVisible(true);
			changeViewButton.setIcon(new ImageIcon(BottomBar.class.getResource(fridgeViewIconLocation)));
		} else {
			changeViewButton.setVisible(false);
		}
		GridBagConstraints gbc_changeViewButton = new GridBagConstraints();
		gbc_changeViewButton.fill = GridBagConstraints.VERTICAL;
		gbc_changeViewButton.insets = new Insets(0, 0, 5, 5);
		gbc_changeViewButton.gridx = 1;
		gbc_changeViewButton.gridy = 0;
		
		changeViewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentScreen.equals("FridgeView")) {
					//set to listView
				} else {
					//set to fridgeView
				}
			}	
		});
		add(changeViewButton, gbc_changeViewButton);
		
		searchByCategoryButton = new JButton("Search Category");
		GridBagConstraints gbc_searchByCategoryButton = new GridBagConstraints();
		gbc_searchByCategoryButton.insets = new Insets(0, 0, 5, 0);
		gbc_searchByCategoryButton.fill = GridBagConstraints.VERTICAL;
		gbc_searchByCategoryButton.gridx = 2;
		gbc_searchByCategoryButton.gridy = 0;
		
		searchByCategoryButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Open the search category pop-up
			}
		});
		add(searchByCategoryButton, gbc_searchByCategoryButton);
		
		txtGfhgfhg = new JTextField();
		txtGfhgfhg.setText("Search");
		GridBagConstraints gbc_txtGfhgfhg = new GridBagConstraints();
		gbc_txtGfhgfhg.insets = new Insets(0, 0, 0, 5);
		gbc_txtGfhgfhg.fill = GridBagConstraints.BOTH;
		gbc_txtGfhgfhg.gridx = 3;
		gbc_txtGfhgfhg.gridy = 0;
		add(txtGfhgfhg, gbc_txtGfhgfhg);
		txtGfhgfhg.setColumns(10);

	}
}
