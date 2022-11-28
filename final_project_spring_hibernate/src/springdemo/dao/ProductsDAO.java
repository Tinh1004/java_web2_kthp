package springdemo.dao;

import java.util.List;

import springdemo.entity.Categories;
import springdemo.entity.Products;


public interface ProductsDAO {
	public List<Products> getProducts();
	public Products getProduct(int product_id);
	public List<Products> getProductBuyCategory(int category_id);
	public void createProduct(Products product);
	public void delete(int product_id);
}
