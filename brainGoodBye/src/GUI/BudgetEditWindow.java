package GUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import brainGoodBye.Project;

/**
 * The concrete class to edit the budget
 * @author Thaddaeus
 *
 */
public class BudgetEditWindow extends AbstractEditWindow {
	/**
	 * Auto generated UID
	 */
	private static final long serialVersionUID = 2064406369779819362L;
	
	JLabel previousSavingsPerMonthLabel;
	JLabel previousCostPerMonthLabel;
	JTextArea savingsPerMonthTextArea;
	JTextArea costPerMonthTextArea;
	
	/**
	 * Constructor for the concrete class for editing the budget
	 * @author Thaddaeus
	 */
	BudgetEditWindow(Project proj, String name) {
		super(proj, name);
		previousSavingsPerMonthLabel = new JLabel();
		previousCostPerMonthLabel = new JLabel();
		savingsPerMonthTextArea = new JTextArea();
		costPerMonthTextArea = new JTextArea();
		
		// 2 text fields
		// savings per month & cost per month
	}
}
