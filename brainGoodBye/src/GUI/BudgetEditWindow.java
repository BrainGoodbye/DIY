package GUI;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import brainGoodBye.Project;

/**
 * The concrete class to edit the budget
 * @author Thaddaeus
 *
 */
public class BudgetEditWindow extends AbstractEditWindow {
	
	private Project myProject;
	
	/**
	 * Auto generated UID
	 */
	private static final long serialVersionUID = 2064406369779819362L;
	
	JLabel previousSavingsPerMonthLabel;
	JLabel previousCostPerMonthLabel;
	
	JFormattedTextField savingsPerMonthTextField;
	JFormattedTextField costPerMonthTextField;
	
	/**
	 * Constructor for the concrete class for editing the budget
	 * @author Thaddaeus
	 */
	BudgetEditWindow(Project proj) {
		super(proj, "Edit Budget");
		myProject = proj;
		previousSavingsPerMonthLabel = new JLabel();
		previousSavingsPerMonthLabel.setText(String.valueOf("Previous savings-per-month: " + proj.getSavingsPerMonth()));
		previousCostPerMonthLabel = new JLabel();
		previousCostPerMonthLabel.setText("Previous cost-per-month: " + String.valueOf(proj.getCostPerMonth()));
		savingsPerMonthTextField = new JFormattedTextField(new DecimalFormat());
		costPerMonthTextField = new JFormattedTextField(new DecimalFormat());
		initialize();
	}
	
	/**
	 * @author Thaddaeus
	 * Set up the window for editing the budget
	 */
	private void initialize() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(previousSavingsPerMonthLabel);
		this.add(savingsPerMonthTextField);
		this.add(previousCostPerMonthLabel);
		this.add(costPerMonthTextField);
		this.setVisible(true);
		doEdits();
	}
	
	/**
	 * Make the changes to the values for the project attributes
	 */
	private void doEdits() {
		double cost = Double.parseDouble(costPerMonthTextField.getText());
		double savings = Double.parseDouble(savingsPerMonthTextField.getText());
		myProject.setCostPerMonth(cost);
		myProject.setSavingsPerMonth(savings);
	}
}
