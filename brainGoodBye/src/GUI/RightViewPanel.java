package GUI;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import brainGoodBye.Project;

/**
 * This panel displays the image and budget attributes of a project, 
 * allows them to be edited, and handles the exiting of the view.
 * 
 * @author Joey Hunt
 */
public class RightViewPanel extends JPanel {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = 5516273502639193358L;
	
	/**
	 * A panel for choosing an image.
	 */
	private JPanel imageEditPanel;
	
	/**
	 * A panel for viewing the image.
	 */
	private JPanel imagePanel;

	/**
	 * A panel for editing the budget.
	 */
	private JPanel budgetEditPanel;
	
	/**
	 * A panel for viewing the budget.
	 */
	private JPanel budgetPanel;
	
	/**
	 * A panel for saving or quitting the view.
	 */
	private JPanel savePanel;
	
	/**
	 * A helper panel for savePanel.
	 */
	private JPanel innerSavePanel;
	
	/**
	 * A panel for displaying the project date.
	 */
	private JPanel updatedPanel;
	
	/**
	 * A project to view.
	 */
	private Project myProject;
	
	/**
	 * The parent frame of this panel.
	 */
	private JFrame myParent;
	
	/**
	 * Creates the RightViewPanel with the given parent frame and project.
	 * 
	 * @author Joey Hunt
	 * @param theParent The parent frame for this panel.
	 * @param theProject A project to view.
	 */
	public RightViewPanel(final JFrame theParent, final Project theProject) {
		myParent = theParent;
		imageEditPanel = new JPanel();
		imagePanel = new JPanel();
		budgetEditPanel = new JPanel();
		budgetPanel = new JPanel();
		savePanel = new JPanel();
		innerSavePanel = new JPanel();
		myProject = theProject;
		
		initialize();
	}
	
	/**
	 * Initializes the RightViewPanel.
	 * 
	 * @author Joey Hunt
	 */
	private void initialize() {
		JLabel imageLabel = new JLabel("Image");
		JButton imageButton = new JButton("Edit");
		JLabel imageViewLabel = new JLabel();
		
		imageButton.addActionListener(e -> {
			final JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
			chooser.setFileFilter(new FileNameExtensionFilter("Image Files", 
					"jpg", "jpeg", "png", "gif"));
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				final File selected = chooser.getSelectedFile();
			}
		});
		
		JLabel budgetLabel = new JLabel("Budget");
		JButton budgetButton = new JButton("Edit");
		
		budgetButton.addActionListener(e -> {
			new BudgetEditWindow(myProject);
		});
		
		JButton saveQuitButton = new JButton("Save & Quit");
		JButton quitButton = new JButton("Quit");
		
		saveQuitButton.addActionListener(e -> {
			myProject.setModified(new Date());
			firePropertyChange("Save Project", false, true);
			myParent.dispatchEvent(new WindowEvent(myParent, WindowEvent.WINDOW_CLOSING));
			
		});
		
		quitButton.addActionListener(e -> {
			myParent.dispatchEvent(new WindowEvent(myParent, WindowEvent.WINDOW_CLOSING));
		});
		
		imageEditPanel.add(imageLabel);
		imageEditPanel.add(imageButton);
		
		
		
		budgetEditPanel.add(budgetLabel);
		budgetEditPanel.add(budgetButton);
		
		innerSavePanel.add(saveQuitButton);
		innerSavePanel.add(quitButton);
		
		savePanel.setLayout(new BorderLayout());
		savePanel.add(innerSavePanel, BorderLayout.SOUTH);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(imageEditPanel);
		add(imagePanel);
		add(budgetEditPanel);
		add(budgetPanel);
		add(savePanel);
	}
}
