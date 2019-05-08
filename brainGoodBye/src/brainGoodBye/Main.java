package brainGoodBye;

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
		HomeUI app = new HomeUI();
		Version.getVersion();
		app.start();
	}
	
}
