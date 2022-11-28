package springdemo.service;

import java.util.List;

import springdemo.entity.Order;
import springdemo.entity.Receipts;

public interface ReceiptsService {
	
	public void createReceipts(Receipts receipt);
	public List<Receipts> getReceiptsByUser(int Id);
	public List<Receipts> getReceipts();
	public void deteleReceipts(int theId);
	public Receipts getReceipt(int theId);
}
