package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Coupon;

public interface CouponDAO {

	public List<Coupon> getAllCoupons();
	 
	 public void addCoupon(Coupon coupon);
	 
	 public void updateCoupon(Coupon coupon);
	 
	 public void deleteCoupon(int id);
}
