package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Timeslot;

public interface TimeslotDAO {

	public List<String> getTimeslots();
	
	public void addTimeslot(Timeslot timeslot);
	
	public void updateTimeslot(Timeslot timeslot);
	
	public void deleteTimeslot(int id);
	}
