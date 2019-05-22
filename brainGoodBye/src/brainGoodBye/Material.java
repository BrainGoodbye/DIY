package brainGoodBye;

public class Material implements Cloneable{
	
	
	private int myQuantity;
	private Double myPrice;
	private boolean isAcquired;
	private String myName;
	
	Material(String nam, int quant, Double price) {
		isAcquired = false;
		myPrice = price;
		myQuantity = quant;
		myName = nam;
	}
	
	Material(String name, int quantity, Double price, boolean acq) {
		isAcquired = acq;
		myPrice = price;
		myQuantity = quantity;
		myName = name;
	}
	
	Material() {
		myQuantity = 0;
		myPrice = 0.0;
		isAcquired = false;
		myName="Material";
	}
	
	public void setQuantity(int myQuantity) {
		this.myQuantity = myQuantity;
	}

	public int getQuantity() {
		return myQuantity;
	}

	public Double getPrice() {
		return myPrice;
	}

	public boolean isAcquired() {
		return isAcquired;
	}

	public String getName() {
		return myName;
	}

	public void setPrice(Double myPrice) {
		this.myPrice = myPrice;
	}

	public void setAcquired(boolean isAcquired) {
		this.isAcquired = isAcquired;
	}

	public void setName(String myName) {
		this.myName = myName;
	}

	public Material clone() {
		return new Material(myName, myQuantity, myPrice, isAcquired);
	}
	
}
