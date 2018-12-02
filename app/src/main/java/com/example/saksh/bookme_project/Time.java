package com.example.saksh.bookme_project;

public class Time {
	
	// default constructor
	public Time() {} 
	
	// overloaded constructor
	public Time(int hour, int minute) {		
		this.hour = hour;		
		this.minute = minute;
	}
	
	// access & modifier methods
	public int getHour() { return hour; }
	
	public int getMinute() { return minute; }
	
	public String getMeridiem() { return meridiem; }
	
	public void setHour(int hour) { this.hour = hour; }
	
	public void setMinute(int minute) { this.minute = minute; }
	
	public void setMeridiem(String meridiem) { this.meridiem = meridiem; }
	
	// helper methods
	public String toString() {
		return hour + ":" + minute;	// eg. "7:00"
	}
	
	// private members
	private int hour, minute;
	private String meridiem;
}
