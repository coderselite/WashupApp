package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Orders;
import com.coders.elite.model.OrderModel;

public interface OrderService {

	public List <OrderModel> getOrders(int userid);
	
	public void addOrder(Orders order);
	
	public void updateOrder(Orders order);
	
	public void deleteOrder(int id);
	
	public void addOrder(OrderModel order);
}
