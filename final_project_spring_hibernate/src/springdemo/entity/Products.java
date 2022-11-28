package springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "category_id")
	private int category_id;
	
	@Column(name = "product_dt")
	private java.sql.Timestamp product_dt;
	
	
	public Products() {};
	
	public Products(int product_id, String product_name, int price, String image, int category_id, java.sql.Timestamp product_dt) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.image = image;
		this.category_id = category_id;
		this.product_dt = product_dt;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public java.sql.Timestamp getProduct_dt() {
		return product_dt;
	}

	public void setProduct_dt(java.sql.Timestamp product_dt) {
		this.product_dt = product_dt;
	}

	
}
