package com.coders.elite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Otp;
import com.coders.elite.service.OtpService;


@RestController
public class OtpController {
 
 @Autowired
 OtpService otpService;

 @RequestMapping(value = "/getOtp/mobile/{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
 public Otp getOtpByMobile(@PathVariable String mobile) {
  return otpService.getOtp(mobile);
 }
 
 @RequestMapping(value = "/addOtp", method = RequestMethod.POST, headers = "Accept=application/json")
 public void addOtp(@RequestBody Otp otp) { 
  otpService.addOtp(otp);
  
 }
 
 @RequestMapping(value = "/updateOtp", method = RequestMethod.PUT, headers = "Accept=application/json")
 public void updateOtp(@RequestBody Otp otp) {
  otpService.updateOtp(otp);
 }
 
 @RequestMapping(value = "/deleteOtp/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
 public void deleteOtp(@PathVariable("id") int id) {
	 otpService.deleteOtp(id);  
 }
 
 @RequestMapping(value = "/validateOtp", method = RequestMethod.POST, headers = "Accept=application/json")
 public Boolean getOtpByMobile(@RequestBody Otp otp) {
  return otpService.validateOtp(otp);
 }
 
}
