package com.coders.elite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Timeslot;
import com.coders.elite.dao.TimeslotDAO;

@Service
public class TimeslotServiceImpl implements TimeslotService {

	@Autowired
	TimeslotDAO timeslotDao;
	
	
	@Override
	public List<String> getTimeslots() {
		return timeslotDao.getTimeslots();
	}

	@Override
	public void addTimeslot(Timeslot timeslot) {
		timeslotDao.addTimeslot(timeslot);
		
	}

	@Override
	public void updateTimeslot(Timeslot timeslot) {
		timeslotDao.updateTimeslot(timeslot);
		
	}

	@Override
	public void deleteTimeslot(int id) {
		timeslotDao.deleteTimeslot(id);
		
	}
	

}
