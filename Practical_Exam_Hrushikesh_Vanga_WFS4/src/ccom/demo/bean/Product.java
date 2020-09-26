package ccom.demo.bean;

public class Product implements Comparable<Product> {
	static int cnt = 0;
	private int id;
	private String name;
	private double price;
	private int qty;
	
	public Product(String name, double price, int qty) {
		super();
		this.id = ++cnt;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}

	@Override
	public int compareTo(Product p) {
		if (qty == p.qty)
			return 0;
		else if (qty > p.qty)
			return -1;
		else
			return 1;
	}
	
}
