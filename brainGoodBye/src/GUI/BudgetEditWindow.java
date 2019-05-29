package GUI;

import javax.swing.BoxLayout;
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
		previousSavingsPerMonthLabel.setText(String.valueOf(proj.getSavingsPerMonth()));
		previousCostPerMonthLabel = new JLabel();
		previousCostPerMonthLabel.setText(String.valueOf(proj.getCostPerMonth()));
		savingsPerMonthTextArea = new JTextArea();
		costPerMonthTextArea = new JTextArea();
		initialize();
		// 2 text fields
		// savings per month & cost per month
	}
	
	/**
	 * @author Thaddaeus
	 * Set up the window for editing the budget
	 */
	private void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(previousSavingsPerMonthLabel);
		this.add(savingsPerMonthTextArea);
		this.add(previousCostPerMonthLabel);
		this.add(costPerMonthTextArea);
	}
}
