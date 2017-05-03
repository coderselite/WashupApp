package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.coders.elite.bean.Billing;
import com.coders.elite.model.BillingModel;
import com.coders.elite.service.BillingService;

public class BillingController {
	
	@Autowired
	BillingService billingService;

	@RequestMapping (value = "/getAllBill", method= RequestMethod.GET, headers = "Accept=application/json")
	public List<Billing> getAllBill(){
		List<Billing> bills =billingService.getAllBill(); 
		return bills;
	}
	
	@RequestMapping (value ="/getBill/id/{id}", method= RequestMethod.GET, headers ="Accept=application/json")
	public Billing getBill(@PathVariable Integer id){
		return billingService.getBillById(id);
	}
	
	@RequestMapping (value ="/getBillByUser/user_Id/{user_Id}", method= RequestMethod.GET, headers ="Accept=application/json")
	public List<Billing> getBillByUser(@PathVariable Integer user_Id){
		List<Billing> listofUserBill =billingService.getBillByUser(user_Id);
		return listofUserBill;
	}
	
	@RequestMapping (value ="/getBillByOrder/order_id/{order_id}", method = RequestMethod.GET, headers ="Accept=application/json")
	public Billing getBillByOrder(@PathVariable Integer order_id){
		return billingService.getBillByOrderId(order_id);
	}
	
	@RequestMapping (value ="/addBill", method = RequestMethod.POST, headers="Accept=application/json")
	public void addBill(@RequestBody BillingModel bill){
		billingService.addBill(bill);
	}
	
	@RequestMapping(value="/updateBill", method = RequestMethod.PUT, headers ="Accept=application/json")
	public void updateBill(@RequestBody Billing bill){
		billingService.updateBill(bill);
	}
	
	@RequestMapping(value="/deleteBill/id/{id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public void deleteBill(@PathVariable Integer id){
		billingService.deleteBill(id);
	}
	
}
