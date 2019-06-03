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

import brainGoodBye.Project;

/**
 * This class presents the name, description, materials, 
 * and task list of a project, and allows them to be edited.
 * 
 * @author Joey Hunt
 */
public class LeftViewPanel extends JPanel {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = -8231382840466474921L;
	
	/**
	 * Represents the state in which an attribute can be edited.
	 */
	private static final String CHANGE_OPTION = "Edit";
	
	/**
	 * Represents the state in which an attribute can be saved.
	 */
	private static final String SAVE_OPTION = "Save";
	
	/**
	 * A non-visible color.
	 */
	private static final Color EMPTY_COLOR = new Color(0, 0, 0, 0);
	
	/**
	 * A panel which displays the name of the project.
	 */
	private JPanel namePanel;
	
	/**
	 * A panel which allows the user to edit the description.
	 */
	private JPanel descriptionEditPanel;
	
	/**
	 * A panel which displays the description of the project.
	 */
	private JPanel descriptionPanel;
	
	/**
	 * A panel which allows the user to edit the materials.
	 */
	private JPanel materialsEditPanel;
	
	/**
	 * A panel which displays the materials.
	 */
	private JPanel materialsPanel;
	
	/**
	 * A panel which allows the user to edit the task list.
	 */
	private JPanel tasksEditPanel;
	
	/**
	 * A panel which  displays the task list.
	 */
	private JPanel tasksPanel;
	
	/**
	 * The project of this view.
	 */
	private Project myProject;
	
	/**
	 * Creates a LeftViewPanel.
	 * 
	 * @author Joey Hunt
	 */
	public LeftViewPanel(final Project theProject) {
		namePanel = new JPanel();
		descriptionEditPanel = new JPanel();
		descriptionPanel = new JPanel();
		materialsEditPanel = new JPanel();
		materialsPanel = new JPanel();
		tasksEditPanel = new JPanel();
		tasksPanel = new JPanel();
		myProject = theProject;
		
		initialize();
	}
	
	/**
	 * Initializes the LeftViewPanel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		JTextField nameField = new JTextField(myProject.getName());
		nameField.setBorder(BorderFactory.createEmptyBorder());
		nameField.setBackground(EMPTY_COLOR);
		nameField.setEditable(false);
		JButton nameButton = new JButton(CHANGE_OPTION);
		
		nameButton.addActionListener(e -> {
			if (nameField.isEditable()) {
				nameButton.setText(CHANGE_OPTION);
				nameField.setEditable(false);
				nameField.setBorder(BorderFactory.createEmptyBorder());
				nameField.setBackground(EMPTY_COLOR);
				firePropertyChange("Name", null, nameField.getText());
			} else {
				nameButton.setText(SAVE_OPTION);
				nameField.setEditable(true);
				nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				nameField.setBackground(Color.WHITE);
			}
		});
		
		JLabel descriptionLabel = new JLabel("Description");
		JButton descriptionButton = new JButton(CHANGE_OPTION);
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.append(myProject.getDescription());
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setBackground(Color.LIGHT_GRAY);
		
		descriptionButton.addActionListener(e -> {
			if (descriptionArea.isEditable()) {
				descriptionButton.setText(CHANGE_OPTION);
				descriptionArea.setEditable(false);
				descriptionArea.setBackground(Color.LIGHT_GRAY);
				firePropertyChange("Description", null, descriptionArea.getText());
			} else {
				descriptionButton.setText(SAVE_OPTION);
				descriptionArea.setEditable(true);
				descriptionArea.setBackground(Color.WHITE);
			}
		});
		
		JLabel materialsLabel = new JLabel("Materials");
		JButton materialsButton = new JButton(CHANGE_OPTION);
		
		materialsButton.addActionListener(e -> {
			new MaterialsEditWindow(myProject);
		});
		
		JLabel tasksLabel = new JLabel("Task List");
		JButton tasksButton = new JButton(CHANGE_OPTION);
		
		tasksButton.addActionListener(e -> {
			new TaskListEditWindow(myProject);
		});
		
		namePanel.add(nameField);
		namePanel.add(nameButton);
		
		descriptionEditPanel.add(descriptionLabel);
		descriptionEditPanel.add(descriptionButton);
		descriptionPanel.setLayout(new BorderLayout());
		descriptionPanel.add(descriptionArea);
		
		materialsEditPanel.add(materialsLabel);
		materialsEditPanel.add(materialsButton);
		//materialsPanel
		
		tasksEditPanel.add(tasksLabel);
		tasksEditPanel.add(tasksButton);
		//tasksPanel
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(namePanel);
		add(descriptionEditPanel);
		add(descriptionPanel);
		add(materialsEditPanel);
		add(materialsPanel);
		add(tasksEditPanel);
		add(tasksPanel);
	}
}
