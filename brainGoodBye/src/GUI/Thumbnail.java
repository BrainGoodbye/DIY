package GUI;

import javax.swing.JPanel;

import brainGoodBye.Project;

/**
 * This panel displays concise project information 
 * 
 * @author Joey Hunt
 */
public class Thumbnail extends JPanel {
	
	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = 2653951540567950260L;
	
	/**
	 * A project to display the information of.
	 */
	private Project myProject;
	
	/**
	 * Creates a thumbnail.
	 * 
	 * @author Joey Hunt
	 */
	Thumbnail(final Project project) {
		myProject = project; 
		
	}
	
	/**
	 * Returns the project associated with this thumbnail.
	 * 
	 * @author Joey Hunt
	 * @return This thumbnail's project.
	 */
	public Project getProject() {
		return myProject;
	}
}
