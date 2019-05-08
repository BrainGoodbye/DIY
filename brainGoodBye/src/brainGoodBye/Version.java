package brainGoodBye;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Version {

	private static String VERSION="";
	
	private Version() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			setVersion();
			System.out.println(getVersion());
	}
	
	public static void setVersion() {
		File file = new File("version.txt");
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				VERSION+=scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getVersion() {
		return VERSION;
	}

}
