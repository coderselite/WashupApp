package com.coders.elite.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
 
/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="OTP") @Proxy(lazy = false)
public class Otp{
 
 @Id
 @Column(name="otpId")
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 Integer otpId;
 
 @Column(name="otp")
 String otp; 
 
 @Column(name="mobile")
 String mobile; 
 
 public Otp() {
  super();
 }
 
 public Otp(String otp, String mobile)
 {
	  this.otp= otp;
	  this.mobile = mobile; 
 }
 
 public Otp(int i, String otp, String mobile) {
  super();
  this.otpId = i;
  this.otp= otp;
  this.mobile = mobile;
 }
 
 public int getId() {
  return otpId;
 }
 
 public void setId(int id) {
  this.otpId = id;
 }
 
 public String getOtp() {
  return otp;
 }
 
 public void setOtp(String otp) {
  this.otp = otp;
 }
 
 public String getMobile() {
	  return mobile;
	 }
	 
	 public void setMobile(String mobile) {
	  this.mobile = mobile;
	 }
 
 
}
 
