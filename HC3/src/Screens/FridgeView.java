package Screens;

import javax.swing.JPanel;

import Global.Constants;
import Repository.Fridge;
import Repository.Item;
import Widgets.HeaderBar;
import Widgets.BottomBar;
import Widgets.ItemPanel;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import Widgets.Compartment;
import java.awt.GridLayout;

public class FridgeView extends JPanel {
	private Fridge fridge;
	
	private JLabel fridgeLabel;
	private JLabel messageLbl;
	private JPanel fridgePanel;

	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public FridgeView(Fridge fridge) throws IOException, URISyntaxException {
		this.fridge=fridge;
		
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
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hello", "Yooo"}));
		panel_1.add(comboBox, BorderLayout.WEST);
		
		fridgePanel = new JPanel();
		fridgePanel.setBackground(Color.WHITE);
		panel_1.add(fridgePanel, BorderLayout.CENTER);
		GridBagLayout gbl_fridgePanel = new GridBagLayout();
		gbl_fridgePanel.columnWidths = new int[] {0};
		gbl_fridgePanel.rowHeights = new int[] {0};
		gbl_fridgePanel.columnWeights = new double[]{0.0};
		gbl_fridgePanel.rowWeights = new double[]{0.0};
		fridgePanel.setLayout(gbl_fridgePanel);
		
		
		
		initializeCompartments();
		
	}

	private void initializeCompartments() throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		Compartment compartment = new Compartment();
		GridBagConstraints gbc_compartment = new GridBagConstraints();
		gbc_compartment.ipady = 1;
		gbc_compartment.ipadx = 1;
		gbc_compartment.insets = new Insets(5, 5, 5, 5);
		gbc_compartment.weighty = 1.0;
		gbc_compartment.weightx = 1.0;
		gbc_compartment.fill = GridBagConstraints.BOTH;
		gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
		gbc_compartment.gridx = 0;
		gbc_compartment.gridy = 0;
		fridgePanel.add(compartment, gbc_compartment);
		
		
		ArrayList<Item> items= fridge.getItems();
		ArrayList<ItemPanel> panels= new ArrayList<ItemPanel>();
		
		for(Item item: items){
			panels.add(new ItemPanel(item));
		}
		
		
		compartment.AddItems(panels);
		
	}



}
