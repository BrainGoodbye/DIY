package homeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author Jacob Ficker
 * 
 * This class represents the menu bar of the program.
 */
public class TheMenuBar extends JMenuBar {

	/**
	 * A help menu.
	 */
	private final JMenu help;
	
	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = 8057480567908033934L;

	/**
	 * @author Jacob Ficker
	 * Instantiates the menu bar.
	 */
	public TheMenuBar() {
		super();
		help = new JMenu("Help");
	}
	
	/**
	 * @author Jacob Ficker
	 * Populates the menu bar with menus.
	 */
	public void initialize() {
		
		//Help Menu Items
		final JMenuItem about = new JMenuItem("About...");
        about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            AboutFrame af = new AboutFrame();				
			}
        });
		
		help.add(about);
		
		this.add(help);
	}
	
}
