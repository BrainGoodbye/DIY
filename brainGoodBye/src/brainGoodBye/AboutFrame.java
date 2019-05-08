package brainGoodBye;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame {

	AboutFrame() {
		this.setSize(400, 400);
		this.setVisible(true);
		this.add(new JTextArea(Version.getVersion()));
	}

}
