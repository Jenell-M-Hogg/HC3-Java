package Widgets;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Global.FridgeLocation;
import Global.ProjectFrame;
import Repository.Category;
import Repository.CategoryList;
import Repository.Item;
import Screens.FridgeView;
import Screens.ListView;
import Screens.ShoppingListView;

public class AddItemPopup extends JPanel {

	CategoryList categoryList = CategoryList.getInstance();
	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public AddItemPopup() throws IOException, URISyntaxException {

		JTextField txtName;
		
		JPanel namePanel = new JPanel();
		add(namePanel);
		
		JLabel lblName = new JLabel("Name: ");
		namePanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setEnabled(true);
		txtName.setText("Enter item name");
		txtName.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	txtName.setEnabled(true);
	        	if (txtName.getText().equals("Enter item name")) {
					txtName.setText("");					
				}	
	        }

			@Override
			public void focusLost(FocusEvent e) {
				txtName.setEnabled(true);
				if (txtName.getText().equals("")) {
					txtName.setText("Enter item name");					
				}				
			}
	    });
		namePanel.add(txtName);
		
		JFormattedTextField txtQuantity;
		
		JPanel quantityPanel = new JPanel();
		add(quantityPanel);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		quantityPanel.add(lblQuantity);
		
		txtQuantity = new JFormattedTextField(NumberFormat.getNumberInstance());
		//txtQuantity.setValue(new Double(-1));
		txtQuantity.setColumns(10);
		txtQuantity.setToolTipText("This field must be a number.");
		
		//txtQuantity = new JTextField();
		txtQuantity.setEnabled(true);
		//txtQuantity.setText("Enter item name");
		
		quantityPanel.add(txtQuantity);
		
		
		JTextField txtBestBefore;
		
		JPanel bestBeforePanel = new JPanel();
		add(bestBeforePanel);
		
		JLabel lblBestBefore = new JLabel("Expected Best Before Date: ");
		bestBeforePanel.add(lblBestBefore);
		
		txtBestBefore = new JTextField();
		txtBestBefore.setEnabled(true);
		txtBestBefore.setText("ddmmyyyy");
		txtBestBefore.setToolTipText("This field should be entered in the form of \"ddmmyyyy\".");
		txtBestBefore.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	txtBestBefore.setEnabled(true);
	        	if (txtBestBefore.getText().equals("ddmmyyyy")) {
	        		txtBestBefore.setText("");					
				}	
	        }

			@Override
			public void focusLost(FocusEvent e) {
				txtBestBefore.setEnabled(true);
				if (txtBestBefore.getText().equals("")) {
					txtBestBefore.setText("ddmmyyyy");					
				}				
			}
	    });
		bestBeforePanel.add(txtBestBefore);
		
		JPanel categoryPanel = new JPanel();
		add(categoryPanel);
		
		JLabel lblCategory = new JLabel("Category: ");
		categoryPanel.add(lblCategory);
		
		JComboBox categoriesComboBox = new JComboBox();
		
		ArrayList<Category> catList = categoryList.getCategories();
		Category[] catArray = catList.toArray(new Category[catList.size()]);
		String[] catNames = new String[catArray.length];
		for (int i = 0; i<catArray.length; i++) {
			catNames[i] = catArray[i].getName();
		}
		categoriesComboBox.setModel(new DefaultComboBoxModel(catNames));
		categoryPanel.add(categoriesComboBox);
		
		JPanel locationPanel = new JPanel();
		add(locationPanel);
		
		JLabel lblLocation = new JLabel("Location: ");
		locationPanel.add(lblLocation);

		JComboBox locationsComboBox = new JComboBox();
		
		locationsComboBox.setModel(new DefaultComboBoxModel(FridgeLocation.names()));
		locationPanel.add(locationsComboBox);
				
		Object complexMsg[] = { "Please enter desired item details below: ", 
				namePanel,
				quantityPanel,
				bestBeforePanel,
				categoryPanel,
				locationPanel};
		
		Object[] options = {"Confirm"};
		int answer = JOptionPane.showOptionDialog(null,
				complexMsg,
				"Add Item",
				JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.PLAIN_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]);
		
		ListView listView = null;
		ShoppingListView shoppingListView = null;
		FridgeView fridgeView = null;

		if(answer == JOptionPane.OK_OPTION){
	        if (txtName.getText().equals("Enter item name")) {
				txtName.setText("");					
			}
	        Item item = new Item(txtName.getText());
	        
	        if (txtQuantity.getValue() != null) {
	        	item.setQuantity(Integer.parseInt(txtQuantity.getText()));	
	        }
			
	        try {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			Calendar today = new GregorianCalendar();
			Calendar bestBefore = new GregorianCalendar();
			String day1 = "02122015";
			String day2 = txtBestBefore.getText();
			Date date = sdf.parse(day1);
			today.setTime(date);
			date = sdf.parse(day2);
			bestBefore.setTime(date);
			item.setBestBefore(date);

			int countDown = item.daysBetween(today.getTime(),bestBefore.getTime());
			item.setCountDown(countDown);
	        } catch (Exception e) {
	        }
			
			Category category = new Category((String)categoriesComboBox.getSelectedItem());
			item.setCategory(category);
			
			item.setLocation(FridgeLocation.valueOf((String)locationsComboBox.getSelectedItem()));

			if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ListView){
				((ListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);
			} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ShoppingListView){
				((ShoppingListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);
				
				//shoppingListView.addItem(item);
			} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof FridgeView){
				((FridgeView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);
				
			}
		}
	
	}

}
