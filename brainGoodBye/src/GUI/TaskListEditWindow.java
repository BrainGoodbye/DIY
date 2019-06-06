package GUI;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import brainGoodBye.Project;
import brainGoodBye.Task;

public class TaskListEditWindow extends AbstractEditWindow {

	/**
	 * generated SUID
	 */
	private static final long serialVersionUID = -8438671471656510757L;
	private ArrayList<TaskEdit> editFields;
	private ArrayList<JButton> removeButtons;
	private JButton saveButton;
	private JButton cancelButton;
	private JButton newButton;
	private JPanel myPanel;
	
	public TaskListEditWindow(Project theProj) {
		super(theProj, "Edit Tasks");
		editFields = new ArrayList<TaskEdit>();
		removeButtons = new ArrayList<JButton>();
		
		initialize();
	}

	private void initialize() {
		
		myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(myPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		ArrayList<Task> tasks = (ArrayList<Task>) myProject.getTaskListCopy();
		
		for (int i = 0; i < tasks.size(); i++) {
			addTaskEdit(tasks.get(i));
			myPanel.add(editFields.get(i));
			myPanel.add(removeButtons.get(i));
		}
		
		//Set up new task button
		newButton = new JButton("Add New Task");
		newButton.addActionListener(event -> addTaskEdit(new Task(0.00, "Description")));
		
		//Set up save and close button
		saveButton = new JButton("Save and Close");
		saveButton.addActionListener(event -> save() );
		
		//Set up cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(event -> this.dispose());
		
		//Where the big boy buttons go
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		
		//Add stuff to bottom panel
		bottomPanel.add(newButton);
		bottomPanel.add(saveButton);
		bottomPanel.add(cancelButton);
		
		JPanel viewPanel = new JPanel();
		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
		viewPanel.add(scrollPane);
		viewPanel.add(bottomPanel);
		
		this.setContentPane(viewPanel);
		if (editFields.size() == 0) {
			addTaskEdit(new Task(0.00, "Description"));
		}
		this.pack();
		this.setSize(this.getWidth()+100, this.getHeight()+150);
		if (this.getHeight() > 600) {
			this.setSize(this.getWidth(), 600);
		}
		
	}
	
	private void addTaskEdit(Task t) {
		editFields.add(new TaskEdit(t.getDescription(), t.getHoursToComplete(), t.isDone()));
		JButton b = new JButton("Remove Above Item");
		removeButtons.add(b);
		b.addActionListener(event -> removeMe(removeButtons.indexOf(b)));
		
		myPanel.add(editFields.get(editFields.size()-1));
		myPanel.add(b);
		
		this.repaint();
		this.revalidate();
	}
	
	private void removeMe(int i) {
		myPanel.remove(editFields.get(i));
		myPanel.remove(removeButtons.get(i));
		editFields.remove(i);
		removeButtons.remove(i);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void save() {
		boolean allGood = true;
		ArrayList<Task> t = new ArrayList<Task>();
		
		for(int i = 0; i < editFields.size(); i++) {
			TaskEdit field = editFields.get(i);
			String desc = field.getDescription();
			Double d = field.getHoursToComplete();
			
			if(d < 0 || desc.length() > 100) {
				allGood = false;
				break;
			}
			
			t.add(new Task(field.getHoursToComplete(), field.getDescription(), field.isComplete()));
		}
		
		if(allGood) {
			myProject.setTaskList(t);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "One of your inputs is invalid. Please Make sure that your description is no longer than 100 characters,"
					+ " and you only use non-negative numbers for the total hours to complete.", "Invalid Input", JOptionPane.OK_OPTION);

		}
		
	}

}
