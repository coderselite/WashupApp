package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Address;

public interface AddressService {

	public List <Address> getAllAddresses(int userId);
	
	public void addAddress(Address address);
	
	public void updateAddress(Address address);
	
	public void deleteAddress(int address_id);
}
