package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class PSMissileLauncher extends MissileLauncher implements ISteerable {

	public PSMissileLauncher(Point2D location, int heading, int speed) {
		super(location, heading, speed);
	}

	@Override
	public void turnRight() {
		super.setHeading(super.getHeading() + 45);
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
