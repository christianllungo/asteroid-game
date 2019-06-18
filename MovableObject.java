package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public abstract class MovableObject extends GameObject implements IMovable {
	
	private int speed; // 0-15
	private int heading; // 0-359


	/* constructor */
	public MovableObject() {
		
	}
	
	
	/* setters and getters */
	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getHeading() {
		return heading;
	}


	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	
	
	public void setHeadingRandom() {
		this.heading = r.nextInt(360);
	}

	
	public void setSpeedRandom() {
		this.speed = r.nextInt(16);
	}
	

	@Override
	public void move() {
		double angle = 90.0 - this.heading;
		double deltaX = Math.cos(angle) * this.speed;
		double deltaY = Math.sin(angle) * this.speed;
		Point2D oldLocation = super.getLocation();
		double oldX = oldLocation.getX();
		double oldY = oldLocation.getY();
		double newX = Math.round((oldX + deltaX) * 10.0) / 10.0;
		double newY = Math.round((oldY + deltaY) * 10.0) / 10.0;
		super.setLocation(newX, newY);
	}


	@Override
	public String toString() {
		return super.toString() + " speed=" + speed + " dir=" + heading;
	}
	
	
	
	
}
