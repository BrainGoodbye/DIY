package GUI;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MaterialEdit extends JPanel {
	/**
	 * generated SUID
	 */
	private static final long serialVersionUID = -3364289024964437784L;
	
	private JTextArea name;
	private JTextArea price;
	private JTextArea quantity;
	private boolean acquired;
	
	public MaterialEdit() {
		super();
		name = new JTextArea();
		price = new JTextArea();
		quantity = new JTextArea();
		acquired = false;
	}
	
	public MaterialEdit(String n, double p, int q) {
		super();
		name = new JTextArea(n);
		price = new JTextArea(Double.toString(p));
		quantity = new JTextArea(Integer.toString(q));
		acquired = false;
	}
	
	public MaterialEdit(String n, double p, int q, boolean a) {
		super();
		name = new JTextArea(n);
		price = new JTextArea(Double.toString(p));
		quantity = new JTextArea(Integer.toString(q));
		acquired = a;
	}

	
	public void initialize() {
		this.setLayout(new FlowLayout());
		this.add(name);
		this.add(price);
		this.add(quantity);
		this.setVisible(true);
	}

	public void setAcquired(boolean b) {
		acquired = b;
	}
	
	public boolean isAcquired() { 
		return acquired;
	}
	
	public int getQuantity() {
		int r = Integer.parseInt(quantity.getText());
		if (r < 1) {
			JOptionPane.showMessageDialog(this, "Invalid Quantity", "Invalid Input", JOptionPane.OK_OPTION);
		} else {
			return r;
		}
		return 0;
	}
	
	public double getPrice() {
		double d = Double.parseDouble(price.getText());
		if (d <= 0) {
			JOptionPane.showMessageDialog(this, "Invalid Price", "Invalid Input", JOptionPane.OK_OPTION);
		} else {
			return d;
		}
		return 0.0;
	}
	
	public String getName() {
		if (name.getText().length() > 75) {
			JOptionPane.showMessageDialog(this, "Name too long. Maximum size is 75 characters.", "Invalid Input", JOptionPane.OK_OPTION);
			return "";
		} else {
			return name.getText();
		}
	}
	
}
