package com.example.saksh.bookme_project;

public class Seat {
	
	// default constructor
	public Seat() {
		isFilled = false;
	}
	
	// overloaded constructor
	public Seat(int row, int column) {		
		this.row = row;
		this.column = column;
		isFilled = false;
	}
	
	// access & modifier methods
	public int getRow() { return row; }
	
	public int getColumn() { return column; }
	
	public boolean isFilled() { return isFilled; }
	
	public void setRow(int row) { this.row = row; }
	
	public void setColumn(int column) { this.column = column; }
	
	public void makeFilled() { isFilled = true; }
	
	public void makeVacant() { isFilled = false; }
	
	// helper methods
	public String toString() {
		return "row: " + row + " column: " + column;
	}
	
	// private members
	private int row, column;
	private boolean isFilled;

}
