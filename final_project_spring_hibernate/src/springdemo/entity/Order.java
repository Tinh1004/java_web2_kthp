package springdemo.entity;

import java.sql.Timestamp;

public class Order {
	private int receipt_id;
	private Products product;
	private Users user;
	private int quantity;
	private java.sql.Timestamp receipt_dt;
	
	public Order() {}
	
	public Order(int receipt_id, Products product, Users user, int quantity, Timestamp receipt_dt) {
		this.receipt_id = receipt_id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.receipt_dt = receipt_dt;
	}

	
	
	public int getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
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

	public java.sql.Timestamp getReceipt_dt() {
		return receipt_dt;
	}

	public void setReceipt_dt(java.sql.Timestamp receipt_dt) {
		this.receipt_dt = receipt_dt;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	

}
