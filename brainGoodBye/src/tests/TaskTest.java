package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import brainGoodBye.Task;

/**
 * This class tests the Test class for proper functionality.
 * 
 * @author Joey Hunt
 */
public class TaskTest {
	
	/**
	 * An instance of a Task for testing.
	 */
	Task myTask;
	
	/**
	 * A clone of myTask.
	 */
	Task cloneTask;

	/**
	 * Initializes the Task instance.
	 * 
	 * @author Joey Hunt
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myTask = new Task(10.0, "Important", false);
		cloneTask = myTask.clone();
	}

	/**
	 * Test method for {@link brainGoodBye.Task#hashCode()}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testHashCode() {
		assertEquals("The hashCode method created a bad hashcode!", myTask.hashCode(), cloneTask.hashCode());
	}

	/**
	 * Test method for {@link brainGoodBye.Task#clone()}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testClone() {
		assertNotSame("The clone method did not create a proper clone!", myTask, cloneTask);
		assertEquals("The clone method did not create a proper clone!", myTask, cloneTask);
	}

	/**
	 * Test method for {@link brainGoodBye.Task#equals(java.lang.Object)}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testEqualsDiff() {
		final Task task1 = new Task(myTask.getHoursToComplete(), myTask.getDescription(), true);
		final Task task2 = new Task(myTask.getHoursToComplete(), "Not", myTask.isDone());
		final Task task3 = new Task(11.0, myTask.getDescription(), myTask.isDone());
		
		assertFalse(myTask.equals(task1) || myTask.equals(task2) || myTask.equals(task3));
	}
	
	/**
	 * Test method for {@link brainGoodBye.Task#equals(java.lang.Object)}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testEqualsSame() {
		assertTrue("The equals method could not find equality!", myTask.equals(cloneTask));
		// Proves symmetry.
		assertTrue("The equals method could not find equality!", cloneTask.equals(myTask));
	}

}
