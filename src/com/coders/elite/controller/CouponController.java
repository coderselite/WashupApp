package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	/*
	 * Service to get all coupons from coupon table.
	 */
	 @RequestMapping(value = "/getAllCoupons", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List <Coupon> getAllCoupons() {
	  return couponService.getAllCoupons();
	 }
	 
	 /*
	  * Service to add a coupon to the table.
	  */
	 @RequestMapping(value = "/addCoupon", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCoupon(@RequestBody Coupon coupon) { 
	  couponService.addCoupon(coupon);
	  
	 }
	 
	 /*
	  * Service to update an existing coupon in the table.
	  */
	 @RequestMapping(value = "/updateCoupon", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCoupon(@RequestBody Coupon coupon) {
	  couponService.updateCoupon(coupon);
	 }
	 
	 /*
	  * Service to delete a coupon specied by the coupon_id from the table.
	  */
	 @RequestMapping(value = "/deleteCoupon/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCoupon(@PathVariable("id") int id) {
		 couponService.deleteCoupon(id);  
	 }

}
