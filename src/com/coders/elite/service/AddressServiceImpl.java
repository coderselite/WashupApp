package com.coders.elite.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Address;
import com.coders.elite.bean.Users;
import com.coders.elite.dao.AddressDAO;
import com.coders.elite.dao.UserDAO;
import com.coders.elite.model.AddressModel;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDAO addressDao;

	@Autowired
	UserDAO userDao;
	
	/*
	 *
	 * @see com.coders.elite.service.AddressService#getAllAddresses(int)
	 * Returns all the addresses for the requested user.
	 */
	@Override
	@Transactional
	public List<AddressModel> getAllAddresses(int userId) {
		List <AddressModel> responseList = new ArrayList<AddressModel>(0);
		List<Address> list = (List <Address>) addressDao.getAllAddresses(userId);
		if (list.size() > 0) {
			for(int i=0 ; i <list.size() ;i++) {
				AddressModel addModel = new AddressModel();
				addModel.setAddress(list.get(i).getAddress());
				addModel.setAddress_type(list.get(i).getAddress_type());
				addModel.setUser_id(list.get(i).getUser().getId());
				responseList.add(addModel);
			}
		}
		return responseList;
	}

	
	/*
	 * @see com.coders.elite.service.AddressService
	 * #addAddress(com.coders.elite.model.AddressModel)
	 * This method takes the AddressModel object from controller and creates a Address object
	 * which is then passed on to persist to the database.
	 */
	@Override
	@Transactional
	public void addAddress(AddressModel address) {
		int userid = address.getUser_id();
		Users u = userDao.getUser(userid);
		Address addressNew = new Address();
		addressNew.setAddress(address.getAddress());
		addressNew.setAddress_type(address.getAddress_type());
		addressNew.setUser(u);
		addressDao.addAddress(addressNew);
		
	}

	@Override
	@Transactional
	public void updateAddress(Address address) {
		addressDao.updateAddress(address);
		
	}

	@Override
	@Transactional
	public void deleteAddress(int address_id) {
		addressDao.deleteAddress(address_id);
		
	}

}
