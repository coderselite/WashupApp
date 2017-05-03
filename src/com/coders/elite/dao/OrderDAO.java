package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Orders;

public interface OrderDAO {

	public List <Orders> getOrders(int userid);
	
	public Orders getOrderById(int order_id);
	
	public void addOrder(Orders order);
	
	public void updateOrder(Orders order);
	
	public void deleteOrder(int id);
	
}
