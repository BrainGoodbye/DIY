package projectView;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
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
	private JCheckBox acquired;
	
	/**
	 * Initializes with fields containting zero and "Name"
	 * @author Jacob Ficker
	 */
	public MaterialEdit() {
		super();
		name = new JTextField("Name");
		price = new JTextField("0.00");
		quantity = new JTextField("0");
		acquired = new JCheckBox();
		initialize();
	}
	
	/**
	 * Initializes the fields to specified values (except the acquired field)
	 * @author Jacob Ficker
	 * @param n Name
	 * @param p Price
	 * @param q Quantity
	 */
	public MaterialEdit(String n, double p, int q) {
		name = new JTextField(n);
		price = new JTextField(Double.toString(p));
		quantity = new JTextField(Integer.toString(q));
		acquired = new JCheckBox();
		initialize();
	}
	
	/**
	 * Initializes all fields to specified values
	 * @author Jacob Ficker
	 * @param n Name
	 * @param p Price
	 * @param q Quantity
	 * @param a boolean representing whether or not this material has been required
	 */
	public MaterialEdit(String n, double p, int q, boolean a) {
		name = new JTextField(n);
		price = new JTextField(Double.toString(p));
		quantity = new JTextField(Integer.toString(q));
		acquired = new JCheckBox();
		acquired.setSelected(a);
		initialize();
	}

	/**
	 * Sets up GUI elements and makes the visible
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
		this.add(new JLabel("Acquired"));
		this.add(acquired);
		this.setVisible(true);
	}

	/**
	 * @author Jacob Ficker
	 * @param b
	 */
	public void setAcquired(boolean b) {
		acquired.setSelected(b);;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public boolean isAcquired() { 
		return acquired.isSelected();
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
