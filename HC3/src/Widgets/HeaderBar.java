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
	//CategoryList categoryList = CategoryList.getInstance();
	
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
		JPanel addItemPopup = new AddItemPopup();
		add(addItemPopup);
	}
}
