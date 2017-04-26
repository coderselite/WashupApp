package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Billing;
import com.coders.elite.model.BillingModel;

public interface BillingService {
	public List<Billing> getAllBill();
	public Billing getBillById(int id);
	public Billing getBillByOrderId(int order_id);
	public List<Billing> getBillByUser(int user_Id);
	public void addBill(BillingModel bill);
	public void updateBill(Billing bill);
	public void deleteBill(Billing Bill);
}
