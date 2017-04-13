package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Coupon;

@Repository
public class CouponDAOImpl implements CouponDAO{

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	
	@SuppressWarnings("unchecked")
	public List <Coupon> getAllCoupons()
	{
		  Session session = this.sessionFactory.getCurrentSession();
		  return (List <Coupon>) session.createQuery("from Coupon").list();
	}
	
	 public void addCoupon(Coupon coupon) {
		  System.out.println("inside addCoupon dao");
		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(coupon);
		 }
		 
		 public void updateCoupon(Coupon coupon) {
		  Session session = this.sessionFactory.getCurrentSession();
		  session.update(coupon);
		 }
		 
		 public void deleteCoupon(int id) {
		  Session session = this.sessionFactory.getCurrentSession();
		  Coupon c = (Coupon) session.load(Coupon.class, new Integer(id));
		  if (null != c) {
		   session.delete(c);
		  }
		 }
}
