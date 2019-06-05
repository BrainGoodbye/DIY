package GUI;

import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	JPanel myPanel;
	
	JLabel previousSavingsPerMonthLabel;
	JLabel previousCostPerMonthLabel;
	JLabel enterSavingsPerMonthLabel;
	JLabel enterCostPerMonthLabel;
	JLabel blankSpaceLabel;
	
	JFormattedTextField savingsPerMonthTextField;
	JFormattedTextField costPerMonthTextField;
	
	JButton saveAndCloseButton;
	JButton cancelButton;
	
	/**
	 * Constructor for the concrete class for editing the budget
	 * @author Thaddaeus
	 */
	BudgetEditWindow(Project proj) {
		super(proj, "Edit Budget");
		myProject = proj;
		myPanel = new JPanel();
		previousSavingsPerMonthLabel = new JLabel();
		previousSavingsPerMonthLabel.setText(String.valueOf("Previous savings-per-month: " + proj.getSavingsPerMonth()));
		previousCostPerMonthLabel = new JLabel();
		previousCostPerMonthLabel.setText("Previous cost-per-month: " + String.valueOf(proj.getCostPerMonth()));
		enterSavingsPerMonthLabel = new JLabel("Enter the new savings per month here");
		enterCostPerMonthLabel = new JLabel("Enter the new cost per month here");
		savingsPerMonthTextField = new JFormattedTextField(new DecimalFormat());
		costPerMonthTextField = new JFormattedTextField(new DecimalFormat());
		saveAndCloseButton = new JButton("Save and Close");
		cancelButton = new JButton("Cancel");
		blankSpaceLabel = new JLabel("   ");
		initialize();
	}
	
	/**
	 * @author Thaddaeus
	 * Set up the window for editing the budget
	 */
	private void initialize() {
		saveAndCloseButton.addActionListener(theEvent -> {
			save();
			this.dispose();
		});
		cancelButton.addActionListener(theEvent -> {
			this.dispose();
		});
		this.setContentPane(myPanel);
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(previousSavingsPerMonthLabel);
		myPanel.add(enterSavingsPerMonthLabel);
		myPanel.add(savingsPerMonthTextField);
		myPanel.add(blankSpaceLabel);
		myPanel.add(previousCostPerMonthLabel);
		myPanel.add(enterCostPerMonthLabel);
		myPanel.add(costPerMonthTextField);
		myPanel.add(saveAndCloseButton);
		myPanel.add(cancelButton);
	}
	
	/**
	 * @author Thaddaeus
	 * Make the changes to the values for the project attributes
	 */
	@Override
	public void save() {
		// if user does not successfully edit something, leave it as default
		double cost = myProject.getCostPerMonth();
		double savings = myProject.getSavingsPerMonth();
		try {
			cost = Double.parseDouble(costPerMonthTextField.getText());
			myProject.setCostPerMonth(cost);
		} catch (NumberFormatException e) {
			// just catch the exception, leave the field as it was
		}
			
		try {
			savings = Double.parseDouble(savingsPerMonthTextField.getText());	
			myProject.setSavingsPerMonth(savings);
		} catch (NumberFormatException e2) {
			// done editing
			return;
		}
	}
}
