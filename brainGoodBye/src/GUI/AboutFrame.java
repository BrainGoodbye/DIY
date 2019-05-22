package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import brainGoodBye.Version;

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
		this.setTitle("About");
		this.setSize(400, 400);
		JLabel textLabel = new JLabel();
		BufferedImage buffImage;
		try {
			buffImage = ImageIO.read(new File("./brain_hand.jpg"));
			Image image = new ImageIcon(buffImage).getImage().getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			this.add(imageLabel, BorderLayout.NORTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Version.setVersion();
		textLabel.setText(Version.getVersion());
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(textLabel, BorderLayout.CENTER);
		this.getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
	}

}
