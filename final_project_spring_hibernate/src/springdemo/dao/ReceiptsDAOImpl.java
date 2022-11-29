package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Products;
import springdemo.entity.Receipts;
import springdemo.entity.Users;

@Repository
public class ReceiptsDAOImpl implements ReceiptsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createReceipts(Receipts receipt) {
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer 
		currentSession.saveOrUpdate(receipt);
		
	}

	@Override
	public List<Receipts> getReceiptsByUser(int Id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Receipts> theQuery= currentSession.createQuery("from Receipts where user_id = :user_id", Receipts.class);
		theQuery.setParameter("user_id", Id);
		List<Receipts> receipts = theQuery.getResultList();
		return receipts;
	}

	@Override
	public void deteleReceipts(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Receipts where receipt_id=:receiptsId");
		theQuery.setParameter("receiptsId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Receipts> getReceipts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Receipts> theQuery= currentSession.createQuery("from Receipts", Receipts.class);
		List<Receipts> receipts = theQuery.getResultList();
		return receipts;
	}

	@Override
	public Receipts getReceipt(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Receipts receipt = currentSession.get(Receipts.class, theId);
		return receipt;
	}

}
