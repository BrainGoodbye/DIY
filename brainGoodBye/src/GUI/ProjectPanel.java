package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * @author Joey Hunt
 *
 * 
 */
public class ProjectPanel extends JPanel {

	/**
	 * A default serial UID.
	 */
	private static final long serialVersionUID = -5768616998602501013L;
	
	/**
	 * 
	 */
	private JScrollPane scrollPane;
	
	/**
	 * 
	 */
	private JPanel searchPanel;
	
	/**
	 * 
	 */
	private JPanel thumbnailPanel;

	/**
	 * 
	 */
	ProjectPanel() {
		scrollPane = new JScrollPane();
		searchPanel = new SearchPanel();
		thumbnailPanel = new JPanel();
		
		initialize();
	}
	
	/**
	 * 
	 */
	private void initialize() {
		thumbnailPanel.add(scrollPane);
		
		add(searchPanel);
		add(thumbnailPanel);
	}
	
	public static int getSortBy() {
		return 1;
	}
	
	public static void setSortBy(int attributeNumber) {
		
	}
}
