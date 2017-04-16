package com.coders.elite.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table (name = "ORDERS") @Proxy(lazy=false)
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="order_type")
	private String order_type;
	
	@Column(name="order_status")
	private String order_status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="coupon_id")
	private Coupon coupon;
	
	public Orders() {
		super();
	}

	public Orders(int order_id, String order_type, String order_status) {
		super();
		this.order_id = order_id;
		this.order_type = order_type;
		this.order_status = order_status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Users getUser() {
		return user1;
	}

	public void setUser(Users user) {
		this.user1 = user;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	
}