package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Coupon;

public interface CouponService {


	public List<Coupon> getAllCoupons();
	 
	 public void addCoupon(Coupon coupon);
	 
	 public void updateCoupon(Coupon coupon);
	 
	 public void deleteCoupon(int id);
}
