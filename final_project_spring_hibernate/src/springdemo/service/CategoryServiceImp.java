package springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.dao.CategoryDAO;
import springdemo.dao.ProductsDAO;
import springdemo.entity.Cart;
import springdemo.entity.Categories;
import springdemo.entity.Products;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	public CategoryDAO categoryDAO;


	@Override
	@Transactional
	public void createReceipts(Categories category) {
		// TODO Auto-generated method stub
		categoryDAO.createReceipts(category);
	}

	@Override
	@Transactional
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public void delete(int category_id) {
		// TODO Auto-generated method stub
		categoryDAO.delete(category_id);
	}
	
	

}
