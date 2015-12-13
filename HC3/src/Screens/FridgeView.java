package Screens;

import javax.swing.JPanel;

import Global.Constants;
import Repository.Fridge;
import Widgets.HeaderBar;
import Widgets.BottomBar;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import Global.FridgeLocation;
import java.awt.FlowLayout;

public class FridgeView extends JPanel {
	private JLabel fridgeLabel;
	private JLabel messageLbl;

	/**
	 * Create the panel.
	 */
	public FridgeView(Fridge fridge) {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		setLayout(new BorderLayout(0, 0));
		
		HeaderBar headerBar = new HeaderBar();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) headerBar.getLayout();
		gridBagLayout_1.columnWidths = new int[] {133, 133, 133};
		gridBagLayout_1.rowWeights = new double[]{1.0, 0.0};
		gridBagLayout_1.columnWeights = new double[]{1.0, 0.0, 0.0};
		add(headerBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		headerBar.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		messageLbl = new JLabel("Displaying");
		messageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(messageLbl);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Fridge Body", "Door", "Freezer", "Freezer Door"}));
		panel.add(comboBox_2);
		
		JLabel lblOf = new JLabel("of");
		panel.add(lblOf);
		
		fridgeLabel = new JLabel(fridge.returnName());
		panel.add(fridgeLabel);
		
		BottomBar bottomBar = new BottomBar("FridgeView");
		GridBagLayout gridBagLayout = (GridBagLayout) bottomBar.getLayout();
		gridBagLayout.rowHeights = new int[] {40};
		add(bottomBar, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hello", "Yooo"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox.weightx = 0.25;
		gbc_comboBox.insets = new Insets(1, 1, 0, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel_1.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 0;
		panel_1.add(comboBox_1, gbc_comboBox_1);

	}

}
