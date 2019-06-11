package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import brainGoodBye.Version;

/**
 * Tests the Version class for proper functionality.
 * 
 * @author Joey Hunt
 * @author Thad Hug
 */
public class VersionTest {

	/**
	 * Test method for {@link brainGoodBye.Version#setVersion()}.
	 * 
	 * @author Thad Hug
	 * @author Joey Hunt (initial version)
	 */
	@Test
	public void testSetVersion() {
//		StringBuilder version1 = new StringBuilder();
//		
//		File file = new File("version.txt");
//		try {
//			Scanner scanner = new Scanner(file);
//			
//			while(scanner.hasNextLine()) {
//				version1.append(scanner.nextLine());
//			}
//			
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		Version.setVersion();
		
		String version2 = Version.getVersion();
		
		assertTrue("The file version.txt was not read correctly!", version2.toString().contains("Version"));
		assertTrue("The file version.txt was not read correctly!", version2.toString().contains("Authors"));
	}

}
