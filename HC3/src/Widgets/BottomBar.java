package Widgets;

import javax.swing.JPanel;

import Global.Constants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BottomBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public BottomBar() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT/15);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{133, 133, 133, 0};
		gridBagLayout.rowHeights = new int[]{40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton addButton = new JButton("New button");
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 0;
		add(addButton, gbc_addButton);
		
		JButton removeMoveButton = new JButton("New button");
		GridBagConstraints gbc_removeMoveButton = new GridBagConstraints();
		gbc_removeMoveButton.fill = GridBagConstraints.BOTH;
		gbc_removeMoveButton.insets = new Insets(0, 0, 0, 5);
		gbc_removeMoveButton.gridx = 1;
		gbc_removeMoveButton.gridy = 0;
		add(removeMoveButton, gbc_removeMoveButton);
		
		JButton editFridgeDetails = new JButton("New button");
		GridBagConstraints gbc_editFridgeDetails = new GridBagConstraints();
		gbc_editFridgeDetails.fill = GridBagConstraints.BOTH;
		gbc_editFridgeDetails.gridx = 2;
		gbc_editFridgeDetails.gridy = 0;
		add(editFridgeDetails, gbc_editFridgeDetails);
		
		

	}

}
