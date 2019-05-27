package GUI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import brainGoodBye.FileManager;
import brainGoodBye.Project;

/**
 * This panel allows players to sort and search for thumbnails.
 * @author minor modifications: Thaddaeus
 * @author Joey Hunt
 */
public class SearchPanel extends JPanel implements PropertyChangeListener {

	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = 9015600827675719527L;
	
	/**
	 * An array of strings representing the ordering methods available.
	 */
	private static final String[] sortOptions = {"Cost", "Name"};
	
	/**
	 * A combo box containing sort options.
	 */
	private JComboBox<String> sortByBox;
	
	/**
	 * Creates a search panel.
	 * 
	 * @author Joey Hunt
	 */
	SearchPanel() {
		sortByBox = new JComboBox<>(sortOptions);
		
		initialize();
	}
	
	/**
	 * Initializes the search panel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		sortByBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				// Old item value is not used.
				firePropertyChange("Sort", null, e.getItem());
			}
		});
		
		add(sortByBox);
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
	}
	
//	/**
//	 * Sets the selected item of the Sort By box 
//	 * and fires an ItemEvent if successful.
//	 * 
//	 * @author Joey Hunt
//	 */
//	public void setSortBy(final String sortBy) {
//		sortByBox.setSelectedItem(sortBy);
//	}
	
	/**
	 * Returns the selected sorting option.
	 * 
	 * @author Joey Hunt
	 * @return The sorting option.
	 */
	public String getSelectedSort() {
		return (String)sortByBox.getSelectedItem();
	}

/**
 * @author Thaddaeus
 */
@Override
public void propertyChange(PropertyChangeEvent e) {
	if ("Import Settings".equals(e.getPropertyName())) {
		String newlyImportedString = (String) e.getNewValue();
		int indexOfNewlyImportedString = sortByBox.getSelectedIndex();
		for (int i = 0; i < sortOptions.length; i++) {
			if (newlyImportedString.equals(sortOptions[i])) {
				indexOfNewlyImportedString = i;
			}
		}
		sortByBox.setSelectedIndex(indexOfNewlyImportedString);
	}
}
}
