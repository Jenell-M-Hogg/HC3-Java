package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Global.Constants;

import javax.swing.JToggleButton;

import Repository.Fridge;
import Repository.Item;
import Widgets.HeaderBar;
import Widgets.ItemPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.Component;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;

import Repository.Category;

import javax.swing.border.CompoundBorder;

import net.miginfocom.swing.MigLayout;
import Widgets.BottomBar;

public class ListView extends JPanel {
	Fridge fridge;
	
	private final String[] labels= {"Name", "Fewest Days","Most Days","Category","Location"};
	private JLabel displayedFridge;

	private ArrayList<ItemPanel> itemPanels= new ArrayList<ItemPanel>();
	private JScrollPane scrollPane;
	private JLayeredPane paneWindow;
	
	/**
	 * Create the panel.
	 */
	public ListView(Fridge fridge) {
		
		this.fridge=fridge;
		
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1, 1};
		gridBagLayout.rowHeights = new int[] {1, 1};
		gridBagLayout.columnWeights = new double[]{1.0, 1};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		HeaderBar HeaderBar = new HeaderBar();
		HeaderBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		GridBagConstraints gbc_HeaderBar = new GridBagConstraints();
		gbc_HeaderBar.weighty = 0.5;
		gbc_HeaderBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_HeaderBar.insets = new Insets(0, 0, 5, 0);
		gbc_HeaderBar.gridwidth = 2;
		gbc_HeaderBar.gridx = 0;
		gbc_HeaderBar.gridy = 0;
		add(HeaderBar, gbc_HeaderBar);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight=1;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		HeaderBar.add(panel, gbc_panel);
		
		JLabel lblItemsIn = new JLabel("Items in");
		panel.add(lblItemsIn);
		
		displayedFridge = new JLabel(fridge.returnName());
		panel.add(displayedFridge);
		
		JPanel bottomPanel = new JPanel();
		GridBagConstraints gbc_bottomPanel = new GridBagConstraints();
		gbc_bottomPanel.fill = GridBagConstraints.BOTH;
		gbc_bottomPanel.weighty = 20.0;
		gbc_bottomPanel.anchor = GridBagConstraints.NORTH;
		gbc_bottomPanel.gridwidth = 2;
		
		gbc_bottomPanel.insets = new Insets(0, 0, 5, 5);
		gbc_bottomPanel.gridx = 0;
		gbc_bottomPanel.gridy = 1;
		add(bottomPanel, gbc_bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel sortBy = new JPanel();
		sortBy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		bottomPanel.add(sortBy, BorderLayout.WEST);
		sortBy.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		sortBy.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {35};
		gbl_panel_1.rowHeights = new int[] {14};
		gbl_panel_1.columnWeights = new double[]{0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblSortBy = new JLabel("Sort By");
		lblSortBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblSortBy = new GridBagConstraints();
		gbc_lblSortBy.gridx = 0;
		gbc_lblSortBy.gridy = 0;
		panel_1.add(lblSortBy, gbc_lblSortBy);
		
		for(int i=0; i<labels.length; i++){
			this.addToggleButton(labels[i], sortBy);
		}

		
		JPanel listPane = new JPanel();
		bottomPanel.add(listPane, BorderLayout.CENTER);
		listPane.setLayout(new BorderLayout(0, 0));
		
		paneWindow= new JLayeredPane();
		paneWindow.setBorder(new CompoundBorder());
		paneWindow.setPreferredSize(new Dimension(100,100));
		

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(paneWindow);
		paneWindow.setLayout(new MigLayout("", "[][]", "[][]"));

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		listPane.add(scrollPane);

		BottomBar bottomBar = new BottomBar("ListView");
		bottomPanel.add(bottomBar, BorderLayout.SOUTH);
		try {
			setUpList(sortBy);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void setUpList(JPanel sortBy) throws IOException, URISyntaxException {
		//Given a fridge, initialize the screen.
		
		
		//We want to create Item Panels from the Items in the fridge
		
		createItemPanels();

		//By default, the list is sorted by name. Enable the "Name" button
		Component[] components=sortBy.getComponents();
		
		for (int i=0; i<components.length; i++){
			if (components[i] instanceof JToggleButton){
				if (((JToggleButton) components[i]).getText().equals(labels[0])){
					((JToggleButton)components[i]).setSelected(true);
					break;
				}
				
			}
		}
		
		//Sort by name
		this.sortBy(labels[0]);
		
	}
	
	private void addToggleButton(String name, JPanel panel){
		JToggleButton btnName = new JToggleButton(name);
		
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Component[] components=btnName.getParent().getComponents();
				if(btnName.isSelected()){
					for(int i=0; i<components.length;i++){
						try{
							JToggleButton b= (JToggleButton) components[i];
							if(!b.getText().equals(btnName.getText())& b.isSelected()){
								b.setSelected(false);
							}
						}
						catch(Exception e){	
						}		
					}
				}
				
				sortBy(btnName.getText());
			}});		
		panel.add(btnName);
	}

	private void createItemPanels() throws IOException, URISyntaxException {
		// Gets the items from fridge and updates the itemPanels
		ArrayList<Item> items= fridge.getItems();
		ArrayList<Item> newItems=new ArrayList<Item>();
		itemPanels.clear();
		
		for(int i=0; i<items.size(); i++){
			Item item = items.get(i);
			item.setItemPanelIndex(i);
			this.itemPanels.add(new ItemPanel(item));
			newItems.add(item);
		}
		fridge.setItems(newItems);
	}
	
	

	
	//TODO
	private void sortBy(String button){
		
		//If button equals name
		if(button.equals(labels[0])){
			//Sort the things by name
			nameSort();
		}
		else if (button.equals(labels[1])){
			//Sort by Fewest days
		}
		else if (button.equals(labels[2])){
			//Sort by most days
		}
		
		else if (button.equals(labels[3])){
			//Sort by category
		}
		
		else if (button.equals(labels[4])){
			//Sort by location
		}
	}

	private void nameSort() {
		//Sorts the item panels by name
		
		ArrayList<ItemPanel> sorted= new ArrayList<ItemPanel>();
		
		sorted.add(this.itemPanels.get(0));
		String thisName;
		String thatName;
		for(int i=1;i<itemPanels.size();i++){
			thisName=itemPanels.get(i).getItem().getName();
			for(int m=0; m<sorted.size(); m++){
				thatName=sorted.get(m).getItem().getName();
				
				if(thatName.compareTo(thisName)>0){
					//If this is true, that Name goes behind thisName
					sorted.add(m, itemPanels.get(i));
					break;
				}
				else{
					//thisName goes behind thatName
					sorted.add(m+1, itemPanels.get(i));
					break;
				}
			}
		}
		
		//The item Panels are sorted alphabetically, now display them on the scrollPane
		this.itemPanels=sorted;
		this.updateList();
	}

	private void daySort(boolean fromLowest){
		ArrayList<ItemPanel> sorted= new ArrayList<ItemPanel>();
		sorted.add(itemPanels.get(0));
		
		for(int i=0;i<itemPanels.size();i++){
			Item tbs= itemPanels.get(i).getItem();
			if(tbs.getCountDownIsSet()){
				
			}
			
			for(int m=0; m<sorted.size();m++){
				Item th= sorted.get(m).getItem();
				
				if (fromLowest){
					if(tbs.getCountDownIsSet()){
						
					}
				}
				
				else{
					
				}
			}
		}
	}
	

	
	private void updateList() {
		
		resetLayout();
		for(int i=0; i<this.itemPanels.size(); i++){
			addToScroll(this.itemPanels.get(i),i);
		}
		
		Dimension preferred= scrollPane.getViewport().getView().getPreferredSize();
		Dimension actual= scrollPane.getViewport().getViewSize();
				
		scrollPane.validate();
		scrollPane.repaint();
	}

	private void resetLayout() {
		paneWindow.removeAll();
		
		String rowConstraints="";
		for (int i=0; i<this.itemPanels.size(); i++){
			rowConstraints=rowConstraints+"[]";
		}
		paneWindow.setLayout(new MigLayout("", "[]", rowConstraints));
		
	}

	private void addToScroll(Component itemPanel, int i) {
	
		paneWindow.add(itemPanel, "cell 0 "+Integer.toString(i)+",alignx");
		
		Dimension preferred= paneWindow.getPreferredSize();
		preferred.setSize(preferred.getWidth(), preferred.getHeight()+itemPanel.getPreferredSize().getHeight());
		
		paneWindow.setPreferredSize(paneWindow.getLayout().preferredLayoutSize(paneWindow));
		paneWindow.validate();
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
	
	public void editItem(Item item) throws IOException, URISyntaxException{
		int index= item.getItemPanelIndex();
		
		this.itemPanels.set(index, new ItemPanel(item));
		
		for(int i=0; i<fridge.getItems().size(); i++){
			if(fridge.getItems().get(i).getItemPanelIndex()==index){
				fridge.getItems().set(i, item);
				break;
			}
		}
		
		this.updateList();
	}
	
	public void addItem(Item item) throws IOException, URISyntaxException{
		this.fridge.addItem(item);
		this.itemPanels.add(new ItemPanel(item));
		this.updateList();
	}
}
