package com.coders.elite.model;

public class OrderModel {

	private String order_type;
	
	private String order_status = "SUBMITTED";
	
	private int user_id;
	
	private int coupon_id;

	public OrderModel() {
		super();
	}

	public OrderModel(String order_type, String order_status, int user_id, int coupon_id) {
		super();
		this.order_type = order_type;
		this.order_status = order_status;
		this.user_id = user_id;
		this.coupon_id = coupon_id;
	}


	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
}
