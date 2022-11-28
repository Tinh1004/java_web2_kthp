package springdemo.dao;

import java.util.List;

import springdemo.entity.Categories;
import springdemo.entity.Receipts;

public interface CategoryDAO {
	public void createReceipts(Categories category);
	public List<Categories> getCategories();
	public void delete(int category_id);
}
