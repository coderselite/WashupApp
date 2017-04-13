package com.coders.elite.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.coders.elite.bean.Otp;
import com.coders.elite.bean.Users;
import com.coders.elite.dao.OtpDAOImpl;
import com.coders.elite.dao.UserDAOImpl;
 
@Service("userService")
public class UserServiceImpl implements UserService {
 
	@Autowired
	UserDAOImpl userDao;
	
	@Autowired
	OtpDAOImpl otpDao;
	
	private Users user;
	private String referralCode;
	 
	 @Transactional
	 public List<Users> getAllUsers() {
		 return userDao.getAllUsers();
	 }
	 
	 @Transactional
	 public Users getUser(Integer id) {
		 return userDao.getUser(id);
	 }
	 
	 @Transactional
	 public Users getUser(String mobile) {
		 return userDao.getUser(mobile);
	 }
	 
	 @Transactional
	 public void addUser(Users user) {
		 System.out.println("inside ad user service");
		 user.setReferralCode(verifyReferralCode());
		 userDao.addUser(user);
	 }
	 
	 @Transactional
	 public void updateUser(Users user) {
		 userDao.updateUser(user);
	 }
	 
	 @Transactional
	 public void deleteUser(int id) {
		 userDao.deleteUser(id);
	 }
	 	 
	 /*
	  *@see com.coders.elite.service.UserService#generateReferralCode()
	  * Method generates random referral code of length 8 bits
	  */
	 @Transactional
	 public String generateReferralCode(){
		 char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
	     StringBuilder sb = new StringBuilder();
	     Random random = new SecureRandom();
	     for (int i = 0; i < 8; i++) {
	    	 char c = chars[random.nextInt(chars.length)];
	         sb.append(c);
	     }
	     String output = sb.toString();
	     System.out.println(output);
	     return output ;
	 }
	 
	 /*
	  * @see com.coders.elite.service.UserService#verifyReferralCode()
	  * Method to check the uniqueness of code in database
	  */
	 @Transactional
	 public String verifyReferralCode(){
		do{
			 this.referralCode = this.generateReferralCode();
			 this.user = (Users) userDao.verifyReferralCode(this.referralCode);
		 }
		 while( this.user != null );
		 return referralCode;
	 }
	 
	 @Transactional
	 public String generateOtp(){
		 List<Integer> numbers = new ArrayList<>();
		    for(int i = 0; i < 10; i++){
		        numbers.add(i);
		    }

		    Collections.shuffle(numbers);

		    String otp = "";
		    for(int i = 0; i < 4; i++){
		        otp += numbers.get(i).toString();
		    }
	        System.out.println("Otp: " +otp);
		    return otp;
	 }
	
	 
	 /*
	  * Method to send Otp to users mobile.
	  */
	@SuppressWarnings("deprecation")
	@Transactional
	 public void sendOtp(String otp, String mobile){
		    AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJRZSLJUVMEW22JTQ", "8Ue50ksWws47ah1dAgtuvOaWbiEmFTxhqoNaUMRy");
		    final AmazonSNSClient client = new AmazonSNSClient(awsCredentials);
		    client.withRegion(Regions.US_WEST_1);
		    String message = "OTP for login to Washup is:" + otp;
		    String phoneNumber = "+91"+mobile;
		    Map<String, MessageAttributeValue> smsAttributes = 
		            new HashMap<String, MessageAttributeValue>();
		    smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
		            .withStringValue("Elite-Coders"));
		    PublishResult result = client.publish(new PublishRequest()
            .withMessage(message)
            .withPhoneNumber(phoneNumber)
            .withMessageAttributes(smsAttributes)
            );
	 }
	 
	 /*
	  * Method to verify mobile number for new User/Login for existing user.
	  */
	 @Transactional
	 public String validateUser(String mobile){
		 String otp = this.generateOtp();
//		 this.sendOtp(otp, mobile);
	   Users user = this.getUser(mobile);
			 if (user != null)
			 {
				 Otp oldOtp = otpDao.getOtp(mobile);
				 if(oldOtp != null)
				 {
					 int otpId = oldOtp.getId();
					 Otp updatedOtp = new Otp(otpId, otp, mobile);
					 otpDao.updateOtp(updatedOtp); 
				 }
				 else
				 {
					 Otp newOtp = new Otp(otp, mobile);
					 otpDao.addOtp(newOtp); 
				 }
				 return "Registered User";
				 
			 }
			 else
			 {
				 Otp newOtp = new Otp(otp, mobile);
				 otpDao.addOtp(newOtp);
				 return "New User";
			 }
	 }	 
	 
}
