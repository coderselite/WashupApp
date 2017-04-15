package com.coders.elite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coders.elite.bean.Otp;
import com.coders.elite.dao.OtpDAO;
 
@Service("otpService")
public class OtpServiceImpl implements OtpService {
 
 @Autowired
 OtpDAO otpDao;
 
@Autowired
UserService userService;

 @Transactional
 public Otp getOtp(String mobile) {
 return otpDao.getOtp(mobile);
 }
 
 @Transactional
 public void addOtp(Otp otp) {
  otpDao.addOtp(otp);
 }
 
 @Transactional
 public void updateOtp(Otp otp) {
  otpDao.updateOtp(otp);
 
 }
 
 @Transactional
 public void deleteOtp(int id) {
  otpDao.deleteOtp(id);
  
 }

 
 @Transactional
 public void deleteExpiredOtp()
 {
	 otpDao.deleteExpiredOtp();
 }


 @Transactional
 public Boolean validateOtp(Otp otpObj){
	 String otp = otpObj.getOtp();
	 String mobile = otpObj.getMobile();
	 
	 if (otpDao.getValidOtp(mobile) != null && otp.equals(otpDao.getValidOtp(mobile)))
		 return true;
	 
	 return false;
 }
 
 @Transactional
 public Boolean resendOtp(String mobile) {
	 String otp = userService.getValidOtp();
	// userService.sendOtp(otp, mobile);
	 Otp oldOtp = otpDao.getOtp(mobile);
		 int otpId = oldOtp.getId();
		 Otp updatedOtp = new Otp(otpId, otp, mobile);
		 otpDao.updateOtp(updatedOtp);
		 return true;
 }
}
