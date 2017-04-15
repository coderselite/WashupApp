package com.coders.elite.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="USERS") @Proxy(lazy = false)
public class Users implements Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
 @Column(name="user_id")
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer user_id;
 
 @Column(name="firstName")
 private String firstName; 
 
 @Column(name="lastName")
 private String lastName;
 
 @Column(name="mobile")
 private String mobile;
  
 @Column(name="referralCode")
 private String referralCode;
 
 @JsonIgnore
 @OneToMany (cascade=CascadeType.ALL, mappedBy="user", fetch = FetchType.EAGER)
 private List<Address> addresses = new ArrayList<Address>(0);
 
 public Users() {
  super();
 }
 
 public Users(int i, String firstName, String lastName, String mobile, String referralCode ) {
  super();
  this.user_id = i;
  this.firstName = firstName;
  this.lastName=lastName;
  this.mobile=mobile;
  this.referralCode=referralCode;
 }
 
 public int getId() {
  return user_id;
 }
 
 public void setId(int id) {
  this.user_id = id;
 }
 
 public String getFirstName() {
  return firstName;
 }
 
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
  }
	 
 public void setLastName(String lastName) {
  this.lastName = lastName;
  }
	 
 public String getMobile() {
  return mobile;
  }
		 
public void setMobile(String mobile) {
 this.mobile = mobile;
 }

public String getReferralCode() {
	return referralCode;
}

public void setReferralCode(String referralCode) {
	this.referralCode = referralCode;
}

public List<Address> getAddresses(){
	return addresses;
}

public void setAddresses(List<Address> addresses){
this.addresses = addresses;
}
}
 
