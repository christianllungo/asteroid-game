package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class Missiles extends MovableObject implements IDrawable {

	private int fuelLevel;

	
	public Missiles(Point2D location, int heading, int speed, int width, int height) {
		super(width, height);
		setLocation(location);
		setColor(0, 0, 0); // color: black
		setHeading(heading);
		setSpeed(speed + 13);
		setFuelLevel(150);
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


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillArc((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(), 15, 15, 0, 360);
	}
	
	
}
