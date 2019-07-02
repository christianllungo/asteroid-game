package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class PSMissileLauncher extends MissileLauncher implements ISteerable, IDrawable {

	public PSMissileLauncher(Point2D location, int heading, int speed, int width, int height) {
		super(location, heading, speed, width, height);
		setColor(0, 0, 128); // color: navy
	}

	@Override
	public void turnRight() {
		super.setHeading(super.getHeading() + 45);
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		int dir = getHeading() + 315;
		if (dir >= 360) {
			dir = dir - 360;
			setHeading(dir);
		} else {
			setHeading(dir);
		}
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.drawLine((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(),
				(int)pCmpRelPrnt.getX()+(int)this.getX()+(int)(80 * Math.sin(Math.toRadians(getHeading()))), (int)pCmpRelPrnt.getY()+(int)this.getY()+(int)(80 * Math.cos(Math.toRadians(getHeading()))));
	}
	
	
	
}
