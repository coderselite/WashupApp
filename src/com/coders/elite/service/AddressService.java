package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Address;
import com.coders.elite.model.AddressModel;

public interface AddressService {

	public List <AddressModel> getAllAddresses(int userId);
	
	public void addAddress(AddressModel address);
	
	public void updateAddress(Address address);
	
	public void deleteAddress(int address_id);
}
