package com.coders.elite.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@Column(name="pickup_date")
	private Date pickup_date;
	
	//private Date delivery_date;
	@Column(name="pickup_time")
	private String pickup_time;
	
	@Column(name="delivery_date")
	private Date delivery_date;
	
	@Column(name="delivery_time")
	private String delivery_time;
	
	//private Time delivery_time;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="coupon_id")
	private Coupon coupon;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ORDERS_CATALOG",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "catalog_id"))
	private List <Catalog> catalog = new ArrayList<Catalog>(0);
	
	public Orders() {
		super();
	}

	public Orders(String order_type, String order_status, Date pickup_date, String pickup_time, Date delivery_date, String delivery_time) {
		super();
		this.order_type = order_type;
		this.order_status = order_status;
		this.pickup_date = pickup_date;
		this.pickup_time = pickup_time;
		this.delivery_date = delivery_date;
		this.delivery_time = delivery_time;
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
	
	public Date getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}

	public String getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public List<Catalog> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Catalog> catalog) {
		this.catalog = catalog;
	}
	
	
	
}