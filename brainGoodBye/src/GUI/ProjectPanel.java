package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import brainGoodBye.FileManager;
import brainGoodBye.Project;


/**
 * This panel displays concise project information and allows for the searching and ordering 
 * of this information.
 * 
 * @author Joey Hunt
 */
public class ProjectPanel extends JPanel implements PropertyChangeListener {

	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = -5768616998602501013L;
	
	/**
	 * A panel for finding and sorting project thumbnails.
	 */
	private JPanel searchPanel;
	
	/**
	 * A panel which displays project thumbnails.
	 */
	private JPanel thumbnailPanel;
	
	/**
	 * 
	 */
	private List<Project> myProjects;

	/**
	 * Creates a project panel.
	 * 
	 * @author Joey Hunt
	 */
	ProjectPanel() {
		searchPanel = new SearchPanel();
		thumbnailPanel = new ThumbnailsPanel();
		myProjects = new ArrayList<>();
		
		initialize();
	}
	
	/**
	 * Initializes the project panel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		// Second instance of FileManager (first in HomeUI) for testing purposes.
		FileManager fileManager = new FileManager();
		
		searchPanel.addPropertyChangeListener(fileManager);
		
		setLayout(new BorderLayout());
		
		add(searchPanel, BorderLayout.PAGE_START);
		add(thumbnailPanel);
		
		// Test project
		myProjects.add(new Project(new ArrayList<>(), new ArrayList<>(), 
				"Test Project", "hello", "", 10.0, 20.0));
		
		thumbnailPanel.add(new Thumbnail(myProjects.get(0)));
		
		setBackground(Color.WHITE);
	}
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 * @return
	 */
	public List<Project> getProjects() {
		return myProjects;
	}
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 * @param theProjects
	 */
	public void setProjects(final List<Project> theProjects) {
		myProjects = theProjects;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
