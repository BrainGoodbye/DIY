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
	 * A list of thumbnails.
	 */
	private List<Thumbnail> myThumbnails;
	
	private String mySort = "Cost";
	
	/**
	 * Creates the thumbnail panel.
	 * 
	 * @author Joey Hunt
	 */
	ThumbnailsPanel() {
		myThumbnails = new ArrayList<>();
		initialize();
	}
	
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
<<<<<<< HEAD
	 * @author Hunter
	 * @author Joey Hunt
=======
	 * @author Hunter Lantz
	 * @author Joey Hunt (Minor edits)
>>>>>>> c45fbfddaab858f0bcf7ec7662a960bd90b1d1fe
	 * @param thumbnail
	 */
	public void addThumbnail(final Thumbnail thumbnail) {
		Thumbnail temp = null;
		for(Thumbnail thumb : myThumbnails) {
			if(thumb.getProject()== thumbnail.getProject()) {
				temp = thumb;
			}
		}
		if(temp!=null)myThumbnails.remove(temp);
		myThumbnails.add(thumbnail);
		for(Thumbnail thumb: myThumbnails) {
			thumb.addPropertyChangeListener(thumbnail);
			thumbnail.addPropertyChangeListener(thumb);
		}
		sortBy(mySort);
		revalidate();
		repaint();
	}
	/**
	 * @author Hunter
	 * @param thumbnail thumbnail to remove
	 */
	public void removeThumbnail(Thumbnail thumbnail) {
		myThumbnails.remove(thumbnail);
		this.remove(thumbnail);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Sorts the project thumbnails according to user selection.
	 * @author Hunter
	 * @author Joey Hunt
	 * @param selection A String corresponding to the total ordering of Thumbnails to use.
	 */
	public void sortBy(final String selection) {
		mySort=selection;
		this.removeAll();
		switch(selection) {
		case "Cost":
			Collections.sort(myThumbnails, (t1, t2) -> {
				return (int) (t1.getProject().getCostPerMonth() - t2.getProject().getCostPerMonth());
			});
		case "Name":
			Collections.sort(myThumbnails, (t1, t2) -> {
				return (int) (t1.getProject().getName().compareTo(t2.getProject().getName()));
			});
		}
		
		createThumbnails();
		this.revalidate();
		this.repaint();
	}

	/**
	 * @Author Hunter
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if("Sort".equals(evt.getPropertyName())) {
			sortBy((String) evt.getNewValue());
		}
	}
}
