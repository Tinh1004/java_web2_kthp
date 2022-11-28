package springdemo.service;

import java.util.List;

import springdemo.entity.Products;

public interface ProductsService {
	public List<Products> getProducts();
	public Products getProduct(int product_id);
	public List<Products> getProductBuyCategory(int category_id);
	public void createProduct(Products product);
	public void delete(int product_id);
}
