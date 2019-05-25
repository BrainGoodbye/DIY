package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4082397240874219557L;
	
	
	private PropertyChangeSupport Pcs= new PropertyChangeSupport(this);
	
	public OptionsPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton ExportSettings = new JButton("Export Settings");
		ExportSettings.addActionListener(theEvent -> Pcs.firePropertyChange("ESettings",false,true));
		JButton ImportSettings = new JButton("Import Settings");
		ImportSettings.addActionListener(theEvent -> Pcs.firePropertyChange("ISettings",false,true));
		JButton ExportProjects = new JButton("Export Projects");
		ExportProjects.addActionListener(theEvent -> Pcs.firePropertyChange("EProjects",false,true));
		JButton ImportProjects = new JButton("Import Projects");
		ImportProjects.addActionListener(theEvent -> Pcs.firePropertyChange("IProjects",false,true));
		this.add(ExportSettings);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ImportSettings);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ExportProjects);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		this.add(ImportProjects);
		this.setBackground(Color.LIGHT_GRAY);
	}

	    @Override
	    public void addPropertyChangeListener(final String thePropertyName,
	                                          final PropertyChangeListener theListener) {
	        Pcs.addPropertyChangeListener(thePropertyName, theListener);
	        
	    }

	    @Override
	    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
	        Pcs.removePropertyChangeListener(theListener);
	        
	    }

	    @Override
	    public void removePropertyChangeListener(final String thePropertyName,
	                                             final PropertyChangeListener theListener) {
	        Pcs.removePropertyChangeListener(thePropertyName, theListener);
	        
	    }

}
