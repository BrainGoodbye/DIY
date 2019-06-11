package homeUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import brainGoodBye.FileManager;
import brainGoodBye.Project;
import projectView.ProjectView;


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
	
	private OptionsPanel myOptions;

	/**
	 * Creates a project panel.
	 * @author Hunter
	 * @author Joey Hunt
	 */
	ProjectPanel(final FileManager manager, OptionsPanel options) {
		searchPanel = new SearchPanel();
		thumbnailPanel = new ThumbnailsPanel();
		myProjects = new ArrayList<>();
		myManager = manager;
		myOptions = options;
		initialize();
	}
	
	/**
	 * Initializes the project panel.
	 * @author Hunter Lantz
	 * @author Joey Hunt
	 */
	private void initialize() {
		JScrollPane scroller = new JScrollPane(thumbnailPanel);
		
		searchPanel.addPropertyChangeListener(myManager);
		myManager.addPropertyChangeListener((PropertyChangeListener) searchPanel);
		searchPanel.addPropertyChangeListener(thumbnailPanel);
		
		setLayout(new BorderLayout());
		
		add(searchPanel, BorderLayout.PAGE_START);
		add(scroller);
		
		setBackground(Color.WHITE);
	}

	
	/**
	 * @author Hunter
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("New".equals(e.getPropertyName())) {
			final ProjectView view = new ProjectView();
			
			view.getViewListener().addPropertyChangeListener("Created Project", this);
			//addPropertyChangeListener("Created Project", view.getViewListener());
		} else if ("Created Project".equals(e.getPropertyName())) {
			final Project project = (Project)e.getNewValue();
			if(!myProjects.contains(project)) {
				myProjects.add(project);
			}
			firePropertyChange("Added Project", null, myProjects);
			thumbnailPanel.addThumbnail(new Thumbnail(project, myOptions));
			revalidate();
			repaint();
		} else if ("Delete".equals(e.getPropertyName())) {
			Thumbnail thumb = (Thumbnail)e.getNewValue();
			//if (!myProjects.isEmpty()) {
				myProjects.remove(thumb.getProject());
				thumbnailPanel.removeThumbnail(thumb);
				
				revalidate();
				repaint();
			//}
		} else if ("Import All".equals(e.getPropertyName())) {
			myProjects = (List<Project>)e.getNewValue();
			
			thumbnailPanel.removeAll();
			
			for (final Project project: myProjects) {
			thumbnailPanel.addThumbnail(new Thumbnail(project, myOptions));
			}
			
			revalidate();
			repaint();
		} else if("Edit".equals(e.getPropertyName())) {
			final ProjectView view = new ProjectView(((Thumbnail) e.getNewValue()).getProject());
			
			view.getViewListener().addPropertyChangeListener("Created Project", this);
		}
	}
}
