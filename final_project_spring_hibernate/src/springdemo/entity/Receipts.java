package springdemo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receipts")
public class Receipts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receipt_id")
	private int receipt_id;
	
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "receipt_dt")
	private java.sql.Timestamp receipt_dt;

	public Receipts() {
	
	}

	public Receipts(int receipt_id, int product_id, int user_id, int quantity, Timestamp receipt_dt) {
	
		this.receipt_id = receipt_id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.quantity = quantity;
		this.receipt_dt = receipt_dt;
	}

	public int getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	
	
	
}
