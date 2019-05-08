package brainGoodBye;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * @author Jacob Ficker
 * 
 * This class represents the initial UI of the program.
 */
public class HomeUI extends JFrame {

	/**
	 * Automatically-generated serial ID.
	 */
	private static final long serialVersionUID = -2836282326556330720L;
	
	/**
	 * A menu bar for the program.
	 */
	final TheMenuBar menuBar;
	
	/**
	 * Initializes the home UI of the program.
	 */
	public HomeUI() {
		super("Team BrainGoodbye DIY");
		menuBar = new TheMenuBar();
	}
	
	/**
	 * Starts the GUI.
	 */
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
