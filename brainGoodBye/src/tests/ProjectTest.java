package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import brainGoodBye.Material;
import brainGoodBye.Project;
import brainGoodBye.Task;

/**
 * A class for testing the non getter and setter elements fo the project class
 * @author Hunter Lantz
 *
 */
public class ProjectTest {

	
	private Project p = new Project(new ArrayList<Material>(), new ArrayList<Task>(), "Test", "", "", 10.0, 25.0, new Date(), "Small", "Easy");
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testGetSpent() {
		p.addMaterial(new Material("",3,2.0,true));
		p.addMaterial(new Material("",3,2.0,false));
		assertTrue(p.getSpent()==6.0);
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testTotalCost() {
		p.addMaterial(new Material("",3,2.0,true));
		p.addMaterial(new Material("",3,2.0,false));
		assertTrue(p.totalCost()==12.0);
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testGetHoursDone() {
		p.addTask(new Task(10.5,"",true));
		p.addTask(new Task(4.0,"",false));
		assertTrue(p.getHoursDone()==10.5);
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testGetTotalHours() {
		p.addTask(new Task(10.5,"",true));
		p.addTask(new Task(4.0,"",false));
		assertTrue(p.getTotalHours()==14.5);
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testCloneAndEquals() {
		Project temp = p.clone();
		assertTrue(p.equals(temp));
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testEquals() {
		Project temp = new Project(new ArrayList<Material>(), new ArrayList<Task>(), "diff", "", "", 10.0, 25.0, new Date(), "Small", "Easy");
		assertFalse(p.equals(temp));
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testReplaceMaterial() {
		Material before = new Material("",3,2.0,true);
		Material after = new Material("",4,12.0,true);
		p.addMaterial(before);
		p.replaceMaterial(before, after);
		assertTrue(p.getSpent()==48.0);
	}
	/**
	 * @author Hunter Lantz
	 */
	@Test
	public void testReplaceTask() {
		Task before = new Task(3.0,"",true);
		Task after = new Task(12.0,"",true);
		p.addTask(before);
		p.replaceTask(before, after);
		assertTrue(p.getHoursDone()==12.0);
	}
	
	
}
