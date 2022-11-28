package springdemo.entity;

public class Cart {
	
	private Products product;
	private int quantity;
	
	public Cart() {
		
	}

	public Cart(Products product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
