package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Timeslot;

@Repository
public class TimeslotDAOImpl implements TimeslotDAO{
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTimeslots() {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createQuery("select T.timeslot from Timeslot T").list();
	}

	@Override
	public void addTimeslot(Timeslot timeslot) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(timeslot);
		
	}

	@Override
	public void updateTimeslot(Timeslot timeslot) {
		Session session = sessionFactory.getCurrentSession();
		session.update(timeslot);
		
	}

	@Override
	public void deleteTimeslot(int id) {
		Session session = sessionFactory.getCurrentSession();
		Timeslot t = (Timeslot) session.load(Timeslot.class, new Integer(id));
		
		if(t != null) {
			session.delete(t);
		}
		
	}

	 
}
