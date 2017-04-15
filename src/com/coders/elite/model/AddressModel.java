package com.coders.elite.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AddressModel {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int address_id;
	
	private String address;
	
	private String address_type;
	
	private int user_id;

	
	public AddressModel() {
		super();
	}

	public AddressModel(int address_id, String address, String address_type, int user_id) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address_type = address_type;
		this.user_id = user_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
		
}
