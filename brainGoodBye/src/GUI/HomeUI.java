package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import brainGoodBye.FileManager;

/**
 * This class represents the initial UI of the program.
 * 
 * @author Jacob Ficker
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
	
	final OptionsPanel optionsPanel;
	
	final FileManager fileManager;
	
	/**
	 * Initializes the home UI of the program.
	 */
	public HomeUI() {
		super("Team BrainGoodbye DIY");
		menuBar = new TheMenuBar();
		optionsPanel = new OptionsPanel();
		fileManager = new FileManager();
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
        
        optionsPanel.addPropertyChangeListener(fileManager);
        
        //Add Stuff
		this.setJMenuBar(menuBar);
		
		this.add(optionsPanel, BorderLayout.EAST);
		
		this.add(new ProjectPanel(), BorderLayout.CENTER);
		
		this.getContentPane().setBackground(Color.WHITE);
		//You Can SEE ME NOW
		this.setVisible(true);
	}
	
}
