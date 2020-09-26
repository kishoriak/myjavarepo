package ccom.demo.bean;

import java.util.Date;

public class FoodItems extends Product {
	private Date dateOfManufacturing;
	private Date dateOfExpiry;
	private boolean isVegetarian;

	public FoodItems(String name, double price, int qty, Date dateOfManufacturing, Date dateOfExpiry, boolean isVegetarian) {
		super(name, price, cnt);
		this.dateOfManufacturing = dateOfManufacturing;
		this.dateOfExpiry = dateOfExpiry;
		this.isVegetarian = isVegetarian;
	}

	public Date getDateOfManufacturing() {
		return dateOfManufacturing;
	}

	public void setDateOfManufacturing(Date dateOfManufacturing) {
		this.dateOfManufacturing = dateOfManufacturing;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	@Override
	public String toString() {
		return super.toString() + " -> FoodItems [isVegetarian=" + isVegetarian + "]";
	}

}
