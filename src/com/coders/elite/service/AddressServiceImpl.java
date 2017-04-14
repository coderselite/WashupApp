package com.coders.elite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Address;
import com.coders.elite.dao.AddressDAO;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDAO addressDao;
	
	@Override
	public List<Address> getAllAddresses(int userId) {
		return addressDao.getAllAddresses(userId);
	}

	@Override
	public void addAddress(Address address) {
		addressDao.addAddress(address);
		
	}

	@Override
	public void updateAddress(Address address) {
		addressDao.updateAddress(address);
		
	}

	@Override
	public void deleteAddress(int address_id) {
		addressDao.deleteAddress(address_id);
		
	}

}
