package Widgets;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Global.Constants;
import Global.ProjectFrame;
import Repository.Fridge;
import Screens.FridgeView;
//import Screens.FridgeMainView;
import Screens.ListView;
import Screens.MainMenu;
import Screens.ShoppingListView;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BottomBar extends JPanel {

	JButton homeButton;
	JButton changeViewButton;
	JButton searchByCategoryButton;
	private JTextField txtGfhgfhg;
	
	/**
	 * Create the panel.
	 * @param aView 
	 */
	public BottomBar(String currentScreen) {
		String homeIconLocation = "/images/Home.png";
		String listViewIconLocation = "/images/ListIcon.png";
		String fridgeViewIconLocation = "/images/singledoorIcon.png";
		
		this.setSize((int) (Constants.FRAME_WIDTH), Constants.FRAME_HEIGHT/15);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 60, 100, 160};
		gridBagLayout.rowHeights = new int[] {40};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
		
		homeButton = new JButton();
		homeButton.setIcon(new ImageIcon(BottomBar.class.getResource(homeIconLocation)));
		GridBagConstraints gbc_homeButton = new GridBagConstraints();
		gbc_homeButton.fill = GridBagConstraints.BOTH;
		gbc_homeButton.insets = new Insets(5, 5, 5, 5);
		gbc_homeButton.gridx = 0;
		gbc_homeButton.gridy = 0;
		
		
		//Add action listener
		homeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//go to main menu
				ProjectFrame.thisInstance.setContentPane(MainMenu.mainmenuInstance);
			}
		});

		add(homeButton, gbc_homeButton);
		
		changeViewButton = new JButton();
		if (currentScreen.equals("FridgeView")) {
			changeViewButton.setVisible(true);
			changeViewButton.setIcon(new ImageIcon(BottomBar.class.getResource(listViewIconLocation)));
		} else if (currentScreen.equals("ListView")) {
			changeViewButton.setVisible(true);
			changeViewButton.setIcon(new ImageIcon(BottomBar.class.getResource(fridgeViewIconLocation)));
		} else {
			changeViewButton.setVisible(false);
		}
		GridBagConstraints gbc_changeViewButton = new GridBagConstraints();
		gbc_changeViewButton.fill = GridBagConstraints.BOTH;
		gbc_changeViewButton.insets = new Insets(5, 0, 5, 5);
		gbc_changeViewButton.gridx = 1;
		gbc_changeViewButton.gridy = 0;
		
		changeViewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof FridgeView) {
					//set to listView
					FridgeView fridgeView = (FridgeView) ProjectFrame.thisInstance.getContentPane().getComponent(0);
					Fridge fridge = fridgeView.getFridge();
					ListView listView;
					listView = new ListView(fridge);
					ProjectFrame.thisInstance.setContentPane(listView);
				} else if (ProjectFrame.thisInstance.getContentPane().getComponent(0) instanceof ListView) {
					//set to fridgeView
					Fridge fridge;
					FridgeView fridgeView;
					ListView listView = (ListView) ProjectFrame.thisInstance.getContentPane().getComponent(0);
					fridge = listView.getFridge();
					try {
						fridgeView = new FridgeView(fridge);
						ProjectFrame.thisInstance.setContentPane(fridgeView);
						((FridgeView)ProjectFrame.thisInstance.getContentPane().getComponent(0)).updateCompartments();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}	
		});
		add(changeViewButton, gbc_changeViewButton);
		
		searchByCategoryButton = new JButton("Search Category");
		GridBagConstraints gbc_searchByCategoryButton = new GridBagConstraints();
		gbc_searchByCategoryButton.insets = new Insets(5, 0, 5, 0);
		gbc_searchByCategoryButton.fill = GridBagConstraints.BOTH;
		gbc_searchByCategoryButton.gridx = 2;
		gbc_searchByCategoryButton.gridy = 0;
		
		searchByCategoryButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Open the search category pop-up
			}
		});
		add(searchByCategoryButton, gbc_searchByCategoryButton);
		
		txtGfhgfhg = new JTextField();
		txtGfhgfhg.setEnabled(true);
		txtGfhgfhg.setText("Enter text to search");
		txtGfhgfhg.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	txtGfhgfhg.setEnabled(true);
	        	if (txtGfhgfhg.getText().equals("Enter text to search")) {
					txtGfhgfhg.setText("");					
				}	
	        }

			@Override
			public void focusLost(FocusEvent e) {
				txtGfhgfhg.setEnabled(true);
				if (txtGfhgfhg.getText().equals("")) {
					txtGfhgfhg.setText("Enter text to search");					
				}				
			}
	    });
		GridBagConstraints gbc_txtGfhgfhg = new GridBagConstraints();
		gbc_txtGfhgfhg.insets = new Insets(5, 5, 4, 5);
		gbc_txtGfhgfhg.fill = GridBagConstraints.BOTH;
		gbc_txtGfhgfhg.gridx = 3;
		gbc_txtGfhgfhg.gridy = 0;
		add(txtGfhgfhg, gbc_txtGfhgfhg);
		txtGfhgfhg.setColumns(10);

	}
}
