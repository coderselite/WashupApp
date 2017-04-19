package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Timeslot;

public interface TimeslotService {


	public List<String> getTimeslots();
	
	public void addTimeslot(Timeslot timeslot);
	
	public void updateTimeslot(Timeslot timeslot);
	
	public void deleteTimeslot(int id);
}
