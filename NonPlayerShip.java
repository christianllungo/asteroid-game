package com.mycompany.a2;

public class NonPlayerShip extends Ships {

	private int size;
	private MissileLauncher nLauncher;
	
	
	public NonPlayerShip(int width, int height) {
		super(width, height);
		setLocationRandom();
		setColor(192, 192, 192); // color: silver
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
			return 15;
		} else {
			return 25;
		}
	}


	@Override
	public String toString() {
		return "Non-Player Ship: " + super.toString() + " size=" + size;
	}
	
	
}
