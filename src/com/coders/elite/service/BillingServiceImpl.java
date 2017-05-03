package com.coders.elite.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import com.coders.elite.bean.Billing;
import com.coders.elite.bean.Catalog;
import com.coders.elite.bean.Coupon;
import com.coders.elite.bean.Orders;
import com.coders.elite.bean.Orders_Catalog;
import com.coders.elite.bean.Wallet;
import com.coders.elite.dao.BillingDAO;
import com.coders.elite.dao.CatalogDAO;
import com.coders.elite.dao.CouponDAO;
import com.coders.elite.dao.OrderDAO;
import com.coders.elite.dao.Orders_CatalogDAO;
import com.coders.elite.dao.WalletDAO;
import com.coders.elite.model.BillingModel;

public class BillingServiceImpl implements BillingService{
	
	@Autowired
	BillingDAO billingDAO;
	
	@Autowired 
	OrderDAO orderDAO;
	
	@Autowired
	CatalogDAO catalogDAO;
	
	@Autowired
	Orders_CatalogDAO orderCatalogDAO;
	
	@Autowired
	CouponDAO couponDAO;
	
	@Autowired
	WalletDAO walletDAO;
	
	private Billing bill;

	@Transactional
	@Override
	public List<Billing> getAllBill() {
		return billingDAO.getAllBills();
	}

	@Transactional
	@Override
	public Billing getBillById(int id) {
		return billingDAO.getBillById(id);
	}

	@Transactional
	@Override
	public Billing getBillByOrderId(int order_id) {
		return billingDAO.getBillByOrderId(order_id);
	}

	@Transactional
	@Override
	public List<Billing> getBillByUser(int user_Id) {
		return billingDAO.getBillByUserId(user_Id);
	}

	@Transactional
	@Override
	public void addBill(BillingModel bill) {
		bill.setBill_amt(calBill(bill.getOrder_id()));	
		bill.setBill_status("Pending");
		billingDAO.addBill(bill);
	}

	public int calBill(int order_id){
		List<Orders_Catalog> orderCatalogList = orderCatalogDAO.getOrders(order_id);
		ListIterator ltr = orderCatalogList.listIterator();
		int amt=0;
		while(ltr.hasNext()){
			Orders_Catalog ordCat = (Orders_Catalog)ltr.next(); 
			int rate = Integer.parseInt(ordCat.getCatalog().getRate());
			int qty = ordCat.getQuantity();
			amt = amt +(rate*qty);
		}
		// Write code to apply coupan
		Orders order = orderDAO.getOrderById(order_id);
		Coupon coupon = couponDAO.getCoupon(order.getCoupon().getCoupon_id());
		// if (sysdate()>coupon.validity())
				// Coupon calculation need to be done. 
		return amt;
	}
	
	public int applyWallet(int user_id,int order_id, int amt){
		// code to use wallet amt for payment
		Orders order = orderDAO.getOrderById(order_id);
		Wallet wallet = walletDAO.getWalletUser(order.getUser().getId());
		int wamt;
		if(wallet.getWalletAmt()> amt){
			wamt = wallet.getWalletAmt() - amt;
		}
	    wamt = amt - wallet.getWalletAmt();
		return wamt;
		
	}
	
	
	
	@Override
	@Transactional
	public void updateBill(Billing bill) {
		billingDAO.updateBill(bill);
		
	}

	@Override
	@Transactional
	public void deleteBill(int id) {
		billingDAO.deleteBill(id);
		
	}

}
