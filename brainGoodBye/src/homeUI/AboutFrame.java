package homeUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import brainGoodBye.Version;

/**
 * This class represents a frame containing information about our project.
 * @author Thad Hug
 * @author Hunter Lantz
 * @author Joey Hunt (minor edits)
 */
public class AboutFrame extends JFrame {

	/**
	 * Automatically-generated serial ID.
	 */
	private static final long serialVersionUID = 267274501183431022L;

	/**
	 * Creates and displays the about frame.
	 * @author Thaddaeus
	 * @author Joey Hunt (minor edits)
	 */
	public AboutFrame() {
		this.setTitle("About");
		this.setSize(400, 400);
		JLabel textLabel = new JLabel();
		
		//final ImageIcon icon = new ImageIcon(getClass().getResource("/brain_hand.jpg"));
		final Image image = Toolkit.getDefaultToolkit().
				getImage(getClass().getResource("/brain_hand.jpg")).
				getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		this.add(imageLabel, BorderLayout.NORTH);
		
		Version.setVersion();
		textLabel.setText(Version.getVersion());
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(textLabel, BorderLayout.CENTER);
		this.getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
	}

}
