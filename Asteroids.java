package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroids extends MovableObject implements IDrawable {

	private int size;
	
	
	public Asteroids(int width, int height) {
		super(width,height);
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
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillArc((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(), getSize(), getSize(), 0, 360);
	}
	
	
	@Override
	public String toString() {
		return "Asteroid: " + super.toString() + " size=" + size;
	}
	
	
}
