package springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.dao.ProductsDAO;
import springdemo.entity.Cart;
import springdemo.entity.Products;

@Service
public class ProductsServiceImp implements ProductsService {
	
	@Autowired
	public ProductsDAO productDAO;

	@Override
	@Transactional
	public List<Products> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public List<Products> getProductBuyCategory(int category_id) {
		// TODO Auto-generated method stub
		return productDAO.getProductBuyCategory(category_id);
	}

	@Override
	@Transactional
	public Products getProduct(int product_id) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(product_id);
	}

	@Override
	@Transactional
	public void createProduct(Products product) {
		// TODO Auto-generated method stub
		productDAO.createProduct(product);
	}

	@Override
	@Transactional
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		productDAO.delete(product_id);
		
	}
	
	

}
