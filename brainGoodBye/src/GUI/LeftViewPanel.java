package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * 
 * @author Joey Hunt
 */
public class LeftViewPanel extends JPanel {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = -8231382840466474921L;
	
	private static final String CHANGE_OPTION = "Edit";
	
	private static final String SAVE_OPTION = "Save";
	
	/**
	 * Panel which displays the name of the project.
	 */
	private JPanel namePanel;
	
	/**
	 * Panel which allows the user to edit the description.
	 */
	private JPanel descriptionEditPanel;
	
	/**
	 * Panel which displays the description of the project.
	 */
	private JPanel descriptionPanel;
	
	private JPanel materialsEditPanel;
	
	private JPanel tasksEditPanel;
	
	/**
	 * Creates a LeftViewPanel.
	 * 
	 * @author Joey Hunt
	 */
	public LeftViewPanel() {
		namePanel = new JPanel();
		descriptionEditPanel = new JPanel();
		descriptionPanel = new JPanel();
		materialsEditPanel = new JPanel();
		tasksEditPanel = new JPanel();
		
		initialize();
	}
	
	/**
	 * Initializes the LeftViewPanel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		JTextField nameField = new JTextField("Name");
		nameField.setBorder(BorderFactory.createEmptyBorder());
		nameField.setBackground(new Color(0, 0, 0, 0));
		nameField.setEditable(false);
		JButton nameButton = new JButton(CHANGE_OPTION);
		
		nameButton.addActionListener(e -> {
			if (!nameField.isEditable()) {
				nameButton.setText(SAVE_OPTION);
				nameField.setEditable(true);
			} else {
				nameButton.setText(CHANGE_OPTION);
				nameField.setEditable(false);
			}
		});
		
		JLabel descriptionLabel = new JLabel("Description");
		JButton descriptionButton = new JButton(CHANGE_OPTION);
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setEditable(false);
		
		descriptionButton.addActionListener(e -> {
			if (!descriptionArea.isEditable()) {
				descriptionButton.setText(SAVE_OPTION);
				descriptionArea.setEditable(true);
			} else {
				descriptionButton.setText(CHANGE_OPTION);
				descriptionArea.setEditable(false);
			}
		});
		
		JLabel materialsLabel = new JLabel("Materials");
		JButton materialsButton = new JButton(CHANGE_OPTION);
		
		materialsButton.addActionListener(e -> {
			new MaterialsEditWindow();
		});
		
		JLabel tasksLabel = new JLabel("Task List");
		JButton tasksButton = new JButton(CHANGE_OPTION);
		
		tasksButton.addActionListener(e -> {
			new TaskListEditWindow();
		});
		
		namePanel.add(nameField);
		namePanel.add(nameButton);
		
		descriptionEditPanel.add(descriptionLabel);
		descriptionEditPanel.add(descriptionButton);
		descriptionPanel.setLayout(new BorderLayout());
		descriptionPanel.add(descriptionArea);
		
		materialsEditPanel.add(materialsLabel);
		materialsEditPanel.add(materialsButton);
		
		tasksEditPanel.add(tasksLabel);
		tasksEditPanel.add(tasksButton);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(namePanel);
		add(descriptionEditPanel);
		add(descriptionPanel);
		add(materialsEditPanel);
		add(tasksEditPanel);
	}
}
