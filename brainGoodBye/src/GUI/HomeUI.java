package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

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
     * The default toolkit.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /**
     * The size of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /**
     * The initial size of the frame.
     */
    private static final Dimension FRAME_SIZE = new Dimension(SCREEN_SIZE.width / 2, 
                                                              SCREEN_SIZE.height / 2);
	
	/**
	 * A menu bar for the program.
	 */
	private final TheMenuBar menuBar;
	
	/**
	 * 
	 */
	private final OptionsPanel optionsPanel;
	
	/**
	 * 
	 */
	private final FileManager fileManager;
	
	/**
	 * 
	 */
	private final ProjectPanel projectPanel;
	
	/**
	 * Initializes the home UI of the program.
	 * 
	 * @author Jacob Ficker
	 * @author Joey Hunt
	 * @author Hunter Lantz
	 */
	public HomeUI() {
		super("Team BrainGoodbye DIY");
		menuBar = new TheMenuBar();
		fileManager = new FileManager();
		optionsPanel = new OptionsPanel();
		projectPanel = new ProjectPanel(fileManager, optionsPanel);
	}
	
	/**
	 * Starts the GUI.
	 * 
	 * @author Jacob Ficker
	 * @author Joey Hunt
	 * @author Hunter Lantz
	 */
	public void start() {
		//Basic setup

        setSize(FRAME_SIZE);
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
                                 SCREEN_SIZE.height / 2 - getHeight() / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
		
        menuBar.initialize();
        
        optionsPanel.addPropertyChangeListener(fileManager);
        optionsPanel.addPropertyChangeListener(projectPanel);
        projectPanel.addPropertyChangeListener("Added Project", fileManager);
        fileManager.addPropertyChangeListener("Import All", projectPanel);
        
        //Add Stuff
		this.setJMenuBar(menuBar);
		
		this.add(optionsPanel, BorderLayout.EAST);
		
		this.add(projectPanel, BorderLayout.CENTER);
		
		this.getContentPane().setBackground(Color.WHITE);
		//You Can SEE ME NOW
		this.setVisible(true);
	}
	
}
