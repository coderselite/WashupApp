package com.coders.elite.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * This is our model class and it corresponds to Catalog table in database
 */
@Entity
@Table(name="CATALOG") @Proxy (lazy = false)
public class Catalog {

	@Id
	@Column(name="catalog_id")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer catalog_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="category")
	private String category;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "catalog", fetch = FetchType.EAGER)
	private List <Orders_Catalog> orders = new ArrayList<Orders_Catalog>(0);
 
	public Catalog() {
		super();
	}
	

	public Catalog(Integer catalog_id, String name, String rate, String category) {
		super();
		this.catalog_id = catalog_id;
		this.name = name;
		this.rate = rate;
		this.category = category;
	}


	public Integer getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(Integer catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Orders_Catalog> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders_Catalog> orders) {
		this.orders = orders;
	}
		
}