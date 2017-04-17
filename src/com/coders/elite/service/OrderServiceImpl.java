package com.coders.elite.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Coupon;
import com.coders.elite.bean.Orders;
import com.coders.elite.bean.Users;
import com.coders.elite.dao.CouponDAO;
import com.coders.elite.dao.OrderDAO;
import com.coders.elite.dao.UserDAO;
import com.coders.elite.model.OrderModel;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CouponDAO couponDao;
	
	/*
	 * @see com.coders.elite.service.OrderService#getOrders(int)
	 * Returns all the orders for the requested user in the OrderModel format.
	 */
	@Override
	@Transactional
	public List<OrderModel> getOrders(int userid) {
		List<OrderModel> responseList = new ArrayList<OrderModel>(0);
		List<Orders> list = (List <Orders>) orderDao.getOrders(userid);
		if (list.size() > 0) {
			for(int i=0 ; i <list.size() ;i++) {
				OrderModel orderModel = new OrderModel();
				orderModel.setOrder_type(list.get(i).getOrder_type());
				orderModel.setOrder_status(list.get(i).getOrder_status());
				orderModel.setUser_id(list.get(i).getUser().getId());
				orderModel.setCoupon_id(list.get(i).getCoupon().getCoupon_id());
				responseList.add(orderModel);
			}
		}
		return responseList;
	}

	@Override
	@Transactional
	public void addOrder(Orders order) {
		System.out.println("Inside Order Service class");
		orderDao.addOrder(order);
		
	}

	@Override
	@Transactional
	public void updateOrder(Orders order) {
		orderDao.updateOrder(order);
		
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		orderDao.deleteOrder(id);
		
	}

	/*
	 * @see com.coders.elite.service.OrderService#addOrder(com.coders.elite.model.OrderModel)
	 * This method takes the OrderModel object from controller and creates a Orders object
	 * which is then passed on to persist to the database.
	 */
	@Override
	@Transactional
	public void addOrder(OrderModel order) {
		Orders orderNew = new Orders();
		int user_id = order.getUser_id();
		int coupon_id = order.getCoupon_id();
		Users u = userDao.getUser(user_id);
		Coupon c = couponDao.getCoupon(coupon_id);
		orderNew.setOrder_type(order.getOrder_type());
		orderNew.setOrder_status(order.getOrder_status());
		orderNew.setUser(u);
		orderNew.setCoupon(c);
		
		orderDao.addOrder(orderNew);
	}

}
