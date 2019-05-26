package brainGoodBye;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Thaddaeus
 * @author Joey Hunt
 */
public final class FileManager implements PropertyChangeListener {
	
	/**
	 * 
	 */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * 
	 */
	private String mySettings;
	
	private String currentPath;
	
	/**
	 * @author Thaddaeus
	 */
	public FileManager() {
		// TODO Get intially selected sorting option directly, in case it changes.
		mySettings = "Cost";
		currentPath = ".";
	}
	
	/**
	 * Exports user settings to a file.
	 * 
	 * @author Thaddaeus
	 * @author Joey Hunt
	 * @Author Hunter Lantz
	 */
	private void exportSettings() {
			final JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
			int returnVal = chooser.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File saved = chooser.getSelectedFile();
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(saved));
					writer.write(mySettings);
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	}
	
	/**
	 * Imports user settings from a file.
	 * 
	 * @author Thaddaeus
	 * @autho Joey Hunt
	 * @author Hunter Lantz
	 */
	private void importSettings() {
		final JFileChooser chooser = new JFileChooser(currentPath);
	    chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	currentPath = chooser.getCurrentDirectory().getAbsolutePath();
			try (FileReader fr = new FileReader(chooser.getSelectedFile());
	                BufferedReader br = new BufferedReader(fr)) {
				pcs.firePropertyChange("Import Settings", null, br.readLine());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: file could not be read.");
			}
	    }
	}

//	/**
//	 * @author Thaddaeus
//	 */
//	exportAll(List<Project> projects) {
//		
//	}
//	
//	/**
//	 * @author Thaddaeus
//	 */
//	List<Project> importAll() {
//		
//	}
	
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        pcs.addPropertyChangeListener(thePropertyName, theListener);
        
    }

    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        pcs.removePropertyChangeListener(theListener);
        
    }

    public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
        pcs.removePropertyChangeListener(thePropertyName, theListener);
        
    }

	/**
	 * {@inheritDoc}
	 * 
	 * 
	 * 
	 * @author Joey Hunt
	 * @param theEvent The property which has changed.
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		if ("Sort".equals(theEvent.getPropertyName())) {
			mySettings = (String)theEvent.getNewValue();
		} else if ("ESettings".equals(theEvent.getPropertyName())) {
			exportSettings();
		} else if ("ISettings".equals(theEvent.getPropertyName())) {
			importSettings();
		}
	}

}
