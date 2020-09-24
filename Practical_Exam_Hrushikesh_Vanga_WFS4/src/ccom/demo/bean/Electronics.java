package ccom.demo.bean;

public class Electronics extends Product {
	private int warranty;

	public Electronics(String name, double price, int qty, int warranty) {
		super(name, price, qty);
		this.warranty = warranty;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return super.toString() + " -> Electronics [warranty=" + warranty + "]";
	}

}
