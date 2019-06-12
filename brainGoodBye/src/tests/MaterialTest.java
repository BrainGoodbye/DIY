package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import brainGoodBye.Material;

/**
 * This class tests the Material class for proper functionality.
 * 
 * @author Joey Hunt
 */
public class MaterialTest {
	
	/**
	 * An instance of a Material for testing.
	 */
	Material myMaterial;
	
	/**
	 * A clone of myMaterial.
	 */
	Material cloneMaterial;

	/**
	 * @author Joey Hunt
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myMaterial = new Material("Wood", 10, 15.0, true);
		cloneMaterial = myMaterial.clone();
	}

	/**
	 * Test method for {@link brainGoodBye.Material#hashCode()}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testHashCode() {
		assertEquals("The hashCode method created a bad hashcode!", myMaterial.hashCode(), cloneMaterial.hashCode());
	}

	/**
	 * Test method for {@link brainGoodBye.Material#clone()}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testClone() {
		assertNotSame("The clone method did not create a proper clone!", myMaterial, cloneMaterial);
		assertEquals("The clone method did not create a proper clone!", myMaterial, cloneMaterial);
	}

	/**
	 * Test method for {@link brainGoodBye.Material#equals(java.lang.Object)}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testEqualsDiff() {
		final Material material1 = new Material(myMaterial.getName(), myMaterial.getQuantity(), 
				myMaterial.getPrice(), !myMaterial.isAcquired());
		final Material material2 = new Material(myMaterial.getName(), myMaterial.getQuantity(), 
				myMaterial.getPrice() + 1.0, myMaterial.isAcquired());
		final Material material3 = new Material(myMaterial.getName(), myMaterial.getQuantity() + 1, 
				myMaterial.getPrice(), !myMaterial.isAcquired());
		final Material material4 = new Material("Pizza", myMaterial.getQuantity(), 
				myMaterial.getPrice(), !myMaterial.isAcquired());
		
		assertFalse(myMaterial.equals(material1) || myMaterial.equals(material2) 
				|| myMaterial.equals(material3) || myMaterial.equals(material4));
	}
	
	/**
	 * Test method for {@link brainGoodBye.Material#equals(java.lang.Object)}.
	 * 
	 * @author Joey Hunt
	 */
	@Test
	public void testEqualsSame() {
		assertTrue("The equals method could not find equality!", myMaterial.equals(cloneMaterial));
		// Proves symmetry.
		assertTrue("The equals method could not find equality!", cloneMaterial.equals(myMaterial));
	}
}
