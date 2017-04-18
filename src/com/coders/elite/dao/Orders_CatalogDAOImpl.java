package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Orders_Catalog;

@Repository
public class Orders_CatalogDAOImpl implements Orders_CatalogDAO{

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders_Catalog> getOrders(int order_id) {
		System.out.println("Inside getOrders of Orders_CatalogDAO");
		Session session = sessionFactory.getCurrentSession();
		List <Orders_Catalog> list = session.createQuery("from Orders_Catalog OC where OC.orders.order_id= :order_id").setParameter("order_id", order_id).list();
		return list;
	}

	@Override
	public void addOrders_Catalog(Orders_Catalog oc) {
		Session session = sessionFactory.getCurrentSession();	
		session.persist(oc);
		
	}

	@Override
	public void updateOrders_Catalog(Orders_Catalog oc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrders_Catalog(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
