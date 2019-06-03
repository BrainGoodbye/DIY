package GUI;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import brainGoodBye.Project;

/**
 * 
 * @author Jacob Ficker
 *
 */
public abstract class AbstractEditWindow extends JFrame implements EditWindow{

	/**
	 * Generated SUID
	 */
	private static final long serialVersionUID = 1629704862110347913L;
	
	Project myProject;
	
	public AbstractEditWindow(Project theProj, String windowName) {
		super(windowName);
		myProject = theProj;
		
		//Experimental
		this.setVisible(true);
		//this.setUndecorated(true);
//		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 400);
	}
	
	
	
}
