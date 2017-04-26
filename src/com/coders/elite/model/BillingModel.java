package com.coders.elite.model;


public class BillingModel {
	
	private int bill_amt;
	
	private String bill_status;
	
	private int order_id;
	
	private int wallet_id;

	public BillingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillingModel(String bill_status, int order_id, int wallet_id) {
		super();
		this.bill_status = bill_status;
		this.order_id = order_id;
		this.wallet_id = wallet_id;
	}

	public int getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(int bill_amt) {
		this.bill_amt = bill_amt;
	}

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getWallet_id() {
		return wallet_id;
	}

	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	
}
