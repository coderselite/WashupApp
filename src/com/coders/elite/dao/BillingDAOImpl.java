package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Billing;
import com.coders.elite.model.BillingModel;


@Repository
public class BillingDAOImpl implements BillingDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Billing> getAllBills() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Billing> bills = session.createQuery("from Billing").list();
		return bills;
	}

	@Override
	public Billing getBillById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Billing bill = (Billing)session.load(Billing.class, new Integer(id));
		return bill;
	}

	@Override
	public void addBill(BillingModel bill) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bill);
		
	}

	@Override
	public List<Billing> getBillByUserId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Billing> bill = session.createQuery(" from Billing B where B.order.user_id: user_id").setParameter("user_id", id).list();
		return bill; 
	}

	@Override
	public Billing getBillByOrderId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Billing bill = (Billing)session.createQuery("from Billing B where B.order.order_id: order_id").setParameter("order_id", id).list();
		return bill;
	}

	@Override
	public void updateBill(Billing bill) {
	Session session = this.sessionFactory.getCurrentSession();
	session.update(bill);
		
	}

	@Override
	public void deleteBill(int bill_id) {
		Session session =this.sessionFactory.getCurrentSession();
		Billing bill = (Billing)session.load(Billing.class, new Integer(bill_id));
		if(bill!=null){
			session.delete(bill);
		}
		
	}

}
