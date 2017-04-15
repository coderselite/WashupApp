package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coders.elite.bean.Address;
import com.coders.elite.model.AddressModel;
import com.coders.elite.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
@RequestMapping(value = "/getAddress/userid/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Address> getAddressById(@PathVariable Integer userId){
	return addressService.getAllAddresses(userId);
}	
	 @RequestMapping(value = "/addAddress", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addAddress(@RequestBody AddressModel address) {
		 System.out.println("inside addAddress Controller");
		 addressService.addAddress(address);
	  
	 }
	 
	 @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateAddress(@RequestBody Address address) {
		 addressService.updateAddress(address);
	 }
	 
	 @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteUser(@PathVariable("id") int id) {
		 addressService.deleteAddress(id); 
}
}
