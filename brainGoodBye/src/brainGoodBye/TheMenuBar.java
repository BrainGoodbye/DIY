package brainGoodBye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TheMenuBar extends JMenuBar {

	private final JMenu help;
	
	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = 8057480567908033934L;

	
	public TheMenuBar() {
		super();
		help = new JMenu();
	}
	
	public void initialize() {
		
		//File Menu Items
		
		//Edit Menu Items
		
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
