package Widgets;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.LabelView;

import Global.Constants;
import Global.FridgeLocation;
import Global.ProjectFrame;
import Repository.Category;
import Repository.CategoryList;
import Repository.Item;
import Screens.FridgeView;
import Screens.ListView;
import Screens.MainMenu;
import Screens.ShoppingListView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ImageIcon;

public class HeaderBar extends JPanel {
	JButton rightButton;
	JButton middleButton;
	JButton leftButton;
	CategoryList categoryList = CategoryList.getInstance();
	
	/**
	 * Create the panel.
	 */
	public HeaderBar() {

		HeaderBar headerbar = this;

		this.setSize((int) (Constants.FRAME_WIDTH), Constants.FRAME_HEIGHT/15);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{133, 133, 133, 0};
		gridBagLayout.rowHeights = new int[]{40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		rightButton = new JButton("Add An Item");
		rightButton.setIcon(new ImageIcon(HeaderBar.class.getResource("/images/images/addIcon.png")));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 0;


		//Add action listener
		rightButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNewItem();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}



		});


		add(rightButton, gbc_addButton);

		middleButton = new JButton("Move/Remove Items");
		GridBagConstraints gbc_removeMoveButton = new GridBagConstraints();
		gbc_removeMoveButton.fill = GridBagConstraints.BOTH;
		gbc_removeMoveButton.insets = new Insets(0, 0, 0, 5);
		gbc_removeMoveButton.gridx = 1;
		gbc_removeMoveButton.gridy = 0;

		middleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO

			}



		});
		add(middleButton, gbc_removeMoveButton);

		leftButton = new JButton("Edit Fridge Details");
		GridBagConstraints gbc_editFridgeDetails = new GridBagConstraints();
		gbc_editFridgeDetails.fill = GridBagConstraints.BOTH;
		gbc_editFridgeDetails.gridx = 2;
		gbc_editFridgeDetails.gridy = 0;

		leftButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				ShoppingListView shoppingview = null;
				ListView listview = null;

				if(getParent() instanceof ListView){
					listview = (ListView)getParent();
				}else if(getParent() instanceof ShoppingListView){
					shoppingview = (ShoppingListView)getParent();
				}

				Object[] options = {"Confirm Name",
				"Remove Fridge"};

				Object[] optionsshop = {"Confirm Name",
				"Remove Shopping List"};

				JTextField Field = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("Enter New Name"));
				myPanel.add(Field);



				if(listview instanceof ListView){
					int answer = JOptionPane.showOptionDialog(null,
							myPanel,
							"Fridge Details",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,     //do not use a custom Icon
							options,  //the titles of buttons
							options[0]);

					if(answer == JOptionPane.YES_OPTION){
						MainMenu.mainmenuInstance.UpdateNameLabels(listview, null, Field.getText(),listview.getFridge().returnName());
						listview.getFridge().setNewName(Field.getText());
						listview.revalidate();
						listview.repaint();
					}else if(answer == JOptionPane.NO_OPTION){
						Object[] optionsalt2 = {"Please continue",
						"Cancel"};
						int result = JOptionPane.showOptionDialog(null,
								"This action will permanently remove selected objects. Are you sure you want to proceed?",
								"Confirmation PopUp",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE,
								null,     //do not use a custom Icon
								optionsalt2,  //the titles of buttons
								optionsalt2[0]); //default button title
						if(result == JOptionPane.YES_OPTION)
							MainMenu.mainmenuInstance.DestroyObject(listview, null,listview.getFridge().returnName());
					}
				}else if(shoppingview instanceof ShoppingListView){
					int answer = JOptionPane.showOptionDialog(null,
							myPanel,
							"Fridge Details",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,     //do not use a custom Icon
							optionsshop,  //the titles of buttons
							optionsshop[0]);

					if(answer == JOptionPane.YES_OPTION){
						MainMenu.mainmenuInstance.UpdateNameLabels(null, shoppingview, Field.getText(),shoppingview.getShopList().getName());
						shoppingview.getShopList().setName(Field.getText());
						shoppingview.revalidate();
						shoppingview.repaint();
					}else if(answer == JOptionPane.NO_OPTION){
						Object[] optionsalt = {"Please continue",
						"Cancel"};
						int result = JOptionPane.showOptionDialog(null,
								"This action will permanently remove selected objects. Are you sure you want to proceed?",
								"Confirmation PopUp",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE,
								null,     //do not use a custom Icon
								optionsalt,  //the titles of buttons
								optionsalt[0]); //default button title
						if(result == JOptionPane.YES_OPTION)
							MainMenu.mainmenuInstance.DestroyObject(null, shoppingview,shoppingview.getShopList().getName());
					}

				}


			}



		});
		add(leftButton, gbc_editFridgeDetails);



	}


	private void addNewItem() throws IOException, URISyntaxException, ParseException {
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
		
		/*locationsComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"FREEZER_TOP",
				"FREEZER_BOTTOM",
				"FREEZER_DOOR",
				"TOP_SHELF",
				"MIDDLE_SHELF",
				"BOTTOM_SHELF",
				"CRISPER_RIGHT",
				"CRISPER_LEFT",
				"DOOR_TOP",
				"DOOR_MIDDLE",
				"DOOR_BOTTOM"}));*/
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
	        	item.setQuantity((double)txtQuantity.getValue());	
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

			if(getParent() instanceof ListView){
				listView = (ListView)getParent();
				listView.getFridge().addItem(item);
			} else if(getParent() instanceof ShoppingListView){
				shoppingListView = (ShoppingListView)getParent();
				shoppingListView.getShopList().addItem(item);
			} else if(getParent() instanceof FridgeView){
				fridgeView = (FridgeView)getParent();
				fridgeView.getFridge().addItem(item);
			}
		}
	}

}
