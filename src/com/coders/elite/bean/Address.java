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

/*
 * This is our model class and it corresponds to Address table in database
 */
@Entity
@Table (name="ADDRESS") @Proxy(lazy=false)
public class Address {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int address_id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="address_type")
	private String address_type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="user_id")
	private Users user;
	
	public Address() {
		super();
	}

	public Address(int address_id, String address, String address_type) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address_type = address_type;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_type() {
		return address_type;
	}

	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		
		this.user = user;
	}

}
