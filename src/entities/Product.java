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
		setPrice(price);
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
		if(price < 0) {
			return true;
		}
		this.price = price;
		return false;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Product id:" + id + ", name:" + name + ", price:" + String.format("%.2f", price) 
		+ ", current quantity in stock:" + quantity + ", total value of this product in stock:" + String.format("%.2f", price*quantity) + "\n"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
