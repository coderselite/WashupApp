package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Otp;
import com.coders.elite.bean.Users;
 
@Repository
public class OtpDAOImpl implements OtpDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 


 @SuppressWarnings("unchecked")
public Otp getOtp(String mobile) {
	  Session session = this.sessionFactory.getCurrentSession();
	  List <Otp> list = (List <Otp>) session.createQuery("from Otp O where O.mobile = :mobile").setParameter("mobile", mobile).list();
	  session.flush();
	  session.clear();
	  if ( list.size() > 0)
	  {
		  return list.get(0);
	  }
	  return null;
	 }
 
 public void addOtp(Otp otp) {
  Session session = this.sessionFactory.getCurrentSession();
  session.save(otp);
 }
 
 public void updateOtp(Otp otp) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(otp);
 }
 
 public void deleteOtp(int id) {
	  Session session = this.sessionFactory.getCurrentSession();
	  Otp o = (Otp) session.load(Users.class, new Integer(id));
	  if (null != o) {
	   session.delete(o);
	  }
	 }
public void deleteExpiredOtp()
{
	  Session session = this.sessionFactory.getCurrentSession();
	  session.createSQLQuery("delete from Otp where timestamp < (select DATE_SUB( CURRENT_TIME(), INTERVAL 10 MINUTE) from Dual)").executeUpdate();
}

@SuppressWarnings("unchecked")
public String getValidOtp(String mobile){
	Session session = this.sessionFactory.getCurrentSession();
	List<String> list= (List<String>)session.createSQLQuery("select otp from Otp where timestamp > (select DATE_SUB( CURRENT_TIME(), INTERVAL 10 MINUTE) from Dual)").list();
	
	if(list.size() > 0){
		return list.get(0);
	}
	return null;
	
}
 
 } 

