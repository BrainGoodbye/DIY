package GUI;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import brainGoodBye.Project;

/**
 * This panel displays concise project information.
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
		
		initialize();
	}
	
	/**
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		final JLabel name = new JLabel(myProject.getName());
		
		add(name);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		//setPreferredSize(new Dimension(200, 100));
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
