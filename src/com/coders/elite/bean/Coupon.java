package com.coders.elite.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * This is our model class and it corresponds to Coupon table in database
 */
@Entity
@Table(name="COUPON") @Proxy(lazy = false)
public class Coupon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coupon_id")
	private int coupon_id;
	
	@Column(name="coupon_code")
	private String coupon_code;
	
	@Column(name="details")
	private String details;
	
	 @JsonIgnore
	 @OneToMany (cascade=CascadeType.ALL, mappedBy="coupon", fetch = FetchType.EAGER)
	private List <Orders> order = new ArrayList<Orders>(0);
	 
	public Coupon() {
		super();
	}

	public Coupon(int coupon_id, String coupon_code, String details) {
		super();
		this.coupon_id = coupon_id;
		this.coupon_code = coupon_code;
		this.details = details;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	
}
