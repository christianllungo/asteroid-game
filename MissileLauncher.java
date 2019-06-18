package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class MissileLauncher extends MovableObject {

	public MissileLauncher(Point2D location, int heading, int speed) {
		setLocation(location);
		setColor(0, 0, 128); // color: navy
		setHeading(heading);
		setSpeed(speed);
	}
	
}
