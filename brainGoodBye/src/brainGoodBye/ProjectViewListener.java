package brainGoodBye;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class listens for changes to a project and sends the full project
 * 
 * @author Joey Hunt
 */
public class ProjectViewListener implements PropertyChangeListener {

	private Project myProject;
	
	private PropertyChangeSupport pcs;
	
	/**
	 * Creates a project view listener.
	 * 
	 * @author Joey Hunt
	 */
	public ProjectViewListener(final Project theProject) {
		myProject = theProject;
		pcs = new PropertyChangeSupport(this);
	}
	
	/**
	 * Adds a listener to an instance of this class.
	 * 
	 * @author Joey Hunt
	 * @param thePropertyName
	 * @param theListener
	 */
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        pcs.addPropertyChangeListener(thePropertyName, theListener);
    }
	
    /**
     * {@inheritDoc}
     * 
     * 
     * 
     * @author Joey Hunt
     */
	@Override
	public void propertyChange(final PropertyChangeEvent e) {
		if ("Name".equals(e.getPropertyName())) {
			myProject.setName((String)e.getNewValue());
		} else if ("Description".equals(e.getPropertyName())) {
			myProject.setDescription((String)e.getNewValue());
		} else if ("Save Project".equals(e.getPropertyName())) {
			pcs.firePropertyChange("Created Project", null, myProject);
			System.out.println("hi");
		} 
	}
}
