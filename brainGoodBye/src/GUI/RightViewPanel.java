package GUI;

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

	private JPanel budgetEditPanel;
	
	/**
	 * 
	 * 
	 * @author Joey Hunt
	 */
	public RightViewPanel() {
		budgetEditPanel = new JPanel();
		
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
			//new BudgetEditWindow();
		});
		
		budgetEditPanel.add(budgetLabel);
		budgetEditPanel.add(budgetButton);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(budgetEditPanel);
	}
}
