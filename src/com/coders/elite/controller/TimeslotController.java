package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Timeslot;
import com.coders.elite.service.TimeslotService;

@RestController
public class TimeslotController {
	
@Autowired
TimeslotService timeslotService;
	
	@RequestMapping(value = "/getTimeslots", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getTimeslots(){
		return timeslotService.getTimeslots();
	}
	
	 @RequestMapping(value = "/addTimeslot", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addTimeslot(@RequestBody Timeslot timeslot) { 
	  timeslotService.addTimeslot(timeslot);
	 }
}
