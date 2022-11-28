package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Cart;
import springdemo.entity.Products;

@Repository
public class ProductsDAOImpl implements ProductsDAO {
	
	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;

	@Override
	public List<Products> getProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Products> theQuery= currentSession.createQuery("from Products", Products.class);
		List<Products> products = theQuery.getResultList();
		return products;
	}

	@Override
	public List<Products> getProductBuyCategory(int category_id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Products> theQuery= currentSession.createQuery("from Products where category_id=:category_id", Products.class);
		theQuery.setParameter("category_id", category_id);
		List<Products> products = theQuery.getResultList();
		return products;

	}

	@Override
	public Products getProduct(int product_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Products product = currentSession.get(Products.class, product_id);
		return product;
	}

	@Override
	public void createProduct(Products product) {
		Session currentSession = sessionFactory.getCurrentSession();
		//save product
		currentSession.saveOrUpdate(product);
		
	}
	
	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Products where product_id=:product_id");
		theQuery.setParameter("product_id", product_id);
		theQuery.executeUpdate();
	}
	
	
	
	
}

