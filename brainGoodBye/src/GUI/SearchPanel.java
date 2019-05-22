package GUI;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * @author Joey Hunt
 *
 * 
 */
public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015600827675719527L;
	
	/**
	 * 
	 */
	private static final String[] sortOptions = {"Cost"};
	
	/**
	 * 
	 */
	private JComboBox<String> sortByBox;
	
	
	/**
	 * 
	 */
	SearchPanel() {
		sortByBox = new JComboBox<>(sortOptions);
		
		initialize();
	}
	
	/**
	 * 
	 */
	private void initialize() {
		add(sortByBox);
	}
	
	/**
	 * 
	 * 
	 * @param sort An integer corresponding to the total ordering of Projects to use.
	 * @return
	 */
	public static int sortBy(int sort) {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int getSortBy() {
		return 0;
	}
}
