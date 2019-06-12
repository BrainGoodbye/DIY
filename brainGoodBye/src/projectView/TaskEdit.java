package projectView;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskEdit extends JPanel {

	/**
	 * generated SUID
	 */
	private static final long serialVersionUID = 7393846468586263831L;
	
	private JTextField myDescription;
	private JTextField myHours;
	private JCheckBox myComplete;
	
	/**
	 * Initializes editable fields with "Description" and a value of zero.
	 * @author Jacob Ficker
	 */
	public TaskEdit() {
		super();
		myDescription = new JTextField("Description");
		myHours = new JTextField("0.0");
		myComplete = new JCheckBox();
		initialize();
	}
	
	/**
	 * Initializes the editable fields to contain specified values.
	 * This does not include the is complete check box.
	 * @author Jacob Ficker
	 * @param theDesc
	 * @param theHours
	 */
	public TaskEdit(String theDesc, Double theHours) {
		super();
		myDescription = new JTextField(theDesc);
		myHours = new JTextField(Double.toString(theHours));
		myComplete = new JCheckBox();
		initialize();
	}
	
	/**
	 * Initializes the editable fields to contain specified values.
	 * This constructor can also set whether or not the is complete checkbox is checked
	 * upon creating of the object.
	 * @author Jacob Ficker
	 * @param theDesc
	 * @param theHours
	 * @param complete
	 */
	public TaskEdit(String theDesc, Double theHours, boolean complete) {
		this(theDesc, theHours);
		myComplete.setSelected(complete);
		this.revalidate();
		this.repaint();
	}
	
	/**
	 * Sets up GUI elements
	 * @author Jacob Ficker
	 */
	private void initialize() {
		this.setLayout(new FlowLayout());
		myDescription.setColumns(40);
		myHours.setColumns(6);
		this.add(myDescription);
		this.add(myHours);
		this.add(new JLabel("Is Complete?"));
		this.add(myComplete);
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getDescription() {
		return myDescription.getText();
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getHoursToComplete() {
		Double d = Double.parseDouble(myHours.getText());
		return d;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public boolean isComplete() {
		return myComplete.isSelected();
	}
	
}
