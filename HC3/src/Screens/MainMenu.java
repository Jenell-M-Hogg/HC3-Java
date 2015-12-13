package Screens;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Global.Constants;
import Global.ProjectFrame;
import Repository.Fridge;
import Repository.Item;
import Repository.ShopList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Box;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.PopupMenu;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
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
import java.util.ArrayList;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainMenu extends JPanel {
	private final Action action = new SwingAction();
	private JTextField txtMainMenu;
	
	ArrayList<Fridge> fridgeData = new ArrayList();
	ArrayList<ShopList> shopData = new ArrayList();
	
	private int defaulthandler = 0;
	
	public static MainMenu mainmenuInstance;

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		
		this.setName("carroll");
		mainmenuInstance = this;
		
		txtMainMenu = new JTextField();
		txtMainMenu.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtMainMenu.setEditable(false);
		txtMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtMainMenu.setText("MAIN MENU");
		txtMainMenu.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JFrame popFrame = new JFrame();

		
		
		JButton btnRemove = new JButton("remove Fridge");
		JButton btnAdd = new JButton("Add Fridge");
		JButton btnAddShoppingList = new JButton("Add Shopping List");
		JButton btnRemoveShoppingList = new JButton("Remove Shopping List");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setVisible(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnAddShoppingList)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnRemoveShoppingList))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(13)
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
									.addComponent(btnRemove)
									.addGap(12))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)))
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtMainMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(120))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(117)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(72))
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
						.addComponent(btnRemove)
						.addComponent(btnAdd))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddShoppingList)
						.addComponent(btnRemoveShoppingList))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addGap(37))
		);
		
		JPanel Shoppingpanel = new JPanel();
		scrollPane.setViewportView(Shoppingpanel);
		Shoppingpanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel FridgePanel = new JPanel();
		scrollPane_1.setViewportView(FridgePanel);
		FridgePanel.setLayout(new GridLayout(1, 0, 0, 0));
		setLayout(groupLayout);
		
		
		//----------------------Action Listeners----------------------------//
		
		//add fridge
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FridgeName = (String)JOptionPane.showInputDialog(
						popFrame,
	                    "Give the new fridge a name.",
	                    "Fridge Name PopUp",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "");
				
				if(!FridgeName.equals(""))
				AddToList(FridgePanel, "Fridge", scrollPane_1,btnNewButton,FridgeName);
				else{
					AddToList(FridgePanel, "Fridge", scrollPane_1,btnNewButton,"Default" + defaulthandler);
					defaulthandler++;
				}
			}
		});
		
		//remove fridge
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetCheckBoxesOn(FridgePanel, scrollPane_1,true);
				btnNewButton.setVisible(true);
				btnCancel.setVisible(true);
				scrollPane.setVisible(false);
				btnAddShoppingList.setVisible(false);
				btnRemoveShoppingList.setVisible(false);
				btnRemove.setVisible(false);
				btnAdd.setVisible(false);
			}
		});
		
		//add shopping panel
		btnAddShoppingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ShoppingListName = (String)JOptionPane.showInputDialog(
						popFrame,
	                    "Give the new shopping list a name.",
	                    "Shopping List Name PopUp",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "");
				
				if(!ShoppingListName.equals(""))
				AddToList(Shoppingpanel, "Shopping List", scrollPane,btnNewButton,ShoppingListName);
				else{
					AddToList(Shoppingpanel, "Shopping List", scrollPane,btnNewButton,"Default" + " " + defaulthandler);
					defaulthandler++;
				}
			}
		});
		
		//remove shopping panel
		btnRemoveShoppingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetCheckBoxesOn(Shoppingpanel, scrollPane,true);
				btnNewButton.setVisible(true);
				btnCancel.setVisible(true);
				scrollPane_1.setVisible(false);
				btnAddShoppingList.setVisible(false);
				btnRemoveShoppingList.setVisible(false);
				btnRemove.setVisible(false);
				btnAdd.setVisible(false);
			}
		});
		
		//confirm deletion
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		//--------popup -----------------------------------
				Object[] options = {"Please continue",
		        "Cancel"};
				int result = JOptionPane.showOptionDialog(popFrame,
		"This action will permanently remove selected objects. Are you sure you want to proceed?",
		"Confirmation PopUp",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.WARNING_MESSAGE,
		null,     //do not use a custom Icon
		options,  //the titles of buttons
		options[0]); //default button title
		//----------popup setup ends -------------------------
				
				if(result == JOptionPane.YES_OPTION){
					RemoveFromList(Shoppingpanel, scrollPane);
					RemoveFromList(FridgePanel, scrollPane_1);
					SetCheckBoxesOn(FridgePanel, scrollPane_1,false);
					SetCheckBoxesOn(Shoppingpanel, scrollPane,false);
					btnNewButton.setVisible(false);
					btnCancel.setVisible(false);
					
					scrollPane.setVisible(true);
					scrollPane_1.setVisible(true);
					btnAddShoppingList.setVisible(true);
					btnRemoveShoppingList.setVisible(true);
					btnRemove.setVisible(true);
					btnAdd.setVisible(true);
				}
			}
		});
		
		
		//cancel deletion
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetCheckBoxesOn(FridgePanel, scrollPane_1,false);
				SetCheckBoxesOn(Shoppingpanel, scrollPane,false);
				btnNewButton.setVisible(false);
				btnCancel.setVisible(false);
				
				scrollPane.setVisible(true);
				scrollPane_1.setVisible(true);
				btnAddShoppingList.setVisible(true);
				btnRemoveShoppingList.setVisible(true);
				btnRemove.setVisible(true);
				btnAdd.setVisible(true);
			}
		});
	}
	
	
	//add items to both lists based on which list and which panel
	public void AddToList(JPanel currentPanel, String type, JScrollPane jPane,JButton confirm, String fridgeName){
		if(!confirm.isVisible()){
			JPanel childpanel = new JPanel();
			Button fridgeAccess = new Button();
			Checkbox confirmDelete = new Checkbox();
			
			Fridge fridge = null;
			ShopList shoplist = null;
			
			if(type.equals("Shopping List")){
				shoplist = new ShopList(fridgeName);
			}else{
				fridge = new Fridge(fridgeName, null);
			}
			
			fridgeAccess.setPreferredSize(new Dimension(100,75));
			fridgeAccess.setLabel(fridgeName);
			
			confirmDelete.setVisible(false);
			if(type.equals("Shopping List"))
				confirmDelete.setLabel("Remove Shopping List" + " " + fridgeName);
			else
				confirmDelete.setLabel("Remove Fridge" + " " +fridgeName);
			confirmDelete.setName("checkbox");
			
			
			childpanel.setName(fridgeName);
			
			if(fridge != null)
				fridgeData.add(fridge);
			
			if(shoplist != null)
				shopData.add(shoplist);
			
			childpanel.add(confirmDelete);
			childpanel.add(fridgeAccess);
			currentPanel.add(childpanel);
			
			
			Fridge tempFridge = fridge;
			ShopList tempShopList = shoplist;
			
			fridgeAccess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(type.equals("Shopping List")){	
						ProjectFrame.thisInstance.setContentPane(new ShoppingListView(tempShopList));
					}
					else{
						ProjectFrame.thisInstance.setContentPane(new ListView(tempFridge));	
					}
				}
			});
			
					
			UpdateScreens(currentPanel, jPane);
		}
	}
	
	
	
	
	
	//remove items from both lists
	public void RemoveFromList(JPanel currentPanel, JScrollPane jPane){
		
		if(currentPanel.getComponentCount() > 0){
		    Component[] components = currentPanel.getComponents();
		    
		    for(Component com : components) {
		    	Component[] imbedcomp = ((Container) com).getComponents();
		    	for(Component checkbox : imbedcomp){
		    		if(checkbox.getName().equals("checkbox") && ((Checkbox) checkbox).getState() == true){
		    			
		    			for(int i = 0; i<fridgeData.size(); i++)
		    				if(com.getName().equals(fridgeData.get(i).returnName()))
		    					fridgeData.remove(i);
		    			
		    			for(int i = 0; i<shopData.size(); i++)
		    				if(com.getName().equals(shopData.get(i).getName()))
		    					shopData.remove(i);
		    					
		    			currentPanel.remove(com); 
		    		}
		    	}
		    }
		    
		    	UpdateScreens(currentPanel, jPane);
		    
		}
		
	}
	
	
	
	//sets the checkboxes in the imbeded checkboxes active
	public void SetCheckBoxesOn(JPanel currentPanel, JScrollPane jPane, Boolean state){
		if(currentPanel.getComponentCount() > 0){
		    Component[] components = currentPanel.getComponents();
		    
		    for(Component com : components) {
		    	Component[] imbedcomp = ((Container) com).getComponents();
		    	for(Component checkbox : imbedcomp){
		    		if(checkbox.getName().equals("checkbox") && state){
		    			checkbox.setVisible(true); 
		    		}else if(checkbox.getName().equals("checkbox") && !state){
		    			checkbox.setVisible(false); 
		    			((Checkbox) checkbox).setState(false);
		    		}
		    	}
		    }
		    
		    	UpdateScreens(currentPanel, jPane);
		    
		}
		
	}
	
	
	
	
	//updates the screen to display the different fridges correctly
	public void UpdateScreens(JPanel currentPanel, JScrollPane jPane){
		jPane.setPreferredSize(jPane.getPreferredSize());
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
