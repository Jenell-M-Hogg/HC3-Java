package Widgets;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;

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

	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public Compartment() throws IOException, URISyntaxException {		
				
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
		
		double howManyFit= actualSize.getHeight()/panels.get(0).getPreferredSize().getHeight();
		rows= (int) howManyFit;
		columns=1;
		
		
	}
	
	public void sort(){
	//	
	}
	
	public void addItem(ItemPanel itemPanel){
		paneWindow.add(itemPanel);
	
		paneWindow.setPreferredSize(paneWindow.getPreferredSize());
		paneWindow.validate();
	}
	
	
	
	

}
