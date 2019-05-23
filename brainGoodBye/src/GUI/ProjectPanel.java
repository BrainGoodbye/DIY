package GUI;

import java.awt.Color;

import javax.swing.JPanel;


/**
 * @author Joey Hunt
 *
 * This panel displays concise project information and allows for the searching and ordering 
 * of this information.
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
	 * @author Joey Hunt
	 * 
	 * Creates a project panel.
	 */
	ProjectPanel() {
		searchPanel = new SearchPanel();
		thumbnailPanel = new ThumbnailPanel();
		
		initialize();
	}
	
	/**
	 * @author Joey Hunt
	 * 
	 * Initializes the project panel.
	 */
	private void initialize() {
		add(searchPanel);
		add(thumbnailPanel);
		
		setBackground(Color.WHITE);
	}
	
	public static int getSortBy() {
		return 1;
	}
	
	public static void setSortBy(int attributeNumber) {
		
	}
}
