package Widgets;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Global.Constants;
import Global.ProjectFrame;
import Screens.ListView;
import Screens.MainMenu;
import Screens.ShoppingListView;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;

public class HeaderBar extends JPanel {
	JButton rightButton;
	JButton middleButton;
	JButton leftButton;
	
	
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
				addNewItem();
				
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
				
				Object[] options = {"Confirm Name",
		        "Remove Fridge"};
				
			      JTextField Field = new JTextField(5);

			      JPanel myPanel = new JPanel();
			      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			      myPanel.add(new JLabel("enter new name"));
			      myPanel.add(Field);

	int answer = JOptionPane.showOptionDialog(null,
	myPanel,
	"Fridge Details",
	JOptionPane.YES_NO_OPTION,
	JOptionPane.QUESTION_MESSAGE,
	null,     //do not use a custom Icon
	options,  //the titles of buttons
	options[0]);
			
			ListView listview = (ListView)getParent();
			
			if(answer == JOptionPane.YES_OPTION){
				System.out.println("change name: " + Field.getText());
				listview.getFridge().setNewName(Field.getText());
				headerbar.revalidate();
				headerbar.repaint();
			}else if(answer == JOptionPane.NO_OPTION){
				ProjectFrame.thisInstance.setContentPane(MainMenu.mainmenuInstance);
				
			}
				
			}


			
		});
		add(leftButton, gbc_editFridgeDetails);
		
		

	}
	
	
	private void addNewItem() {
		// TODO Auto-generated method stub
		
	}

}
