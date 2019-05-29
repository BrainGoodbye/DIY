package GUI;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Joey Hunt
 */
public class RightViewPanel extends JPanel {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = 5516273502639193358L;

	/**
	 * A panel for editing the budget.
	 */
	private JPanel budgetEditPanel;
	
	/**
	 * A panel for saving or quitting the view.
	 */
	private JPanel savePanel;
	
	/**
	 * A helper panel for savePanel.
	 */
	private JPanel innerSavePanel;
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 */
	public RightViewPanel() {
		budgetEditPanel = new JPanel();
		savePanel = new JPanel();
		innerSavePanel = new JPanel();
		
		initialize();
	}
	
	/**
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		JLabel budgetLabel = new JLabel("Budget");
		JButton budgetButton = new JButton("Edit");
		
		budgetButton.addActionListener(e -> {
			new BudgetEditWindow();
		});
		
		JButton saveQuitButton = new JButton("Save & Quit");
		
		saveQuitButton.addActionListener(e -> {
			//TODO don't make this a property change
			firePropertyChange("Save Project", false, true);
		});
		
		budgetEditPanel.add(budgetLabel);
		budgetEditPanel.add(budgetButton);
		
		savePanel.setLayout(new BorderLayout());
		savePanel.add(innerSavePanel, BorderLayout.SOUTH);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(budgetEditPanel);
	}
}
