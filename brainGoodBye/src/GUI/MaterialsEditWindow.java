package GUI;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import brainGoodBye.Material;
import brainGoodBye.Project;

public class MaterialsEditWindow extends AbstractEditWindow {

	private ArrayList<MaterialEdit> editFields;
	private ArrayList<JButton> removeButtons;
	private JButton saveButton;
	private JButton cancelButton;
	private JButton newButton;
	
	public MaterialsEditWindow(Project theProj) {
		super(theProj, "Edit Materials");
		
		
		initialize();
	}
	
	
	public void initialize() {
		
		ArrayList<Material> theList = (ArrayList<Material>) myProject.getMaterialListCopy();
		
		this.setLayout(new BoxLayout(this, JFrame.DO_NOTHING_ON_CLOSE));
		JLabel name = new JLabel("Edit Materials");
		this.add(name);
		
		editFields = new ArrayList<MaterialEdit>();
		removeButtons = new ArrayList<JButton>();
		
		for (int i = 0; i < theList.size(); i++) {
			//Material to add
			Material m = theList.get(i);
			
			//add field for material
			editFields.add(new MaterialEdit(m.getName(), m.getPrice(), m.getQuantity()));
			this.add(editFields.get(i));
			
			//add remove button
			JButton b = new JButton(new AbstractAction(Integer.toString(i)) {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeMe(Integer.parseInt(((JButton) e.getSource()).getActionCommand()));
				}

			});
			b.setText("Remove Above Item");
			removeButtons.add(b);
			this.add(b);
			
			//Add new button
			newButton = new JButton(new AbstractAction("Add New Material") {

				@Override
				public void actionPerformed(ActionEvent e) {
					newMaterial();
				}
				
			});
			
			//Add Save and Cancel buttons
			saveButton = new JButton(new AbstractAction("Save and Close") {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					save();
				}
				
			});
			
			cancelButton = new JButton(new AbstractAction("Cancel") {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					cancel();
				}
				
			});
			
			JPanel bottomPanel = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
			
			bottomPanel.add(saveButton);
			bottomPanel.add(cancelButton);
			this.add(bottomPanel);
			
			
		}
		
		
		
	}
	
	public void removeMe(int i) {
		this.remove(editFields.get(i));
		editFields.remove(i);
		this.remove(removeButtons.get(i));
		removeButtons.remove(i);
	}

	@Override
	public void save() {
		ArrayList<Material> m = new ArrayList<Material>();
		for(int i = 0; i < editFields.size(); i++) {
			MaterialEdit field = editFields.get(i);
			m.add(new Material(field.getName(), field.getQuantity(), field.getPrice(), field.isAcquired()));
		}
		myProject.setMaterialsList(m);
		this.cancel();
	}
	
	public void cancel() {
		this.dispose();
	}

	public void newMaterial() {
		editFields.add(new MaterialEdit());
		this.add(editFields.get(editFields.size() - 1));
		
		//add remove button
		JButton b = new JButton(new AbstractAction(Integer.toString(editFields.size() - 1)) {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeMe(Integer.parseInt(((JButton) e.getSource()).getActionCommand()));
			}

		});
		b.setText("Remove Above Item");
		removeButtons.add(b);
		this.add(b);
	}
	
	
}
