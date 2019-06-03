package brainGoodBye;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.HomeUI;

/**
 * @author Jacob Ficker
 * @author Thad Hug
 * @author Hunter Lantz
 * @author Joey Hunt (Minor edits)
 *
 * This class runs the program.
 */
public class Main {
	
	/**
	 * Initializes and starts the UI.
	 * 
	 * @author Hunter Lantz
	 * @param args Command-line arguments. Not used for this program.
	 */
	public static void setLookAndFeel() {
		 
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        //UIManager.put("swing.boldMetal", Boolean.FALSE);
		
		
	}
	
  /**
  * Starts the GUI.
  * 
  * @author Thad Hug
  * @author Joey Hunt (Minor edits)
  * @param theArgs Command line arguments. Not used for this program.
  */
	public static void main(final String... theArgs) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				setLookAndFeel();
				HomeUI app = new HomeUI();
				Version.getVersion();
				app.start();
			}
		});
	}
	
}
