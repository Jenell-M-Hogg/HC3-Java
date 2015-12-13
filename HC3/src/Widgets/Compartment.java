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

	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public Compartment(boolean isVertical) throws IOException, URISyntaxException {
		this.isVertical=isVertical;
		
		setLayout(new BorderLayout(0, 0));
		
		paneWindow = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		if(isVertical){
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		else{
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			
		}
		
		scrollPane.setViewportView(paneWindow);
		paneWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		add(scrollPane, BorderLayout.CENTER);

	}
	
	
	public void AddItems(ArrayList<ItemPanel> panels){
		

	}
	
	public void sort(){
	//	
	}
	
	public void addItem(ItemPanel itemPanel, int i){
		paneWindow.add(itemPanel);
		
		Dimension preferred= paneWindow.getPreferredSize();
		
		if(isVertical){
			preferred.setSize(preferred.getWidth(), preferred.getHeight()+itemPanel.getPreferredSize().getHeight());	
		}
		else{
			preferred.setSize(preferred.getWidth(), preferred.getHeight()+itemPanel.getPreferredSize().getHeight());	
			
		}
		
		paneWindow.setPreferredSize(paneWindow.getLayout().preferredLayoutSize(paneWindow));
		paneWindow.validate();
	}
	
	
	
	

}
