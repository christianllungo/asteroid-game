package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	
	private Point2D location;
	private int color;
	protected Random r = new Random(); // Not an instance variable so it can be protected as access modifier
	
	
	/* constructor */
	public GameObject() {
		
	}
	
	
	/* getters and setters */
	public Point2D getLocation() {
		return location;
	}


	public void setLocation(double x, double y) {
		this.location = new Point2D(x, y);
	}
	
	
	public void setLocation(Point2D location) {
		this.location = location;
	}

	
	public int getColor() {
		return this.color;
	}
	
	
	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
	}


	public void setLocationRandom() {
		Point2D rLocation = new Point2D(0,0);
		double dX = r.nextFloat() * 1024;
		double dY = r.nextFloat() * 768;
		double rdX = Math.round(dX * 10.0) / 10.0;
		double rdY = Math.round(dY * 10.0) / 10.0;
		rLocation.setX(rdX);
		rLocation.setY(rdY);
		this.location = rLocation;
	}


	@Override
	public String toString() {
		return "loc=" + location.getX() + "," + location.getY() +" color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
	}
	
	
	
} // still got to add range for location 0-1024 and 0-768
