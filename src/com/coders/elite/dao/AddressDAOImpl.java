package com.coders.elite.dao;

import java.util.List;

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
	public List<Address> getAllAddresses(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Address A where A.user.user_id=:userId").setParameter("userId", userId).list();
	}

	@Override
	public void addAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(address);
		
	}

	@Override
	public void updateAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
	    session.update(address);
	}

	@Override
	public void deleteAddress(int address_id) {
		Session session = sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(address_id));
		
		if(address != null){
			session.delete(address);
		}
		
	}

}
