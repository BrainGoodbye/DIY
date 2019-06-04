package GUI;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Jacob Ficker
 *
 */
public class MaterialEdit extends JPanel {
	/**
	 * generated SUID
	 */
	private static final long serialVersionUID = -3364289024964437784L;
	
	private JTextField name;
	private JTextField price;
	private JTextField quantity;
	private boolean acquired;
	
	/**
	 * @author Jacob Ficker
	 */
	public MaterialEdit() {
		super();
		name = new JTextField("Name");
		price = new JTextField("0.00");
		quantity = new JTextField("0");
		acquired = false;
		initialize();
	}
	
	/**
	 * @author Jacob Ficker
	 * @param n
	 * @param p
	 * @param q
	 */
	public MaterialEdit(String n, double p, int q) {
		name = new JTextField(n);
		price = new JTextField(Double.toString(p));
		quantity = new JTextField(Integer.toString(q));
		acquired = false;
		initialize();
	}
	
	/**
	 * @author Jacob Ficker
	 * @param n
	 * @param p
	 * @param q
	 * @param a
	 */
	public MaterialEdit(String n, double p, int q, boolean a) {
		name = new JTextField(n);
		price = new JTextField(Double.toString(p));
		quantity = new JTextField(Integer.toString(q));
		acquired = a;
		initialize();
	}

	/**
	 * @author Jacob Ficker
	 */
	private void initialize() {
		this.setLayout(new FlowLayout());
		name.setColumns(25);
		price.setColumns(9);
		quantity.setColumns(5);
		this.add(name);
		this.add(price);
		this.add(quantity);
		this.setVisible(true);
	}

	/**
	 * @author Jacob Ficker
	 * @param b
	 */
	public void setAcquired(boolean b) {
		acquired = b;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public boolean isAcquired() { 
		return acquired;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public int getQuantity() {
		int r = Integer.parseInt(quantity.getText());
		if (r < 0) {
			//JOptionPane.showMessageDialog(this, "Invalid Quantity", "Invalid Input", JOptionPane.OK_OPTION);
		} else {
			return r;
		}
		return -1;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public double getPrice() {
		double d = Double.parseDouble(price.getText());
		if (d < 0) {
			//JOptionPane.showMessageDialog(this, "Invalid Price", "Invalid Input", JOptionPane.OK_OPTION);
		} else {
			return d;
		}
		return -1.0;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getMyName() {
		if (name.getText().length() > 75) {
			return "INVALID NAME";
		} else {
			return name.getText();
		}
	}
	
}
