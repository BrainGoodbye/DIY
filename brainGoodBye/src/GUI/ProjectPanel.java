package GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import brainGoodBye.FileManager;
import brainGoodBye.Project;


/**
 * This panel displays concise project information and allows for the searching and ordering 
 * of this information.
 * 
 * @author Joey Hunt
 */
public class ProjectPanel extends JPanel {

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
	 * Creates a project panel.
	 * 
	 * @author Joey Hunt
	 */
	ProjectPanel() {
		searchPanel = new SearchPanel();
		thumbnailPanel = new ThumbnailsPanel();
		
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
		
		add(searchPanel);
		add(thumbnailPanel);
		
//		// Test project
//		final Project dummy = new Project(new ArrayList<>(), new ArrayList<>(), 
//				"Example", "hi", "", 10.0, 20.0);
//		
//		thumbnailPanel.add(new Thumbnail(dummy));
		
		setBackground(Color.WHITE);
	}
}
