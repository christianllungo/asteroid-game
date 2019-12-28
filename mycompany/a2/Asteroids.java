package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroids extends MovableObject implements IDrawable {

	private int size;
	
	
	public Asteroids(int width, int height) {
		super(width,height);
		setLocationRandom(width, height);
		setColor(128, 128, 128); // color: grey
		setHeadingRandom();
		setSpeedRandom(0, 6);
		this.size =  r.nextInt(21) + 60; // sets the size as a random integer from 60 to 80
	}
	
	
	/* setters and getters */
	public int getSize() {
		return size;
	}


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillRect((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(), getSize(), getSize());
	}
	
	
	@Override
	public String toString() {
		return "Asteroid: " + super.toString() + " size=" + size;
	}
	
	
}
