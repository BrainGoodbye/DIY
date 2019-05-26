package GUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import brainGoodBye.Project;

/**
 * This panel contains the concise views of projects.
 * 
 * @author Joey Hunt
 */
public class ThumbnailsPanel extends JPanel implements PropertyChangeListener {

	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = 5108160806805172073L;
	
	/**
	 * A pane which holds the thumbnails.
	 */
	private JScrollPane scrollPane;
	
	/**
	 * A list of thumbnails.
	 */
	private List<Thumbnail> myThumbnails;
	
	/**
	 * Creates the thumbnail panel.
	 * 
	 * @author Joey Hunt
	 */
	ThumbnailsPanel() {
		scrollPane = new JScrollPane();
		myThumbnails = new ArrayList<>();
		
		initialize();
	}
	
//	/**
//	 * Creates the thumbnail panel.
//	 * 
//	 * @author Joey Hunt
//	 */
//	ThumbnailsPanel(final List<Project> theProjects) {
//		scrollPane = new JScrollPane();
//		myProjects = new ArrayList<>();
//		
//		initialize();
//	}
	
	/**
	 * Initializes the thumbnail panel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//add(scrollPane);
		
		createThumbnails();
	}
	
	/**
	 * Adds each thumbnail to the panel.
	 * 
	 * @author Joey Hunt
	 */
	private void createThumbnails() {
		for (final Thumbnail thumbnail: myThumbnails) {
			add(thumbnail);
		}
	}
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 * @param thumbnail
	 */
	public void addThumbnail(final Thumbnail thumbnail) {
		myThumbnails.add(thumbnail);
		add(thumbnail);
		
		revalidate();
		repaint();
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
			Collections.sort(myThumbnails, (t1, t2) -> {
				return (int) (t1.getProject().getCostPerMonth() - t2.getProject().getCostPerMonth());
			});
		}
		
		createThumbnails();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
}
