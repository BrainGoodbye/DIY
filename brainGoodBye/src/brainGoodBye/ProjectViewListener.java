package brainGoodBye;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Joey Hunt
 */
public class ProjectViewListener implements PropertyChangeListener {

	private Project myProject;
	
	private PropertyChangeSupport pcs;
	
	/**
	 * 
	 * @author Joey Hunt
	 */
	public ProjectViewListener() {
		myProject = new Project(new ArrayList<>(), new ArrayList<>(), 
				"Test Project", "hello", "", 10.0, 20.0, new Date(), "Large", "Big");
		pcs = new PropertyChangeSupport(this);
	}
	
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        pcs.addPropertyChangeListener(thePropertyName, theListener);
    }
	
	@Override
	public void propertyChange(final PropertyChangeEvent e) {
		if ("Name".equals(e.getPropertyName())) {
			myProject.setName((String)e.getNewValue());
		} else if ("Description".equals(e.getPropertyName())) {
			myProject.setDescription((String)e.getNewValue());
		} else if ("Save Project".equals(e.getPropertyName())) {
			pcs.firePropertyChange("Added Project", null, myProject);
		}
	}

}
