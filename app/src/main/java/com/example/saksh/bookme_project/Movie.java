package com.example.saksh.bookme_project;
public class Movie {
	
	// default constructor
	public Movie() {}
	
	// overloaded constructor
	public Movie(String title) { this.title = title; }
	public Movie(String title, double rating) {
		this.title = title;
		this.rating = rating;
	}
	
	// access & modifier methods
	public String getTitle() { return title; }
	
	public double getRating() { return rating; }
	
	public void setTitle(String title) { this.title = title; }
	
	public void setRating(double rating) { this.rating = rating; }
	
	// helper functions
	public String toString() {
		return "Title: " + title + "\nRating: " + rating + " out of 5";
	}
	
	// private members
	private String title;
	private double rating;	// use a float
	
}
