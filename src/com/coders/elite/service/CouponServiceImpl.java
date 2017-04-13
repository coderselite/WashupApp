package com.coders.elite.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Coupon;
import com.coders.elite.dao.CouponDAO;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	CouponDAO couponDao;
	
	@Override
	@Transactional
	public List<Coupon> getAllCoupons() {
		return couponDao.getAllCoupons();
	}

	@Override
	@Transactional
	public void addCoupon(Coupon coupon) {
		couponDao.addCoupon(coupon);
		
	}

	@Override
	@Transactional
	public void updateCoupon(Coupon coupon) {
		couponDao.updateCoupon(coupon);
		
	}

	@Override
	@Transactional
	public void deleteCoupon(int id) {
		couponDao.deleteCoupon(id);
		
	}

}
