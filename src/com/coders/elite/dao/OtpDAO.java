package com.coders.elite.dao;

import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Otp;
 
@Repository
public interface OtpDAO {

public Otp getOtp(String mobile);
 
 public void addOtp(Otp otp);
 
 public void updateOtp(Otp otp);
 
 public void deleteOtp(int id);
 
 public void deleteExpiredOtp();
 
 public String getValidOtp(String mobile);
 
 } 

