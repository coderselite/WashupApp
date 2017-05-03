package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Billing;
import com.coders.elite.model.BillingModel;

public interface BillingDAO {
	public List<Billing> getAllBills();
	public Billing getBillById(int id);
	public void addBill(BillingModel bill);
	public List<Billing> getBillByUserId(int id);
	public Billing getBillByOrderId(int id);
	public void updateBill(Billing bill);
	public void deleteBill(int bill_id);
}
