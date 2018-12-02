package com.example.saksh.bookme_project;

public class ShowTime {
	
	// default constructor
	public ShowTime() {}
	
	// overloaded constructor	
	public ShowTime(Movie movie, Date date, Time startTime) {
		this.movie = movie;
		this.date = date;
		this.startTime = startTime;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				seat[i][j] = new Seat(i, j);
				seat[i][j].setRow(i);
				seat[i][j].setColumn(j);
			}
		}
	}
	
	// access & modifier methods
	public Movie getMovie() { return movie; }
	
	public Date getDate() { return date; }
	
	public Time getTime() { return startTime; }
	
	public Seat getSeat(int row, int column) { return seat[row][column]; }
	
	public void setMovie(Movie movie) { this.movie = movie; }
	
	public void setDate(Date date) { this.date = date; }
	
	public void setStartTime(Time startTime) { this.startTime = startTime; }
	
	// helper functions
	public String toString() {
		String temp = movie.toString() + "\n" + startTime.toString() + "\n";
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				temp += "row: " + seat[i][j].getRow() + " column: " + seat[i][j].getColumn() + "\n";
			}
		}
		
		return temp; 
	}
	
	// private members
	private Movie movie;
	private Date date;
	private Time startTime;
	private Seat[][] seat = new Seat[10][10];
	
	
}
