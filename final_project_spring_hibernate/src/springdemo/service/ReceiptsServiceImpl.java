package springdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.dao.ProductsDAO;
import springdemo.dao.ReceiptsDAO;
import springdemo.entity.Cart;
import springdemo.entity.Order;
import springdemo.entity.Receipts;

@Service
public class ReceiptsServiceImpl implements ReceiptsService {
	
	@Autowired
	public ReceiptsDAO receiptsDAO;

	@Override
	@Transactional
	public void createReceipts(Receipts receipt) {
		receiptsDAO.createReceipts(receipt);
	}

	@Override
	@Transactional
	public List<Receipts> getReceiptsByUser(int Id) {
		// TODO Auto-generated method stub
		return receiptsDAO.getReceiptsByUser(Id);
	}

	@Override
	@Transactional
	public void deteleReceipts(int theId) {
		// TODO Auto-generated method stub
		receiptsDAO.deteleReceipts(theId);
	}

	@Override
	@Transactional
	public List<Receipts> getReceipts() {
		// TODO Auto-generated method stub
		return receiptsDAO.getReceipts();
	}

	@Override
	@Transactional
	public Receipts getReceipt(int theId) {
		// TODO Auto-generated method stub
		return receiptsDAO.getReceipt(theId);
	}

}
