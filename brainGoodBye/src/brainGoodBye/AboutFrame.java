package brainGoodBye;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author Thad Hug
 * @author Hunter Lantz
 *
 * This class represents a frame containing information about our project.
 */
public class AboutFrame extends JFrame {

	/**
	 * Automatically-generated serial ID.
	 */
	private static final long serialVersionUID = 267274501183431022L;

	/**
	 * Instantiates the frame.
	 */
	public AboutFrame() {
		this.setSize(400, 400);
		JLabel lab = new JLabel();
		lab.setText(Version.getVersion());
		this.add(lab);
		
		this.pack();
		this.setVisible(true);
	}

}
