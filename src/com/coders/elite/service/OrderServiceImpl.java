package com.coders.elite.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Catalog;
import com.coders.elite.bean.Coupon;
import com.coders.elite.bean.Orders;
import com.coders.elite.bean.Users;
import com.coders.elite.dao.CatalogDAO;
import com.coders.elite.dao.CouponDAO;
import com.coders.elite.dao.OrderDAO;
import com.coders.elite.dao.UserDAO;
import com.coders.elite.model.CatalogModel;
import com.coders.elite.model.OrderModel;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CouponDAO couponDao;
	
	@Autowired
	CatalogDAO catalogDao;
	
	/*
	 * @see com.coders.elite.service.OrderService#getOrders(int)
	 * Returns all the orders for the requested user in the OrderModel format.
	 */
	@Override
	@Transactional
	public List<OrderModel> getOrders(int userid) {
		List<OrderModel> responseList = new ArrayList<OrderModel>(0);
		List<Orders> list = (List <Orders>) orderDao.getOrders(userid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (list.size() > 0) {
			for(int i=0 ; i <list.size() ;i++) {
				Date pdate = list.get(i).getPickup_date();
				Date ddate = list.get(i).getDelivery_date();
				String pickup_date = sdf.format(pdate);
				String delivery_date = sdf.format(ddate);
				Orders obj = list.get(i);
				OrderModel orderModel = new OrderModel(obj.getOrder_type(),obj.getOrder_status(),
						pickup_date,obj.getPickup_time(),delivery_date, obj.getDelivery_time(),
						obj.getUser().getId(),obj.getCoupon().getCoupon_id());
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date pickup_date=null;
		Date delivery_date = null;
		try {
			pickup_date = sdf.parse(order.getPickup_date());
			delivery_date = sdf.parse(order.getDelivery_date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Orders orderNew = new Orders(order.getOrder_type(),order.getOrder_status(),pickup_date,
				order.getPickup_time(),delivery_date, order.getDelivery_time());
		int user_id = order.getUser_id();
		int coupon_id = order.getCoupon_id();
		Users user = userDao.getUser(user_id);
		Coupon coupon = couponDao.getCoupon(coupon_id);
		List <Catalog> catalogList = new ArrayList<Catalog>(0);
		List <CatalogModel> catalogModel = order.getCatalogModelList();
		for (int i=0; i<catalogModel.size();i++){
			Catalog catalog = catalogDao.getCatalog(catalogModel.get(i).getCatalog_id());
			catalogList.add(catalog);
		}
		orderNew.setUser(user);
		orderNew.setCoupon(coupon);
		orderNew.setCatalog(catalogList);
		orderDao.addOrder(orderNew);
	}

}
