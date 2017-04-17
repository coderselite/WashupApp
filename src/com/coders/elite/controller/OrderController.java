package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Orders;
import com.coders.elite.model.OrderModel;
import com.coders.elite.service.OrderService;

//@CrossOrigin(origins="http://localhost:8100", maxAge=4800, allowCredentials="False")
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	/*
	 * Service to get all orders for a specied user.
	 * Takes userid as input and sends response object with order_type,order_status,user_id and coupon_id.
	 */
	 @RequestMapping(value = "/getOrder/userid/{userid}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<OrderModel> getOrdersByUserid(@PathVariable int userid) {
	  return orderService.getOrders(userid);
	 }
	 
  /* @RequestMapping(value = "/addOrder", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addOrder(@RequestBody Orders order) { 
		 System.out.println("Inside Order Controller");
	  orderService.addOrder(order);
	 }*/
	 
	 
	 /*
	  * Service to addOrder to database. 
	  * Input json with order_type,order_status,user_id and coupon_id is mapped to OrderModel object.
	  */
	 @RequestMapping(value = "/addOrder", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addOrderNew(@RequestBody OrderModel order) { 
		 System.out.println("Inside Order Controller");
	  orderService.addOrder(order);
	 }
	 
	 @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateOrder(@RequestBody Orders order) {
	  orderService.updateOrder(order);
	 }
	 
	 @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteOrder(@PathVariable("id") int id) {
		 orderService.deleteOrder(id);  
	 }
	 	
}
