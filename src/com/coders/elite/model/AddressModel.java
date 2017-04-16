package com.coders.elite.model;

public class AddressModel {

	/*
	 * This class maps to the request response object for Address.
	 */	
	private String address;
	
	private String address_type;
	
	private int user_id;

	
	public AddressModel() {
		super();
	}

	public AddressModel(String address, String address_type, int user_id) {
		super();
		this.address = address;
		this.address_type = address_type;
		this.user_id = user_id;
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
