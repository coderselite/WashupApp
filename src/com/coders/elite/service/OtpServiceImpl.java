package com.coders.elite.service;

import java.sql.Timestamp;

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
 
 /*
  * @see com.coders.elite.service.OtpService#resendOtp(java.lang.String)
  * Method to resendOtp. Generates a new validOtp and updates it in DB
  * and sends to the reuested mobile number.
  */
 @Transactional
 public Boolean resendOtp(String mobile) {
	 String otp = userService.getValidOtp();
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	// userService.sendOtp(otp, mobile);
	 Otp oldOtp = otpDao.getOtp(mobile);
		 int otpId = oldOtp.getId();
		 Otp updatedOtp = new Otp(otpId, otp, mobile,timestamp);
		 otpDao.updateOtp(updatedOtp);
		 return true;
 }
}
