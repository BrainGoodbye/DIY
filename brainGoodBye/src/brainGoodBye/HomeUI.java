package brainGoodBye;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class HomeUI extends JFrame{

	/**
	 * generated UID
	 */
	private static final long serialVersionUID = -2836282326556330720L;
	
	TheMenuBar menuBar;
	
	public HomeUI() {
		super("Team BrainGoodbye DIY");
		menuBar = new TheMenuBar();
	}
	
	public void start() {
		//Basic setup
		this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
		
        menuBar.initialize();
        
        //Add Stuff
		this.setJMenuBar(menuBar);
		
		//You Can SEE ME NOW
		this.setVisible(true);
	}
	
}
