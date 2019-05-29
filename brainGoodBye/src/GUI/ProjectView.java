package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import brainGoodBye.Project;
import brainGoodBye.ProjectViewListener;

/**
 * This frame presents detailed project information.
 * 
 * @author Joey Hunt
 */
public class ProjectView extends JFrame {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = 2370851541894297929L;
	
	/**
     * The default toolkit.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /**
     * The size of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /**
     * The initial size of the frame.
     */
    private static final Dimension FRAME_SIZE = new Dimension(SCREEN_SIZE.width / 3, 
                                                              SCREEN_SIZE.height / 3);
	
	/**
	 * The project to view detailed information of.
	 */
	private Project myProject;
	
	/**
	 * Panel which contains name, description, materials, and task list sections.
	 */
	private JPanel leftPanel;
	
	/**
	 * Panel which contains percentage done, image, and budget sections.
	 */
	private JPanel rightPanel;
	
	private ProjectViewListener viewListener;
	
//    /**
//     * Starts the GUI.
//     * 
//     * @param theArgs Command line arguments. Not used for this program.
//     */
//    public static void main(final String... theArgs) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                initialize();
//            }
//        });
//    }

	/**
	 * Instantiates the project view with no project.
	 * 
	 * @author Joey Hunt
	 */
	public ProjectView() {
		super("Project View");
		leftPanel = new LeftViewPanel();
		rightPanel = new RightViewPanel();
		viewListener = new ProjectViewListener();
		
		initialize();
	}
	
	/**
	 * Instantiates the project view with a given project.
	 * 
	 * @author Joey Hunt
	 * @param theProject A project to view.
	 */
	public ProjectView(final Project theProject) {
		super();
		myProject = theProject;
	}
	
	/**
	 * Starts the project view.
	 * 
	 * @author Joey Hunt
	 */
	public void initialize() {
		
		
		leftPanel.addPropertyChangeListener(viewListener);
		rightPanel.addPropertyChangeListener(viewListener);
		
		setLayout(new BorderLayout());
		
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		
        setSize(FRAME_SIZE);
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
                                 SCREEN_SIZE.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
	
	
}
