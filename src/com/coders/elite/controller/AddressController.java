package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Address;
import com.coders.elite.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
@RequestMapping(value = "/getAddress/userid/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Address> getAddressById(@PathVariable Integer userId){
	return addressService.getAllAddresses(userId);
}
}
