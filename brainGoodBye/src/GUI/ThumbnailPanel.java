package GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import brainGoodBye.Thumbnail;

/**
 * This panel contains the concise views of projects.
 * 
 * @author Joey Hunt
 */
public class ThumbnailPanel extends JPanel {

	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = 5108160806805172073L;
	
	/**
	 * A pane which holds the thumbnails.
	 */
	private JScrollPane scrollPane;
	
	/**
	 * A list of concise project views.
	 */
	private List<Thumbnail> thumbnails;
	
	/**
	 * Creates the thumbnail panel.
	 * 
	 * @author Joey Hunt
	 */
	ThumbnailPanel() {
		scrollPane = new JScrollPane();
		thumbnails = new ArrayList<>();
		
		initialize();
	}
	
	/**
	 * Initializes the thumbnail panel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		add(scrollPane);
	}
	
	/**
	 * Sorts the project thumbnails according to user selection.
	 * 
	 * @author Joey Hunt
	 * @param selection A String corresponding to the total ordering of Thumbnails to use.
	 */
	public void sortBy(final String selection) {
		switch(selection) {
		case "Cost":
			Collections.sort(thumbnails, (t1, t2) -> {
				return (int) (t1.getProject().getCostPerMonth() - t2.getProject().getCostPerMonth());
			});
		}
	}
}
