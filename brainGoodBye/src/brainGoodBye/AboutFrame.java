package brainGoodBye;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame {

	public AboutFrame() {
		this.setSize(400, 400);
		JLabel lab = new JLabel();
		lab.setText(Version.getVersion());
		this.add(lab);
		
		this.pack();
		this.setVisible(true);
	}

}
