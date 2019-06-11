package tests;

import static org.junit.Assert.*;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import brainGoodBye.FileManager;
import brainGoodBye.Material;
import brainGoodBye.Project;
import brainGoodBye.Task;

/**
 * A class for testing the FileManager class
 * Becuase FileManager is a loosely-coupled, back-end class in a different package with private methods that need testing,
 * an abnormal way to access its methods for testing is needed.
 * Here, reflection is used, which works well but has the potential to throw many exceptions.
 * @author Thaddaeus
 *
 */
public class FileManagerTest {
	
	/**
	 * Because serializeToFile and deserializeFile are used only in tandem, this test tests both of these methods.
	 * First, it creates a list of projects. Second, it serializes the projects. Third, it deserializes the projects.
	 * Fourth, it verifies that what was deserialized equals what was serialized.
	 * Test method for {@link brainGoodBye.FileManager#serializeToFile()}.
	 * @author Thaddaeus
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void testSerializeToFile() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		List<Project> myProjectsReplace = new ArrayList<Project>();
		
		Material mat1 = new Material("a mat", 2, 20.2, true);
		Material mat2 = new Material("a mat", 2, 50.8, true);
		Material mat3 = new Material("a mat", 2, 80.2, true);
		Material mat4 = new Material("a mat", 2, 50.1, true);
		List<Material> matList1 = new ArrayList<Material>();
		List<Material> matList2 = new ArrayList<Material>();
		List<Material> matList3 = new ArrayList<Material>();
		List<Material> matList4 = new ArrayList<Material>();
		matList1.add(mat1);
		matList1.add(mat4);
		matList1.add(mat3);
		matList2.add(mat4);
		matList2.add(mat1);
		matList3.add(mat1);
		matList3.add(mat2);
		matList4.add(mat4);
		
		Task task1 = new Task(5.0, "descr");
		Task task2 = new Task(7.0, "descr");
		Task task3 = new Task(13.0, "descr");
		Task task4 = new Task(17.0, "descr");
		List<Task> taskList1 = new ArrayList<Task>();
		List<Task> taskList2 = new ArrayList<Task>();
		List<Task> taskList3 = new ArrayList<Task>();
		List<Task> taskList4 = new ArrayList<Task>();
		taskList1.add(task1);
		taskList1.add(task4);
		taskList2.add(task2);
		taskList3.add(task3);
		taskList3.add(task1);
		taskList4.add(task4);
		
		Project proj1 = new Project(matList1, taskList1, "aName", "desc", "img", 1.00, 3.50, new Date(), "small", "small");
		Project proj2 = new Project(matList2, taskList2, "bName", "desc", "img", 1.00, 4.50, new Date(), "small", "small");
		Project proj3 = new Project(matList3, taskList3, "cName", "desc", "img", 1.00, 2.50, new Date(), "small", "small");
		Project proj4 = new Project(matList4, taskList4, "dName", "desc", "img", 1.00, 2.50, new Date(), "small", "small");
		
		myProjectsReplace.add(proj1);
		myProjectsReplace.add(proj2);
		myProjectsReplace.add(proj3);
		myProjectsReplace.add(proj4);

		FileManager manager = new FileManager();
		// using Java's Reflection libraries to access private methods and fields
        Field myProjectsOrigin = FileManager.class.getDeclaredField("myProjects");
        myProjectsOrigin.setAccessible(true);
        myProjectsOrigin.set(manager, myProjectsReplace); // replace the class's myProjects list with the above created myProjects list

		Method serializeToFileAccess = FileManager.class.getDeclaredMethod("serializeToFile", File.class);
		serializeToFileAccess.setAccessible(true);
		File file = new File("testFile.txt");
		serializeToFileAccess.invoke(manager, file); // save to a file
		myProjectsOrigin.set(manager, null); // remove the class's myProjects list. It should be saved in a file now.
		
		Method deserializeFile = FileManager.class.getDeclaredMethod("deserializeFile", File.class);
		deserializeFile.setAccessible(true);
		
		deserializeFile.invoke(manager, file); // put the saved data back into memory
		
		@SuppressWarnings("unchecked")
		List<Project> myProjectsFinal = (List<Project>) myProjectsOrigin.get(manager); // get the projects list newly loaded from disk
		for (int i = 0; i < myProjectsReplace.size(); i++) {
			// if all asserts pass, then every deserialized project was identical to every serialized project
			assertTrue(myProjectsFinal.get(i).equals(myProjectsFinal.get(i))); 
		}

	}
}
