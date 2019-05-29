package GUI;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import brainGoodBye.Project;

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
	
	private Project myProject;
	
	private JFrame myParent;
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 */
	public RightViewPanel(final JFrame theParent, final Project theProject) {
		myParent = theParent;
		budgetEditPanel = new JPanel();
		savePanel = new JPanel();
		innerSavePanel = new JPanel();
		myProject = theProject;
		
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
			new BudgetEditWindow(myProject);
		});
		
		JButton saveQuitButton = new JButton("Save & Quit");
		JButton quitButton = new JButton("Quit");
		
		saveQuitButton.addActionListener(e -> {
			firePropertyChange("Save Project", false, true);
			myParent.dispatchEvent(new WindowEvent(myParent, WindowEvent.WINDOW_CLOSING));
			
		});
		
		quitButton.addActionListener(e -> {
			myParent.dispatchEvent(new WindowEvent(myParent, WindowEvent.WINDOW_CLOSING));
		});
		
		budgetEditPanel.add(budgetLabel);
		budgetEditPanel.add(budgetButton);
		
		innerSavePanel.add(saveQuitButton);
		innerSavePanel.add(quitButton);
		
		savePanel.setLayout(new BorderLayout());
		savePanel.add(innerSavePanel, BorderLayout.SOUTH);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(budgetEditPanel);
		add(savePanel);
	}
}
