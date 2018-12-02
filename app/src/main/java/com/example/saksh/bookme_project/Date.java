package com.example.saksh.bookme_project;

public class Date {
	
	// default constructor
	public Date() {}
	
	public Date(String month, String day) {
		this.month = month;
	}
	
	// access & modifier methods
	public String getMonth() { return month; }
	
	public String getDay() { return day; }
	
	public void setMonth(String month) { this.month = month; }
	
	public void setDat(String day) { this.day = day; }
	
	// private members
	private String month;	// 1 through 12
	private String day;		// 1 through 31
}
