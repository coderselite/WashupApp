package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Coupon;
import com.coders.elite.service.CouponService;

 
@RestController
public class CouponController {
	@Autowired
	 CouponService couponService;

	 @RequestMapping(value = "/getAllCoupons", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List <Coupon> getAllCoupons() {
	  return couponService.getAllCoupons();
	 }
	 
	 @RequestMapping(value = "/addCoupon", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCoupon(@RequestBody Coupon coupon) { 
	  couponService.addCoupon(coupon);
	  
	 }
	 
	 @RequestMapping(value = "/updateCoupon", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCoupon(@RequestBody Coupon coupon) {
	  couponService.updateCoupon(coupon);
	 }
	 
	 @RequestMapping(value = "/deleteCoupon/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCoupon(@PathVariable("id") int id) {
		 couponService.deleteCoupon(id);  
	 }

}
