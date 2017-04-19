package com.coders.elite.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timeslot {

	@Id
	@Column
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int timeslot_id;
	
	@Column
	private String timeslot;

	public Timeslot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timeslot(String timeslot) {
		super();
		this.timeslot = timeslot;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}	
	
}
