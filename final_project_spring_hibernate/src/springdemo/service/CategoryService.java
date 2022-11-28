package springdemo.service;

import java.util.List;

import springdemo.entity.Categories;
import springdemo.entity.Products;

public interface CategoryService {
	public void createReceipts(Categories category);
	public List<Categories> getCategories();
	public void delete(int category_id);
}
