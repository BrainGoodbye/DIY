package brainGoodBye;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame {

	public static void main(String[] args) {

	}
	
	AboutFrame() {
		this.setSize(400, 400);
		this.setVisible(true);
		this.add(new JTextArea("Brain GoodBye:\nHunter Lantz, Jacob Ficker, Joey Hunt, Thaddaeus Hug"));
	}

}
