package brainGoodBye;

/**
 * 
 * @author Jacob Ficker
 *
 */
public class Material implements Cloneable{
	
	
	private int myQuantity;
	private Double myPrice;
	private boolean isAcquired;
	private String myName;
	
	/**
	 * @author Jacob Ficker
	 * @param nam
	 * @param quant
	 * @param price
	 */
	public Material(String nam, int quant, Double price) {
		isAcquired = false;
		myPrice = price;
		myQuantity = quant;
		myName = nam;
	}
	
	/**
	 * @author Jacob Ficker
	 * @param name
	 * @param quantity
	 * @param price
	 * @param acq
	 */
	public Material(String name, int quantity, Double price, boolean acq) {
		isAcquired = acq;
		myPrice = price;
		myQuantity = quantity;
		myName = name;
	}
	
	/**
	 * @author Jacob Ficker
	 */
	public Material() {
		myQuantity = 0;
		myPrice = 0.0;
		isAcquired = false;
		myName="Material";
	}
	
	/**
	 * @author Jacob Ficker
	 * @param myQuantity
	 */
	public void setQuantity(int myQuantity) {
		this.myQuantity = myQuantity;
	}
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public int getQuantity() {
		return myQuantity;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getPrice() {
		return myPrice;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public boolean isAcquired() {
		return isAcquired;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getName() {
		return myName;
	}

	/**
	 * @author Jacob Ficker
	 * @param myPrice
	 */
	public void setPrice(Double myPrice) {
		this.myPrice = myPrice;
	}

	/**
	 * @author Jacob Ficker
	 * @param isAcquired
	 */
	public void setAcquired(boolean isAcquired) {
		this.isAcquired = isAcquired;
	}
	
	/**
	 * @author Jacob Ficker
	 * @param myName
	 */
	public void setName(String myName) {
		this.myName = myName;
	}
	
	/**
	 * @author Jacob Ficker
	 */
	public Material clone() {
		return new Material(myName, myQuantity, myPrice, isAcquired);
	}
	
	/**
	 * @author Jacob Ficker
	 */
	@Override
	public boolean equals(Object o) {
		Material m = (Material) o;
		return m.getName().equals(this.getName())
				&& m.getPrice() == this.getPrice()
				&& m.getQuantity() == this.getQuantity()
				&& m.isAcquired() == this.isAcquired();
	}
	
	/**
	 * @author Jacob Ficker
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
