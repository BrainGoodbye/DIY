package brainGoodBye;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.filechooser.FileNameExtensionFilter;


import GUI.Thumbnail;

/**
 * 
 * @author Thaddaeus
 * @author Joey Hunt
 * @author Hunter Lantz
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
		// TODO Get initially selected sorting option directly, in case it changes.
		mySettings = "Cost";
		currentPath = ".";
		myProjects = new ArrayList<>();
		loadPersistence();
	}
	
	/**
	 * Deserializes a list of projects from the given file and lets all interested parties know by property change listener
	 * @author Thaddaeus
	 * @param file the file to deserialize
	 * @return
	 */
	private void deserializeFile(File file) {
		try {
			FileInputStream fileinputStream = new FileInputStream(file); // stream to read file from
			ObjectInputStream in = new ObjectInputStream(fileinputStream); // stream to read objects from, converted from file stream

			@SuppressWarnings("unchecked") // not known for sure the type of the deserialized object
			List<Project> projects = (List<Project>) in.readObject();
			myProjects = projects;
			pcs.firePropertyChange("Import All", null, projects);
			
			in.close(); 
			fileinputStream.close(); 
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: file could not be read.");
		}
	}
	
	/**
	 * Saves the myProjects list in a serialized state to the given file.
	 * @author Thaddaeus
	 * @param file the file to save to
	 */
	private void serializeToFile(File file) {
		try {
            FileOutputStream outputStream = new FileOutputStream(file); // a file stream for writing the serialized objects two.
            ObjectOutputStream byteStream = new ObjectOutputStream(outputStream); // connect the byte stream to the file stream
            byteStream.writeObject(myProjects); // write objects to a byte stream for putting in a file
            byteStream.close(); 
            outputStream.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: file could not be read.");
		}
	}
	
	/**
	 * Updates the persistent data storage storing application data including projects and settings.
	 * @author Hunter
	 * @author Thaddaeus
	 */
	public void updatePersistence() {
		File file = new File("data.txt");
		serializeToFile(file);
		updatePersistentSettings();
	}
	
	/**
	 * @author Hunter
	 */
	private void updatePersistentSettings() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("settings.txt")));
			writer.write(mySettings);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the persistent data storage for the application into 
	 * memory for the application to use, including projects and settings.
	 * @author Hunter
	 * @author Thaddaeus
	 */
	public void loadPersistence() {
		File file = new File("data.txt");
		if (file.length() == 0) { // no persistent data to use
			return;
		}
		deserializeFile(file);
		loadPersistentSettings();
	}
	
	
	/**
	 * @author Hunter Lantz
	 */
	public void loadPersistentSettings() {
		try (FileReader fr = new FileReader("settings.txt");
                BufferedReader br = new BufferedReader(fr)) {
			pcs.firePropertyChange("Import Settings", null, br.readLine());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: file could not be read.");
		}
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
		final JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
		int returnVal = chooser.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			serializeToFile(file);
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
			File file = chooser.getSelectedFile();
			deserializeFile(file);
			 // imported the projects for this application from a file, so update what should be persisted on close
			updatePersistence();
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
	 * @author Joey Hunt
	 * @author Hunter
	 * @param theEvent The property which has changed.
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		if ("Sort".equals(theEvent.getPropertyName())) {
			mySettings = (String)theEvent.getNewValue();
			updatePersistentSettings();
		} else if ("ESettings".equals(theEvent.getPropertyName())) {
			exportSettings();
		} else if ("ISettings".equals(theEvent.getPropertyName())) {
			importSettings();
		} else if ("EProjects".equals(theEvent.getPropertyName())) {
			if (!myProjects.isEmpty()) {
				exportAll();
			}
		} else if ("IProjects".equals(theEvent.getPropertyName())) {
			importAll();
		} else if ("Added Project".equals(theEvent.getPropertyName())) {
			myProjects = (List<Project>)theEvent.getNewValue();
			updatePersistence();
		} else if("Delete".equals(theEvent.getPropertyName())) {
			myProjects.remove(((Thumbnail)theEvent.getNewValue()).getProject());
			updatePersistence();
		}
	}

}
