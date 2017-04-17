package com.coders.elite.model;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {

	private String order_type;
	
	private String order_status = "SUBMITTED";
	
	private String pickup_date;
	
	private String pickup_time;
	
	private String delivery_date;
	
	private String delivery_time;
	
	private int user_id;
	
	private int coupon_id;
	
	private List<CatalogModel> catalogModelList = new ArrayList<CatalogModel>(0);

	public OrderModel() {
		super();
	}


	public OrderModel(String order_type, String order_status, String pickup_date, String pickup_time,String delivery_date, String delivery_time,int user_id, int coupon_id) {
		super();
		this.order_type = order_type;
		this.order_status = order_status;
		this.pickup_date = pickup_date;
		this.pickup_time = pickup_time;
		this.delivery_date = delivery_date;
		this.delivery_time = delivery_time;
		this.user_id=user_id;
		this.coupon_id=coupon_id;
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

	
	public String getPickup_date() {
		return pickup_date;
	}


	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}


	public String getPickup_time() {
		return pickup_time;
	}


	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}

	public String getDelivery_date() {
		return delivery_date;
	}


	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}


	public String getDelivery_time() {
		return delivery_time;
	}


	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
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


	public List<CatalogModel> getCatalogModelList() {
		return catalogModelList;
	}


	public void setCatalogModelList(List<CatalogModel> catalogModelList) {
		this.catalogModelList = catalogModelList;
	}
	
}
