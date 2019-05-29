package GUI;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import brainGoodBye.Project;

/**
 * 
 * @author Jacob Ficker
 *
 */
public abstract class AbstractEditWindow extends JFrame{

	/**
	 * Generated SUID
	 */
	private static final long serialVersionUID = 1629704862110347913L;
	
	Project myProject;
	
	public AbstractEditWindow(Project theProj) {
		myProject = theProj;
		
		//Experimental
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public Project getChanges() {
		return myProject.clone();
	}
	
	
	
}
