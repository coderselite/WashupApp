package com.coders.elite.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.coders.elite.service.OtpService;
 
public class OtpCleanupTask { 

	@Autowired
	OtpService otpService;
	
	@Scheduled (fixedDelay=300000)
    public void execute()
    {
        otpService.deleteExpiredOtp();
        System.out.println("Cleanup done");
    }
}
