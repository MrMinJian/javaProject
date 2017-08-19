package service;

import tool.ResultData;
import entity.Bill;

public interface BillService {
	Bill getBillById(Long id);
	
	ResultData getBills();
	
	ResultData addBill(Bill p);
	
	ResultData delBill(Long id);
}
