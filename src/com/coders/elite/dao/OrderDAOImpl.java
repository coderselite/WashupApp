package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO{

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrders(int userid) {
		Session session = sessionFactory.getCurrentSession();
		List <Orders> list = session.createQuery("from Orders O where O.user.user_id = :userid").setParameter("userid", userid).list();
		return list;
	}

	@Override
	public void addOrder(Orders order) {
		System.out.println("Inside order Dao Class");
		Session session = sessionFactory.getCurrentSession();	
		session.persist(order);
	}

	@Override
	public void updateOrder(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
		
	}

	@Override
	public void deleteOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders) session.load(Orders.class, new Integer(id));
		if(order != null){
			session.delete(order);
		}
		
	}

	@Override
	public Orders getOrderById(int order_id) {
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders)session.load(Orders.class, new Integer(order_id));
		return order;
	}

}
