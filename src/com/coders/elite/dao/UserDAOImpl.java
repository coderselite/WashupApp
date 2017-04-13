package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class UserDAOImpl implements UserDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 @SuppressWarnings("unchecked")
public List<Users> getAllUsers() {
  Session session = this.sessionFactory.getCurrentSession();
  List<Users> userList = session.createQuery("from Users").list();
  return userList;
 }
 
 public Users getUser(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  Users user = (Users) session.load(Users.class, new Integer(id));
  return user;
 }
 
 public Users getUser(String mobile) {
	  Session session = this.sessionFactory.getCurrentSession();
	  @SuppressWarnings("unchecked")
	List<Users> list = (List <Users>) session.createQuery("from Users U where U.mobile = :mobile").setParameter("mobile", mobile).list();
			  if (list.size()>0) {
			    return list.get(0);
			  }
			  return null;
	 }
 
 public Users addUser(Users user) {
  System.out.println("inside addUser dao");
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(user);
  return user;
 }
 
 public void updateUser(Users user) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(user);
 }
 
 public void deleteUser(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  Users u = (Users) session.load(Users.class, new Integer(id));
  if (null != u) {
   session.delete(u);
  }
 }
 
public Users verifyReferralCode( String referralCode ){
	 Session session = this.sessionFactory.getCurrentSession();
	 @SuppressWarnings("unchecked")
	List <Users> list = (List <Users> ) session.createQuery("from Users U where U.referralCode = :referralCode").setParameter("referralCode", referralCode).list();
	 if (list.size()>0){
		 return list.get(0);
	 }
	 return null;
 }
}
