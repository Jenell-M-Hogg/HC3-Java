package Widgets;

import java.awt.Component;
import java.awt.event.ActionListener;
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
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Global.FridgeLocation;
import Global.ProjectFrame;
import Repository.Category;
import Repository.CategoryList;
import Repository.Item;
import Screens.FridgeView;
import Screens.ListView;
import Screens.ShoppingListView;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class AddItemPopup extends JPanel {

	CategoryList categoryList = CategoryList.getInstance();
	private JDatePickerImpl datePicker;
	/**
	 * Create the panel.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public AddItemPopup(Item item, String title) throws IOException, URISyntaxException {
		
		JTextField txtName;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel namePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) namePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(namePanel);
		
		JLabel lblName = new JLabel("Name: ");
		namePanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setEnabled(true);
		if (item == null) {
			txtName.setText("Enter item name");
		} else {
			txtName.setText(item.getName());
		}
		Item newItem = item;
		txtName.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	txtName.setEnabled(true);
	        	if (newItem == null){
	        		if (txtName.getText().equals("Enter item name")) {
	        			txtName.setText("");					
	        		}	
	        	}
	        }

			@Override
			public void focusLost(FocusEvent e) {
				txtName.setEnabled(true);
				if (txtName.getText().equals("")) {
					if (newItem == null) {
						txtName.setText("Enter item name");
					} else {
						txtName.setText(newItem.getName());
					}
				}				
			}
	    });
		namePanel.add(txtName);
		
		JFormattedTextField txtQuantity;
		
		JPanel quantityPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) quantityPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(quantityPanel);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		quantityPanel.add(lblQuantity);
		
		txtQuantity = new JFormattedTextField(NumberFormat.getNumberInstance());

		if (item != null){
			if (item.getQuantity() >= 0) {
				txtQuantity.setValue(item.getQuantity());
			}
		}
		
		txtQuantity.setColumns(10);
		txtQuantity.setToolTipText("This field must be a number.");
		
		txtQuantity.setEnabled(true);
		
		quantityPanel.add(txtQuantity);
		
		
		JTextField txtBestBefore;
		
		JPanel bestBeforePanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) bestBeforePanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(bestBeforePanel);
		
		JLabel lblBestBefore = new JLabel("Expected Best Before Date: ");
		bestBeforePanel.add(lblBestBefore);
		
		UtilDateModel model= new UtilDateModel();
		Properties p= new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel= new JDatePanelImpl(model, p);
		datePicker= new JDatePickerImpl(datePanel, new DateComponentFormatter());
		
		bestBeforePanel.add(datePicker);
		
		JPanel categoryPanel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) categoryPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
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
		
		if (item != null) {
			categoriesComboBox.setSelectedItem(item.getLocation());
		}
		
		categoryPanel.add(categoriesComboBox);
		
		JPanel locationPanel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) locationPanel.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
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
				title,
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
	        
	        boolean itemWasNull;
	        if (item == null) {
	        	itemWasNull = true;
	        	item = new Item(txtName.getText());
	        } else {
	        	itemWasNull = false;
		        item.setName(txtName.getText());
	        }
	        
	        if (txtQuantity.getValue() != null) {
	        	item.setQuantity(Integer.parseInt(txtQuantity.getText()));	
	        }
			
	        try {
			
	        	//TODO
	        String text= datePicker.getJFormattedTextField().getText();
	        
	        item.setBestBefore(text);
	        
	        
	        DateComponentFormatter d= new DateComponentFormatter();
	        GregorianCalendar b = (GregorianCalendar) d.stringToValue(text);
	        
	        Date bb = b.getTime();
	        Calendar today= new GregorianCalendar();
	        Date t= today.getTime();
	        
	        int countDown=item.daysBetween(bb, t);
			GregorianCalendar bestBefore = (GregorianCalendar) d.stringToValue(text);
		
			
			
			
			//item.setBestBefore(bestBefore);
			item.setCountDown(countDown);
			
			
	        } catch (Exception e) {
	        }
			
			Category category = new Category((String)categoriesComboBox.getSelectedItem());
			item.setCategory(category);
			
			item.setLocation(FridgeLocation.valueOf((String)locationsComboBox.getSelectedItem()));

			if (itemWasNull) {

				if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ListView){
					((ListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);
				} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ShoppingListView){
					((ShoppingListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);
				} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof FridgeView){
					((FridgeView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).addItem(item);

				}
			} else {
				if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ListView){
					((ListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).editItem(item);
				} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ShoppingListView){
					((ShoppingListView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).editItem(item);
				} else if(ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof FridgeView){
					((FridgeView)(ProjectFrame.thisInstance.getContentPane().getComponent(0))).editItem(item);

				}
			}
		}
	
	}

}
