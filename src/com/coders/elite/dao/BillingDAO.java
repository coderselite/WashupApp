package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Billing;

public interface BillingDAO {
	public List<Billing> getAllBills();
	public Billing getBillById(int id);
	public Billing addBill(Billing bill);
	public List<Billing> getBillByUserId(int id);
	public Billing getBillByOrderId(int id);
	public void updateBill(Billing bill);
	public void deleteBill(int bill_id);
}
