package Widgets;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;

import Global.FridgeLocation;
import Repository.Item;

import java.awt.GridBagConstraints;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.BorderLayout;

import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Compartment extends JPanel {
	private JPanel paneWindow;
	boolean isVertical;
	
	int itemCount=0;
	int columns;
	int rows;
	private JScrollPane scrollPane;
	
	private FridgeLocation flocation;
	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public Compartment(FridgeLocation location) throws IOException, URISyntaxException {	
		this.setFlocation(location);
				
		setLayout(new BorderLayout(0, 0));
		
		paneWindow = new JPanel();
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		
		scrollPane.setViewportView(paneWindow);
		GridBagLayout gbl_paneWindow = new GridBagLayout();
		gbl_paneWindow.columnWidths = new int[]{0};
		gbl_paneWindow.rowHeights = new int[]{0};
		gbl_paneWindow.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_paneWindow.rowWeights = new double[]{Double.MIN_VALUE};
		paneWindow.setLayout(gbl_paneWindow);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	
	public void AddItems(ArrayList<ItemPanel> panels){
	
		Dimension actualSize= scrollPane.getViewport().getExtentSize();
		Dimension parent= this.getParent().getSize();
		if(!panels.isEmpty()){
			double howManyFit= actualSize.getHeight()/(panels.get(0).getPreferredSize().getHeight()+4);
			rows= (int) howManyFit;
			columns=1;
			
			if (rows==0){
				rows=1;
			}
			
			for(int i=0; i<panels.size(); i++){
				int rowIndex=i%rows;
				if (rowIndex==0 & i!=0){
					columns++;
				}
				this.addItem(panels.get(i),rowIndex,columns-1);
			}
		}
		
		
	}
	
	public void sort(){
	//	
	}
	
	public void addItem(ItemPanel itemPanel, int row, int column){
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx=column;
		gbc.gridy=row+1;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill=GridBagConstraints.NONE;
		gbc.insets=new Insets(2,2,2,2);
		
		paneWindow.add(itemPanel,gbc);
		paneWindow.setPreferredSize(paneWindow.getLayout().preferredLayoutSize(paneWindow));
		
	}


	public FridgeLocation getFlocation() {
		return flocation;
	}


	public void setFlocation(FridgeLocation flocation) {
		this.flocation = flocation;
	}
	
	
	
	

}
