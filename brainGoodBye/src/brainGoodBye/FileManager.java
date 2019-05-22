package brainGoodBye;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Thaddaeus
 *
 */
public final class FileManager {
	
	private FileManager() {}
	
	/**
	 * @author Thaddaeus
	 * @throws IOException 
	 */
	public void exportSettings() throws IOException {
		int sortByAttribute = GUI.ProjectPanel.getSortBy();
		File file = new File("settings.txt");
	    FileWriter fileWriter = new FileWriter("settings.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(sortByAttribute);
	    printWriter.close();
	    fileWriter.close();
	}
	
	
	/**
	 * @author Thaddaeus
	 */
	public void importSettings() {
		File file = new File("settings.txt");
		int sortByAttribute = -1;
		try {
			Scanner scanner = new Scanner(file);
			GUI.ProjectPanel.setSortBy(scanner.nextInt());
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * @author Thaddaeus
//	 */
//	exportAll(List<Project> projects) {
//		
//	}
//	
//	/**
//	 * @author Thaddaeus
//	 */
//	List<Project> importAll() {
//		
//	}

}
