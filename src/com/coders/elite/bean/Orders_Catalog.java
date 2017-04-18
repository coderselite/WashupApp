package com.coders.elite.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table ( name = "Orders_catalog")
public class Orders_Catalog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "orders_catalog_id")
	private int orders_catalog_id;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id")
	private Catalog catalog;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
	private Orders orders;
	
    @Column (name = "quantity")
	private int quantity;

	public Orders_Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrders_catalog_id() {
		return orders_catalog_id;
	}

	public void setOrders_catalog_id(int orders_catalog_id) {
		this.orders_catalog_id = orders_catalog_id;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Orders getOrder() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
