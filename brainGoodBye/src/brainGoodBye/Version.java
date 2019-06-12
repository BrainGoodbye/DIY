package brainGoodBye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * This class represents the most recent version of our program.
 * 
 * @author Hunter Lantz
 * @author Thaddaeus Hug
 * @author Joey Hunt (minor edits)
 */
public final class Version {

	/**
	 * Contains the current version of the program.
	 */
	private static String VERSION="";
	
	/**
	 * Prevents instantiation.
	 * 
	 * @author Thad Hug
	 */
	private Version() {
		
	}
	
	/**
	 * Sets the program version.
	 * 
	 * @author Thad Hug
	 * @author Joey Hunt (minor edits)
	 */
	public static void setVersion() {
		final StringBuilder builder = new StringBuilder();
		
		try (InputStreamReader inputStream = new InputStreamReader(Version.class.
				getResourceAsStream("/version.txt"));
				BufferedReader reader = new BufferedReader(inputStream)) {
			reader.lines().forEach(line -> {
				builder.append(line);
			});
			
			VERSION = builder.toString();
		} catch (final IOException e) {
			JOptionPane.showMessageDialog(null, "Error: version could not be found.");
		}
	}
	
	/**
	 * Returns the program's current version.
	 * 
	 * @author Thad Hug
	 * @return The project version.
	 */
	public static String getVersion() {
		return VERSION;
	}

}
