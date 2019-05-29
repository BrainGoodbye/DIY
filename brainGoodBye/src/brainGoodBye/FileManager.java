package brainGoodBye;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	
	private List<Project> myProjects;
	
	/**
	 * @author Thaddaeus
	 */
	public FileManager() {
		// TODO Get intially selected sorting option directly, in case it changes.
		mySettings = "Cost";
		currentPath = ".";
		myProjects = new ArrayList<>();
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
	 * @author Joey Hunt
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
	

	/**
	 * Converts a list of projects to a serialized byte stream 
	 * and places it in a file for safe keeping.
	 * @author Thaddaeus
	 */
	private final void exportAll() {
		//List<Project> object = projects;
		
		final JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
		int returnVal = chooser.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File saved = chooser.getSelectedFile();
			try {
	            FileOutputStream file = new FileOutputStream(saved); 
	            ObjectOutputStream byteStream = new ObjectOutputStream(file); 
	            byteStream.writeObject(myProjects); 
	            byteStream.close(); 
	            file.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: file could not be read.");
			}
	    }	
	}
	
	/**
	 * Gets the serialized, byte stream form of a project list from a file 
	 * and converts it back to a usable project list.
	 * @author Thaddaeus
	 * @author Joey Hunt
	 */
	private void importAll() {
		final JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File saved = chooser.getSelectedFile();
			try {
				FileInputStream file = new FileInputStream(saved); 
				ObjectInputStream in = new ObjectInputStream(file); 

				@SuppressWarnings("unchecked") // not known for sure the type of the deserialized object
				List<Project> projects = (List<Project>) in.readObject();

				pcs.firePropertyChange("Import All", null, projects);

				in.close(); 
				file.close(); 
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error: file could not be read.");
			}
		}
	}
	

	
	
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        pcs.addPropertyChangeListener(thePropertyName, theListener);
        
    }
    
	public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        pcs.addPropertyChangeListener(theListener);
        
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
		} else if ("EProjects".equals(theEvent.getPropertyName())) {
			if (!myProjects.isEmpty()) {
			exportAll();
			} else {
				//Message
			}
		} else if ("IProjects".equals(theEvent.getPropertyName())) {
			importAll();
		} else if ("Added Project".equals(theEvent.getPropertyName())) {
			myProjects = (List<Project>)theEvent.getNewValue();
		}
	}

}
