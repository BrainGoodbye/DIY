package projectView;

import javax.swing.JFrame;

import brainGoodBye.Project;

/**
 * Implements basic functionality of an edit window for the concrete edit windows to extend from.
 * @author Jacob Ficker
 * @author Thaddaeus Hug
 */
public abstract class AbstractEditWindow extends JFrame implements EditWindow{

	/**
	 * Generated SUID
	 */
	private static final long serialVersionUID = 1629704862110347913L;
	
	Project myProject;
	
	/**
	 * @author Jacob Ficker
	 * @author Thaddaeus
	 * @param theProj
	 * @param windowName
	 */
	public AbstractEditWindow(Project theProj, String windowName) {
		super(windowName);
		myProject = theProj;
		
		//Experimental
		this.setVisible(true);
		this.setLocationRelativeTo(null);;
		//this.setUndecorated(true);
//		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 400);
	}
	
	
	
}
