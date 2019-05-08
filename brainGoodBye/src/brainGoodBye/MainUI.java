package brainGoodBye;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MainUI extends JFrame{

	JMenuBar menuBar;
	
	public MainUI() {
		super("Team BrainGoodbye DIY");
		AboutFrame ap = new AboutFrame();
		menuBar = new JMenuBar();
	}
	
	public void start() {
		//Basic setup
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
		
        //Add Stuff
		this.setJMenuBar(menuBar);
		
		//You Can SEE ME NOW
		this.setVisible(true);
	}
	
}
