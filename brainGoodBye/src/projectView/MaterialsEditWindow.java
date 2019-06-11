package projectView;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import brainGoodBye.Material;
import brainGoodBye.Project;

/**
 * Window where you edit materials.
 * @author Jacob Ficker
 *
 */
public class MaterialsEditWindow extends AbstractEditWindow {

	/**
	 * generated UID
	 */
	private static final long serialVersionUID = 6435525123719217690L;
	
	private ArrayList<MaterialEdit> editFields;
	private ArrayList<JButton> removeButtons;
	private JButton saveButton;
	private JButton cancelButton;
	private JButton newButton;
	private JPanel myPanel;
	
	/**
	 * Basic Constructor
	 * @author Jacob Ficker
	 */
	public MaterialsEditWindow(Project theProj) {
		super(theProj, "Edit Materials");
		
		
		initialize();
	}
	
	/**
	 * Loads the materials list into the editable fields.
	 * @author Jacob Ficker
	 */
	public void initialize() {
		
		ArrayList<Material> theList = (ArrayList<Material>) myProject.getMaterialListCopy();
		
		
		myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		JPanel bigPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(myPanel);
		
		
		editFields = new ArrayList<MaterialEdit>();
		removeButtons = new ArrayList<JButton>();
		
		for (int i = 0; i < theList.size(); i++) {
			//Material to add
			Material m = theList.get(i);
			
			//add field for material
			editFields.add(new MaterialEdit(m.getName(), m.getPrice(), m.getQuantity(), m.isAcquired()));
			myPanel.add(editFields.get(i));
			
			//add remove button
			JButton b = new JButton("Remove Above Item");
			removeButtons.add(b);
			b.addActionListener(event -> removeMe(removeButtons.indexOf(b)));
			myPanel.add(b);
			
			
		}
		

		//Add new button
		newButton = new JButton("Add New Material");
		newButton.addActionListener(event -> newMaterial());
		
		//Add Save and Cancel buttons
		saveButton = new JButton("Save and Close");
		saveButton.addActionListener(event -> save());
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(event -> cancel());
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		
		bottomPanel.add(newButton);
		bottomPanel.add(saveButton);
		bottomPanel.add(cancelButton);
		
		bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.PAGE_AXIS));
		bigPanel.add(scrollPane);
		bigPanel.add(bottomPanel);
		
		
		this.setContentPane(bigPanel);
		if (editFields.size() == 0) {
			newMaterial();
		}
		this.pack();
		this.setSize(this.getWidth()+100, this.getHeight()+150);
	}
	
	/**
	 * Removes a material from the list.
	 * @author Jacob Ficker
	 * @param i integer representing the location of the material in the array
	 */
	public void removeMe(int i) {
		myPanel.remove(editFields.get(i));
		editFields.remove(i);
		myPanel.remove(removeButtons.get(i));
		removeButtons.remove(i);
		this.repaint();
		this.revalidate();
	}

	/**
	 * Saves materials list to the project.
	 * @author Jacob Ficker
	 */
	@Override
	public void save() {
		ArrayList<Material> m = new ArrayList<Material>();
		boolean allGood = true;
		for(int i = 0; i < editFields.size(); i++) {
			MaterialEdit field = editFields.get(i);
			String theName = field.getMyName();
			int q = field.getQuantity();
			double p = field.getPrice();
			boolean acq = field.isAcquired();
			if (theName.equals("INVALID INPUT") || q == -1 || p == -1) {
				allGood = false;
			}
			m.add(new Material(theName, q, p, acq));
		}
		
		if (allGood) {
			myProject.setMaterialsList(m);
			this.cancel();
		} else {
			JOptionPane.showMessageDialog(this, "One of your inputs is invalid. Please Make sure that your name is no longer than 75 characters,"
											+ " and you only non-negative numbers for price and quantity.", "Invalid Input", JOptionPane.OK_OPTION);
		}
	}
	
	/**
	 * Closes window.
	 * @author Jacob Ficker
	 */
	public void cancel() {
		this.dispose();
	}

	/**
	 * Adds new blank material.
	 * @author Jacob Ficker
	 */
	public void newMaterial() {
		editFields.add(new MaterialEdit());
		myPanel.add(editFields.get(editFields.size() - 1));
		
		//add remove button
		JButton b = new JButton("Remove Above Item");
		b.addActionListener(event -> removeMe(removeButtons.indexOf(b)));
		removeButtons.add(b);
		myPanel.add(b);
		this.repaint();
		this.revalidate();
	}
	
	
}
