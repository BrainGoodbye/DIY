package tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import GUI.OptionsPanel;
import GUI.Thumbnail;
import GUI.ThumbnailsPanel;
import brainGoodBye.Material;
import brainGoodBye.Project;
import brainGoodBye.Task;

/**
 * A class for testing the ThumbnailsPanel class
 * @author Thaddaeus
 *
 */
public class ThumbnailsPanelTest {

	/**
	 * Test method for {@link GUI.ThumbnailsPanel#sortBy()}.
	 * Becuase ThumbnailsPanel is a loosely-coupled class in a different package with private methods that need testing,
	 * an abnormal way to access its methods for testing is needed.
	 * Here, reflection is used, which works well but has the potential to throw many exceptions.
	 * @author Thaddaeus
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public final void testSortBy() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		// setting up Thumbnail objects to be sorted by ThumbnailsPanel's sortBy()
		OptionsPanel optionsPanel = new OptionsPanel();
		ThumbnailsPanel panel = new ThumbnailsPanel();
		
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

		List<Thumbnail> thumbsList = new ArrayList<Thumbnail>();
		thumbsList.add(new Thumbnail(proj1, optionsPanel));
		thumbsList.add(new Thumbnail(proj2, optionsPanel));
		thumbsList.add(new Thumbnail(proj3, optionsPanel));
		thumbsList.add(new Thumbnail(proj4, optionsPanel));

		
		// using Java's Reflection libraries to access private methods and fields
        Field thumbnails = ThumbnailsPanel.class.getDeclaredField("myThumbnails");
        thumbnails.setAccessible(true);
        thumbnails.set(panel, thumbsList); // replace the class's thumbnail list with the above created thumbnail list

		Method sort = ThumbnailsPanel.class.getDeclaredMethod("sortBy", String.class);
		sort.setAccessible(true);
		
		@SuppressWarnings("unchecked")
		List<Thumbnail> thumbs = (List<Thumbnail>) thumbnails.get(panel); // get a reference to the class's thumbnail list field (private)
		
		// check that thumbnails are properly sorted by Cost
        sort.invoke(panel, "Cost");
        for (int i = 0; i < thumbs.size() - 1; i++) {
        	assertTrue(thumbs.get(i).getProject().totalCost() <= thumbs.get(i + 1).getProject().totalCost());
        }
        
		// check that thumbnails are properly sorted by Time
        sort.invoke(panel, "Time");
        for (int i = 0; i < thumbs.size() - 1; i++) {
        	assertTrue(thumbs.get(i).getProject().getTotalHours() <= thumbs.get(i + 1).getProject().getTotalHours());
        }
        
		// check that thumbnails are properly sorted by Name
        sort.invoke(panel, "Name");
        for (int i = 0; i < thumbs.size() - 1; i++) {
        	assertTrue(thumbs.get(i).getProject().getName().compareTo(thumbs.get(i + 1).getProject().getName()) <= 0);
        }
	}

}
