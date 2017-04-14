package com.coders.elite.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Address> getAllAddresses(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Address A where A.user.userId=:userId").setParameter("userId", userId).list();
	}

	@Override
	@Transactional
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteAddress(int address_id) {
		// TODO Auto-generated method stub
		
	}

}
