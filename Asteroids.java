package com.mycompany.a2;

public class Asteroids extends MovableObject {

	private int size;
	
	
	public Asteroids() {
		setLocationRandom();
		setColor(0, 0, 0); // color: black
		setHeadingRandom();
		setSpeedRandom();
		this.size =  r.nextInt(25) + 6; // sets the size as a random integer from 6 to 30
	}
	
	
	/* setters and getters */
	public int getSize() {
		return size;
	}


	@Override
	public String toString() {
		return "Asteroid: " + super.toString() + " size=" + size;
	}
	
	
}
