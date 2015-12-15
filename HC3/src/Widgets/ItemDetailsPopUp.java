package Widgets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Global.ProjectFrame;
import Repository.Item;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class ItemDetailsPopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Item item;
	private boolean edit;

	/**
	 * Launch the application.
	 * @return 
	 */
	public void LaunchDialog(Item item){
		try {
			ItemDetailsPopUp dialog = new ItemDetailsPopUp(item);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemDetailsPopUp(Item item) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemDetailsPopUp.class.getResource(item.getCategory().getIconLocation())));
		setTitle(item.getName());
		setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(ProjectFrame.thisInstance);
		this.item= item;
		
		setBounds(100, 100, 276, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][]", "[grow][grow][grow][grow][grow]"));
		{
			JLabel lblCategory = new JLabel("Category : " + item.getCategory().getName());
			lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblCategory, "cell 0 0,alignx trailing");
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label, "cell 1 0");
			label.setIcon(new ImageIcon(ItemDetailsPopUp.class.getResource(item.getCategory().getIconLocation())));
		}
		{
			try{
				JLabel lblProduce = new JLabel(item.getCategory().getName());
				contentPanel.add(lblProduce, "cell 2 0");
			}
			catch(Exception e){
				
			}
			
		}
		{
			JLabel lblBestBeforeDate = new JLabel("Best Before Date:");
			try{
				lblBestBeforeDate.setText(lblBestBeforeDate.getText()+" "+item.getBestBefore().toString());
			}
			catch(Exception e){
				lblBestBeforeDate.setText(lblBestBeforeDate.getText()+" -");
			}
			contentPanel.add(lblBestBeforeDate, "cell 0 1");
		}
		{
			JLabel lblCountdown = new JLabel("Countdown:");
			contentPanel.add(lblCountdown, "cell 0 2,alignx trailing");
		}
		{
			if(!(item.getBestBefore()==null)){
				ExpiryCountDown expiryCountDown = new ExpiryCountDown(item.getCountDown());
				contentPanel.add(expiryCountDown, "cell 1 2");
			}
			
		}
		{
			JLabel lblQuantity = new JLabel("Quantity:" );
			contentPanel.add(lblQuantity, "cell 0 3,alignx trailing");
		}
		{
			if(item.getQuantity()>0){
				JLabel label = new JLabel(Double.toString(item.getQuantity()));
				contentPanel.add(label, "cell 1 3");
			}
			
		}
		{
			JLabel label = new JLabel(item.getUnits());
			contentPanel.add(label, "cell 2 3");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
			{
				JButton editItem = new JButton("Edit/Add Details");
				editItem.addActionListener(new ActionListener(){

					

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						edit=true;
						try {
							EditItemDetailsPopUp editItemPopUp = new EditItemDetailsPopUp(item);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
					}
					
				});
				buttonPane.add(editItem);
				getRootPane().setDefaultButton(editItem);
			}
		}
		
		this.pack();
	}

}
