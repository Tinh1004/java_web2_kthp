package springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springdemo.entity.Products;
import springdemo.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerUsers(Users user) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save the customer 
		currentSession.saveOrUpdate(user);
	}

	@Override
	public Users login(Users user) {
		Session currentSession = sessionFactory.getCurrentSession();
		 Query<Users> theQuery= currentSession.createQuery("from Users Where username=:username AND password = :password", Users.class);
		 theQuery.setParameter("username", user.getUsername());
		 theQuery.setParameter("password", user.getPassword());
			// execute query and get result list
		 List<Users> listUsers = theQuery.getResultList();
		
		if(listUsers.size() > 0) {
			return listUsers.get(0);
		}
		
		return null;
	}

	@Override
	public List<Users> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> theQuery= currentSession.createQuery("from Users", Users.class);
		List<Users> users = theQuery.getResultList();
		return users;
	}

	@Override
	public Users getUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Users user = currentSession.get(Users.class, user_id);
		return user;
	}
	
}
