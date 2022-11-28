package springdemo.dao;

import java.util.List;

import springdemo.entity.Receipts;

public interface ReceiptsDAO {
	public void createReceipts(Receipts receipt);
	public List<Receipts> getReceiptsByUser(int Id);
	public List<Receipts> getReceipts();
	public void deteleReceipts(int theId);
	public Receipts getReceipt(int theId);
}
