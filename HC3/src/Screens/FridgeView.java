package Screens;

import javax.swing.JPanel;

import Global.Constants;
import Global.ProjectFrame;
import Repository.Fridge;
import Repository.Item;
import Widgets.HeaderBar;
import Widgets.BottomBar;
import Widgets.ItemPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FridgeView extends JPanel {
	private Fridge fridge;
	
	private JLabel fridgeLabel;
	private JLabel messageLbl;
	private JPanel fridgePanel;
	private Compartment door_top_shelf;
	private JComboBox fridgeLocationBox;
	private ArrayList<ItemPanel> itemPanels= new ArrayList<ItemPanel>();
	
	
	private Compartment door_middle_shelf;

	private Compartment door_bottom_shelf;

	private Compartment freezer_top_shelf;

	private Compartment freezer_door;

	private Compartment freezer_bottom;

	private Compartment top_shelf;

	private Compartment bottom_shelf;

	private Compartment middle_shelf;

	private Compartment crisper_right;

	private Compartment crisper_left;
	
	private ArrayList<Compartment> compartments= new ArrayList<Compartment>();

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
		
		fridgeLocationBox = new JComboBox();
		fridgeLocationBox.setModel(new DefaultComboBoxModel(new String[] {"Fridge Body", "Door", "Freezer", "Freezer Door"}));
		panel.add(fridgeLocationBox);
		
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
		gbl_fridgePanel.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_fridgePanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_fridgePanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_fridgePanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		fridgePanel.setLayout(gbl_fridgePanel);
		
		door_top_shelf = new Compartment(FridgeLocation.DOOR_TOP);
		compartments.add(door_top_shelf);
		GridBagConstraints gbc_compartment = new GridBagConstraints();
		gbc_compartment.gridheight = 19;
		gbc_compartment.gridwidth = 13;
		gbc_compartment.ipady = 1;
		gbc_compartment.ipadx = 1;
		gbc_compartment.insets = new Insets(2, 2, 5, 2);
		gbc_compartment.weighty = 1.0;
		gbc_compartment.weightx = 1.0;
		gbc_compartment.fill = GridBagConstraints.BOTH;
		gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
		gbc_compartment.gridx = 0;
		gbc_compartment.gridy = 0;
		fridgePanel.add(door_top_shelf, gbc_compartment);
		
		
		
		fridgeLocationBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					initializeCompartments();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

	
	
	
	public void initializeCompartments() throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		fridgePanel.removeAll();
		
		
		if(fridgeLocationBox.getModel().getSelectedItem().equals("Fridge Body")){
		
		
			top_shelf = new Compartment(FridgeLocation.TOP_SHELF);
			this.compartments.add(top_shelf);
			GridBagConstraints gbc_compartment = new GridBagConstraints();
			gbc_compartment.gridheight = 5;
			gbc_compartment.gridwidth = 13;
			gbc_compartment.ipady = 1;
			gbc_compartment.ipadx = 1;
			gbc_compartment.insets = new Insets(2, 2, 5, 2);
			gbc_compartment.weighty = 1.0;
			gbc_compartment.weightx = 1.0;
			gbc_compartment.fill = GridBagConstraints.BOTH;
			gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
			gbc_compartment.gridx = 0;
			gbc_compartment.gridy = 0;
			fridgePanel.add(door_top_shelf, gbc_compartment);
			
			middle_shelf = new Compartment(FridgeLocation.MIDDLE_SHELF);
			this.compartments.add(middle_shelf);
			GridBagConstraints gbc_compartment_1 = new GridBagConstraints();
			gbc_compartment_1.gridheight = 5;
			gbc_compartment_1.gridwidth = 13;
			gbc_compartment_1.insets = new Insets(2, 2, 5, 2);
			gbc_compartment_1.fill = GridBagConstraints.BOTH;
			gbc_compartment_1.gridx = 0;
			gbc_compartment_1.gridy = 5;
			fridgePanel.add(middle_shelf, gbc_compartment_1);
			
			bottom_shelf = new Compartment(FridgeLocation.BOTTOM_SHELF);
			this.compartments.add(bottom_shelf);
			GridBagConstraints gbc_compartment_2 = new GridBagConstraints();
			gbc_compartment_2.gridheight = 5;
			gbc_compartment_2.gridwidth = 13;
			gbc_compartment_2.insets = new Insets(2, 2, 5, 2);
			gbc_compartment_2.fill = GridBagConstraints.BOTH;
			gbc_compartment_2.gridx = 0;
			gbc_compartment_2.gridy = 10;
			fridgePanel.add(bottom_shelf, gbc_compartment_2);
			
			crisper_right = new Compartment(FridgeLocation.CRISPER_RIGHT);
			this.compartments.add(crisper_right);
			GridBagConstraints gbc_compartment_3 = new GridBagConstraints();
			gbc_compartment_3.gridwidth = 6;
			gbc_compartment_3.gridheight = 4;
			gbc_compartment_3.insets = new Insets(2, 2, 2, 5);
			gbc_compartment_3.fill = GridBagConstraints.BOTH;
			gbc_compartment_3.gridx = 0;
			gbc_compartment_3.gridy = 15;
			fridgePanel.add(crisper_right, gbc_compartment_3);
			
			crisper_left = new Compartment(FridgeLocation.CRISPER_LEFT);
			this.compartments.add(crisper_left);
			GridBagConstraints gbc_compartment_4 = new GridBagConstraints();
			gbc_compartment_4.gridheight = 4;
			gbc_compartment_4.gridwidth = 7;
			gbc_compartment_4.insets = new Insets(2, 2, 2, 2);
			gbc_compartment_4.fill = GridBagConstraints.BOTH;
			gbc_compartment_4.gridx = 6;
			gbc_compartment_4.gridy = 15;
			fridgePanel.add(crisper_left, gbc_compartment_4);
			
			ArrayList<Item> items= fridge.getItems();
			itemPanels= new ArrayList<ItemPanel>();
			
			for(Item item: items){
				itemPanels.add(new ItemPanel(item));
			}
			
			
			sortItems();
			
		}
		
		
		
		if(fridgeLocationBox.getModel().getSelectedItem().equals("Door")){
			
			door_top_shelf = new Compartment(FridgeLocation.DOOR_TOP);
			GridBagConstraints gbc_compartment = new GridBagConstraints();
			gbc_compartment.gridheight = 7;
			gbc_compartment.gridwidth = 13;
			gbc_compartment.ipady = 1;
			gbc_compartment.ipadx = 1;
			gbc_compartment.insets = new Insets(2, 2, 5, 2);
			gbc_compartment.weighty = 1.0;
			gbc_compartment.weightx = 1.0;
			gbc_compartment.fill = GridBagConstraints.BOTH;
			gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
			gbc_compartment.gridx = 0;
			gbc_compartment.gridy = 0;
			fridgePanel.add(door_top_shelf, gbc_compartment);
			
			door_middle_shelf = new Compartment(FridgeLocation.DOOR_MIDDLE);
			GridBagConstraints gbc_compartment_1 = new GridBagConstraints();
			gbc_compartment_1.gridheight = 6;
			gbc_compartment_1.gridwidth = 13;
			gbc_compartment_1.insets = new Insets(0, 0, 5, 0);
			gbc_compartment_1.fill = GridBagConstraints.BOTH;
			gbc_compartment_1.gridx = 0;
			gbc_compartment_1.gridy = 7;
			fridgePanel.add(door_middle_shelf, gbc_compartment_1);
			
			door_bottom_shelf = new Compartment(FridgeLocation.DOOR_BOTTOM);
			GridBagConstraints gbc_compartment_2 = new GridBagConstraints();
			gbc_compartment_2.gridheight = 6;
			gbc_compartment_2.gridwidth = 13;
			gbc_compartment_2.insets = new Insets(0, 0, 5, 5);
			gbc_compartment_2.fill = GridBagConstraints.BOTH;
			gbc_compartment_2.gridx = 0;
			gbc_compartment_2.gridy = 13;
			fridgePanel.add(door_bottom_shelf, gbc_compartment_2);
			
		}
		
		if(fridgeLocationBox.getModel().getSelectedItem().equals("Freezer")){
			
			freezer_top_shelf = new Compartment(FridgeLocation.FREEZER_TOP);
			
			freezer_top_shelf = new Compartment(FridgeLocation.FREEZER_TOP);
			GridBagConstraints gbc_compartment = new GridBagConstraints();
			gbc_compartment.gridheight = 10;
			gbc_compartment.gridwidth = 13;
			gbc_compartment.ipady = 1;
			gbc_compartment.ipadx = 1;
			gbc_compartment.insets = new Insets(2, 2, 5, 2);
			gbc_compartment.weighty = 1.0;
			gbc_compartment.weightx = 1.0;
			gbc_compartment.fill = GridBagConstraints.BOTH;
			gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
			gbc_compartment.gridx = 0;
			gbc_compartment.gridy = 0;
			fridgePanel.add(freezer_top_shelf, gbc_compartment);
			
			freezer_bottom = new Compartment(FridgeLocation.FREEZER_BOTTOM);
			GridBagConstraints gbc_compartment_1 = new GridBagConstraints();
			gbc_compartment_1.gridheight = 9;
			gbc_compartment_1.gridwidth = 13;
			gbc_compartment_1.insets = new Insets(0, 0, 5, 0);
			gbc_compartment_1.fill = GridBagConstraints.BOTH;
			gbc_compartment_1.gridx = 0;
			gbc_compartment_1.gridy = 10;
			fridgePanel.add(freezer_bottom, gbc_compartment_1);
			
		}
		
		if(fridgeLocationBox.getModel().getSelectedItem().equals("Freezer Door")){
			
			freezer_door = new Compartment(FridgeLocation.FREEZER_DOOR);
			
			
			GridBagConstraints gbc_compartment = new GridBagConstraints();
			gbc_compartment.gridheight = 19;
			gbc_compartment.gridwidth = 13;
			gbc_compartment.ipady = 1;
			gbc_compartment.ipadx = 1;
			gbc_compartment.insets = new Insets(2, 2, 5, 2);
			gbc_compartment.weighty = 1.0;
			gbc_compartment.weightx = 1.0;
			gbc_compartment.fill = GridBagConstraints.BOTH;
			gbc_compartment.anchor = GridBagConstraints.NORTHWEST;
			gbc_compartment.gridx = 0;
			gbc_compartment.gridy = 0;
			fridgePanel.add(freezer_door, gbc_compartment);
			
		}
		
		
		
		fridgePanel.revalidate();
		fridgePanel.repaint();
		
	}

	
	
	
	
	private void sortItems() {
		// TODO Auto-generated method stub
		
	}


	public void addItem(Item item) throws IOException, URISyntaxException{
		fridge.addItem(item);
		
		this.itemPanels.add(new ItemPanel(item));
		
		//TODO sort??
		
		updateCompartments();
		
	}

	




	private void updateCompartments() throws IOException, URISyntaxException {
		initializeCompartments();
		Component[] compartments=fridgePanel.getComponents();
		
		for(Component compartment: compartments){
			ArrayList<ItemPanel> panels= new ArrayList<ItemPanel>();
			
			for(ItemPanel itemPanel: this.itemPanels){
				if(itemPanel.getItem().getLocation().equals(((Compartment)compartment).getFlocation())){
					panels.add(itemPanel);
				}
			}
			((Compartment)compartment).AddItems(panels);
		}
		
		
		
	}




	public Fridge getFridge() {
		return fridge;
	}
	
	public void setFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public boolean getIsMoveRemoveMode() {
		// TODO Auto-generated method stub
		return true;
	}

	public void OpenItemDetails() {
		// TODO Auto-generated method stub
		
	}
}
