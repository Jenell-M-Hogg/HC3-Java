package Screens;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Global.Constants;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
	private final Action action = new SwingAction();
	private JTextField txtMainMenu;
	

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		
		txtMainMenu = new JTextField();
		txtMainMenu.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtMainMenu.setEditable(false);
		txtMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtMainMenu.setText("MAIN MENU");
		txtMainMenu.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnRemove = new JButton("remove Fridge");
		JButton btnAdd = new JButton("Add Fridge");
		JButton btnAddShoppingList = new JButton("Add Shopping List");
		JButton btnRemoveShoppingList = new JButton("Remove Shopping List");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAddShoppingList)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnRemoveShoppingList))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnRemove))
								.addComponent(scrollPane)
								.addComponent(scrollPane_1))
							.addGap(39))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(txtMainMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(120))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(txtMainMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddShoppingList)
						.addComponent(btnRemoveShoppingList))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		
		JPanel Shoppingpanel = new JPanel();
		scrollPane.setViewportView(Shoppingpanel);
		Shoppingpanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel FridgePanel = new JPanel();
		scrollPane_1.setViewportView(FridgePanel);
		FridgePanel.setLayout(new GridLayout(1, 0, 0, 0));
		setLayout(groupLayout);
		
		
		//----------------------Action Listeners----------------------------//
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToList(FridgePanel, "Fridge", scrollPane_1 );
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFromList(FridgePanel, scrollPane_1);
			}
		});
		
		btnAddShoppingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToList(Shoppingpanel, "Shopping List", scrollPane);
			}
		});
		
		btnRemoveShoppingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFromList(Shoppingpanel, scrollPane);
			}
		});
		
	}
	
	
	//add items to both lists based on which list and which panel
	public void AddToList(JPanel currentPanel, String type, JScrollPane jPane){
		Button hi = new Button();
		
		hi.setName("button" + (currentPanel.getComponentCount()+1));
		hi.setPreferredSize(new Dimension(100,75));
		
		hi.setLabel(type + " " + (currentPanel.getComponentCount()+1));
		
		currentPanel.add(hi);
		
		UpdateScreens(currentPanel, jPane);
	}
	
	
	//remove items from both lists
	public void RemoveFromList(JPanel currentPanel, JScrollPane jPane){
		if(currentPanel.getComponentCount() > 0){
		    Component[] components = currentPanel.getComponents();
		    
		    for(Component com : components) {
		    	if(com.getName().equals("button"+ currentPanel.getComponentCount())){
		    		currentPanel.remove(com); 
		    	}
		    }
		    
		    	UpdateScreens(currentPanel, jPane);
		    
		}
		
	}
	
	
	
	public void UpdateScreens(JPanel currentPanel, JScrollPane jPane){
	   currentPanel.getParent().setPreferredSize(jPane.getPreferredSize());
		jPane.getParent().revalidate();
		jPane.getParent().repaint();
	}
	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
