package Global;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repository.Fridge;
import Repository.Item;
import Screens.FridgeView;
import Screens.ListView;
import Screens.MainMenu;

public class ProjectFrame extends JFrame {
	public static ProjectFrame thisInstance;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private static void fridgeTest(){
		try {
			
			
			Fridge fridge= new Fridge("My Fridge", FridgeType.SINGLE_DOOR);
			Item item;
			
			
			for(int i=0; i<10; i++){
				
				item= new Item("My Item "+Integer.toString(i));
				item.setLocation(FridgeLocation.FREEZER_BOTTOM);
				fridge.addItem(item);
			}
			
			for(int i=0; i<10; i++){
				
				item= new Item("My Item "+Integer.toString(i+10));
				item.setLocation(FridgeLocation.BOTTOM_SHELF);
				fridge.addItem(item);
			}
			
			ProjectFrame frame = new ProjectFrame();
			
			FridgeView fr= new FridgeView(fridge);
			thisInstance.setContentPane(fr);
			thisInstance.setMinimumSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
			thisInstance.pack();
			
			((FridgeView)thisInstance.getContentPane().getComponent(0)).initializeCompartments();
			((FridgeView)thisInstance.getContentPane().getComponent(0)).updateCompartments();
			
			
			thisInstance.setVisible(true);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {	
				//fridgeTest();
				ProjectFrame frame = new ProjectFrame();
				
				thisInstance.setContentPane(new MainMenu());
				thisInstance.setMinimumSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
				thisInstance.pack();
				
				thisInstance.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.thisInstance= this;
		
	}
	
	
	//Call this method to change the content pane
	public void setContentPane(JPanel panel){
		this.thisInstance.getContentPane().removeAll();
		this.thisInstance.getContentPane().add(panel);
		this.thisInstance.revalidate();
		this.thisInstance.repaint();
	}

}
