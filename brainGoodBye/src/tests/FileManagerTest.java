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
	
	/**
	 * Becuase FileManager is a loosely-coupled, back-end class in a different package with private methods that need testing,
	 * an abnormal way to access its methods for testing is needed.
	 * Here, reflection is used, which works well but has the potential to throw many exceptions.
	 * Test method for {@link brainGoodBye.FileManager#serializeToFile()}.
	 * @author Thaddaeus
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testSerializeToFile() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		FileManager manager = new FileManager();
		Method method = FileManager.class.getDeclaredMethod("importSettings", String.class);
		method.setAccessible(true);
		// return type of importSettings is null, so no need to store its return value
		method.invoke(manager, "some input");
	}
	
	/**
	 * @author Thaddaeus
	 * Test method for {@link brainGoodBye.FileManager#deserializeFile()}.
	 */
	@Test
	public void testDeserializeFile() {

	}
	

}
