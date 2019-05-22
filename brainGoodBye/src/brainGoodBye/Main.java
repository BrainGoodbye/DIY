package brainGoodBye;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.HomeUI;

/**
 * @author Jacob Ficker
 * @author Thad Hug
 *
 * This class runs the program.
 */
public class Main {
	
	/**
	 * Initializes and starts the UI.
	 * 
	 * @param args Command-line arguments. Not used for this program.
	 */
	public static void main(String[] args) {
		 
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
		
		HomeUI app = new HomeUI();
		Version.getVersion();
		app.start();
	}
	
}
