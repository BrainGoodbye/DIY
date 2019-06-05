package tests;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import brainGoodBye.FileManager;

/**
 * A class for testing the FileManager class
 * @author Thaddaeus
 *
 */
public class FileManagerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	/**
	 * Becuase FileManager is a loosely-coupled, back-end class in a different package with private methods that need testing,
	 * an abnormal way to access its methods for testing is needed.
	 * Here, reflection is used, which works well but has the potential throw many exceptions.
	 * Test method for {@link brainGoodBye.FileManager#importSettings()}.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testImportSettings() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		FileManager manager = new FileManager();
		Method method = FileManager.class.getDeclaredMethod("importSettings", String.class);
		method.setAccessible(true);
		String output = (String) method.invoke(manager, "some input");
	}
	
	/**
	 * Test method for {@link brainGoodBye.FileManager#importSettings()}.
	 */
	@Test
	public void testExportSettings() {

	}
	
	/**
	 * Test method for {@link brainGoodBye.FileManager#importAll()}.
	 */
	@Test
	public void testImportAll() {

	}
	
	/**
	 * Test method for {@link brainGoodBye.FileManager#exportAll()}.
	 */
	@Test
	public void testExportAll() {

	}
	

}
