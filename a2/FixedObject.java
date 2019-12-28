package com.mycompany.a2;

public class FixedObject extends GameObject {
	
	private static int counter = 0;
	private int id;
	
	public FixedObject(int width, int height) {
		super(width,height);
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setId() {
		counter++;
		this.id = counter;
	}
	
	
	
}
