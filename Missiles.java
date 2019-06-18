package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class Missiles extends MovableObject {

	private int fuelLevel;

	
	public Missiles(Point2D location, int heading, int speed) {
		setLocation(location);
		setColor(255, 0, 0); // color: red
		setHeading(heading);
		setSpeed(speed + 3);
		setFuelLevel(15);
	}
	
	
	public int getFuelLevel() {
		return fuelLevel;
	}

	
	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}


	@Override
	public String toString() {
		return "Missile: " + super.toString() + " fuel=" + fuelLevel;
	}

	
	
	
}
