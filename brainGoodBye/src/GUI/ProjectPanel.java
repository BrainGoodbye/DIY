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
 * @author minor edits: Thaddaeus
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
	private ThumbnailsPanel thumbnailPanel;
	
	/**
	 * 
	 */
	private List<Project> myProjects;
	
	/**
	 * 
	 */
	private FileManager myManager;

	/**
	 * Creates a project panel.
	 * 
	 * @author Joey Hunt
	 */
	ProjectPanel(final FileManager manager) {
		searchPanel = new SearchPanel();
		thumbnailPanel = new ThumbnailsPanel();
		myProjects = new ArrayList<>();
		myManager = manager;
		
		initialize();
	}
	
	/**
	 * Initializes the project panel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		searchPanel.addPropertyChangeListener(myManager);
		myManager.addPropertyChangeListener((PropertyChangeListener) searchPanel);
		
		setLayout(new BorderLayout());
		
		add(searchPanel, BorderLayout.PAGE_START);
		add(thumbnailPanel);
		
		setBackground(Color.WHITE);
	}
	
//	/**
//	 * 
//	 * 
//	 * @author Joey Hunt
//	 * @return
//	 */
//	public List<Project> getProjects() {
//		return myProjects;
//	}
//	
//	/**
//	 * 
//	 * 
//	 * @author Joey Hunt
//	 * @param theProjects
//	 */
//	public void setProjects(final List<Project> theProjects) {
//		myProjects = theProjects;
//	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("New".equals(e.getPropertyName())) {
			//TODO open an instance of ProjectView
			final Project test = new Project(new ArrayList<>(), new ArrayList<>(), 
					"Test Project", "hello", "", 10.0, 20.0);
			
			myProjects.add(test);
			thumbnailPanel.addThumbnail(new Thumbnail(test));
			
			firePropertyChange("Added Project", null, myProjects);
			
			revalidate();
			repaint();
		} else if ("Delete".equals(e.getPropertyName())) {
			//TODO delete a selected project
			if (!myProjects.isEmpty()) {
				myProjects.remove(0);
				thumbnailPanel.removeAll();
				
				revalidate();
				repaint();
			}
		} else if ("Import All".equals(e.getPropertyName())) {
			myProjects = (List<Project>)e.getNewValue();
			
			thumbnailPanel.removeAll();
			
			for (final Project project: myProjects) {
			thumbnailPanel.addThumbnail(new Thumbnail(project));
			}
			
			revalidate();
			repaint();
		}
	}
}
