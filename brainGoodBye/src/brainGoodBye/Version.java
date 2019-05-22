package brainGoodBye;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Hunter Lantz
 * @author Thaddaeus Hug
 * 
 * This class represents the most recent version of our program.
 */
public final class Version {

	/**
	 * Contains the current version of the program.
	 */
	private static String VERSION="";
	
	/**
	 * Prevents instantiation.
	 */
	private Version() {
		
	}
	
	
	/**
	 * Sets the program version.
	 */
	public static void setVersion() {
		File file = new File("version.txt");
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				VERSION = VERSION + scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the program's current version.
	 * 
	 * @return The project version.
	 */
	public static String getVersion() {
		return VERSION;
	}

}
