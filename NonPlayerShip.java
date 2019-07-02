package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class NonPlayerShip extends Ships implements IDrawable {

	private int size;
	private MissileLauncher nLauncher;
	
	
	public NonPlayerShip(int width, int height) {
		super(width, height);
		setLocationRandom();
		setColor(0, 0, 128); // color: navy
		setHeadingRandom();
		setSpeedRandom();
		size = setSizeRandom();
		nLauncher = new MissileLauncher(super.getLocation(), super.getHeading(), super.getSpeed(), width, height);
	}
	
		
	public MissileLauncher getnLauncher() {
		return nLauncher;
	}


	public int setSizeRandom() {
		int var = r.nextInt(2);
		if (var == 0) {
			return 25;
		} else {
			return 40;
		}
	}

	

	public int getSize() {
		return size;
	}


	@Override
	public String toString() {
		return "Non-Player Ship: " + super.toString() + " size=" + size;
	}


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillTriangle((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY()+getSize(), 
				(int)pCmpRelPrnt.getX()+(int)this.getX()-getSize(), (int)pCmpRelPrnt.getY()+(int)this.getY()-getSize(),
				(int)pCmpRelPrnt.getX()+(int)this.getX()+getSize(), (int)pCmpRelPrnt.getY()+(int)this.getY()-getSize()
				);
	}
	
	
}
