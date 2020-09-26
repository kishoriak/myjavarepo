package ccom.demo.bean;

public class Apparel extends Product{
	private double size;
	private String material;
	
	public Apparel(String name, double price, int qty, double size, String material) {
		super(name, price, qty);
		this.size = size;
		this.material = material;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString() + " -> Apparel [size=" + size + ", material=" + material + "]";
	}
	
	
}
