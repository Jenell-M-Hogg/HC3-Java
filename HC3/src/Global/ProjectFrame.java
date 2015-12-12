package Global;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repository.Fridge;
import Repository.Item;
import Screens.MainMenu;
import Screens.Test;
import Screens.ListView;

public class ProjectFrame extends JFrame {
	public static ProjectFrame thisInstance;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {	
				try {
					
					
				
					ProjectFrame frame = new ProjectFrame();
					
					thisInstance.setContentPane(new MainMenu());
					thisInstance.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
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
