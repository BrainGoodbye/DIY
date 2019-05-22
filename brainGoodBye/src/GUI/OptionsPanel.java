package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4082397240874219557L;
	
	
	public OptionsPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton ExportSettings = new JButton("Export Settings");
		JButton ImportSettings = new JButton("Import Settings");
		JButton ExportProjects = new JButton("Export Projects");
		JButton ImportProjects = new JButton("Import Projects");
		this.add(ExportSettings);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ImportSettings);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ExportProjects);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ImportProjects);
		this.setBackground(Color.LIGHT_GRAY);
	}

}
