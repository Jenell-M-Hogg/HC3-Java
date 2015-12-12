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

public class BottomBar extends JPanel {

	JButton homeButton;
	JButton changeViewButton;
	JButton searchByCategoryButton;
	
	/**
	 * Create the panel.
	 */
	public BottomBar(boolean isFridgeView) {
		/*homeIconLocation = "/images/Home.png";
		listViewIconLocation = "/images/ListIcon.png";
		fridgeViewIconLocation = "/images/single"*/
		
		/*this.setSize((int) (Constants.FRAME_WIDTH), Constants.FRAME_HEIGHT/15);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{133, 133, 133, 0};
		gridBagLayout.rowHeights = new int[]{40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		homeButton = new JButton();
		rightButton.setIcon(new ImageIcon(HeaderBar.class.getResource("/images/images/addIcon.png")));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 0;
		
		
		//Add action listener
		rightButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addNewItem();
				
			}


			
		});
		
		
		add(rightButton, gbc_addButton);
		
		if (isFridgeView)
		middleButton = new JButton("Move/Remove Items");
		GridBagConstraints gbc_removeMoveButton = new GridBagConstraints();
		gbc_removeMoveButton.fill = GridBagConstraints.BOTH;
		gbc_removeMoveButton.insets = new Insets(0, 0, 0, 5);
		gbc_removeMoveButton.gridx = 1;
		gbc_removeMoveButton.gridy = 0;
		
		middleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				
			}


			
		});
		add(middleButton, gbc_removeMoveButton);
		
		leftButton = new JButton("Edit Fridge Details");
		GridBagConstraints gbc_editFridgeDetails = new GridBagConstraints();
		gbc_editFridgeDetails.fill = GridBagConstraints.BOTH;
		gbc_editFridgeDetails.gridx = 2;
		gbc_editFridgeDetails.gridy = 0;
		
		leftButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				
			}


			
		});
		add(leftButton, gbc_editFridgeDetails);*/
		
		


	}

}
