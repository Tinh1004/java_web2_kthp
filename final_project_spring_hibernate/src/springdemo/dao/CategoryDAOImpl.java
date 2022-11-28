package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Categories;
import springdemo.entity.Products;
import springdemo.entity.Receipts;
import springdemo.entity.Users;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createReceipts(Categories category) {
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer 
		currentSession.saveOrUpdate(category);
	}

	@Override
	public List<Categories> getCategories() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Categories> theQuery= currentSession.createQuery("from Categories", Categories.class);
		List<Categories> categories = theQuery.getResultList();
		return categories;
	}

	@Override
	public void delete(int category_id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Categories where category_id=:category_id");
		theQuery.setParameter("category_id", category_id);
		theQuery.executeUpdate();
	}

}
