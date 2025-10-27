package entities;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;

	public Product() {
	}

	public Product(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public boolean setPrice(double price) {
		if (price < 0) {
			return false;
		}
		this.price = price;
		return true;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean addQuantity(int quantity) {
		if (quantity < 0) {
			return false;
		}

		this.quantity += quantity;
		return true;
	}

	public boolean removeQuantity(int quantity) {
		if (quantity < 0 || this.quantity < quantity) {
			return false;
		}

		this.quantity -= quantity;
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Name: " + name + " | Price:" + String.format("%.2f", price)
				+ " | Current quantity in stock:" + quantity + " |\n";
	}

}
