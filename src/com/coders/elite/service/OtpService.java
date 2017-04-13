package com.coders.elite.service;

import com.coders.elite.bean.Otp;
 

public interface OtpService {
 
 public Otp getOtp(String mobile);
 
 public void addOtp(Otp otp);
 
 public void updateOtp(Otp otp);
 
 public void deleteOtp(int id);
 
 public void deleteExpiredOtp();
 
 public Boolean validateOtp(Otp otp);
}
