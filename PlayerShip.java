package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerShip extends Ships implements ISteerable, IDrawable {
	
	private int missileCount;
	private PSMissileLauncher playerLauncher;
	
	
	public PlayerShip(int width, int height) {
		super(width, height);
		setLocation(512.0, 384.0); // center of game
		setColor(128, 128, 128); // color: gray
		setHeading(0);
		setSpeed(0);
		setMissileCount(10);
		playerLauncher = new PSMissileLauncher(getLocation(), getHeading(), getSpeed(), width, height);
	}
	
	
	public PSMissileLauncher getPlayerLauncher() {
		return playerLauncher;
	}


	public int getMissileCount() {
		return missileCount;
	}

	
	public void setMissileCount(int missileCount) {
		this.missileCount = missileCount;
	}
	
	
	// increase speed by 3
	public void increaseSpeed() {
		super.setSpeed(super.getSpeed()+3);
	}
	
	
	// decrease speed by 3
	public void decreaseSpeed() {
		if (super.getSpeed() >= 3) {
			super.setSpeed(super.getSpeed()-3);
		}
	}
	
	
	public void turnLauncherRight() {
		playerLauncher.turnRight();
	}
	
	
	public void turnLauncherLeft() {
		playerLauncher.turnLeft();
	}
	
	
	@Override
	public void turnRight() {
		setHeading(getHeading() + 45);
	}

	
	@Override
	public void turnLeft() {
		int dir = getHeading() + 315;
		if (dir >= 360) {
			dir = dir - 360;
			setHeading(dir);
		} else {
			setHeading(dir);
		}
	}
	
	
	@Override
	public String toString() {
		return "Player Ship: " + super.toString() + " missiles=" + missileCount + " Missile launcher dir = " + playerLauncher.getHeading();
	}


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillArc((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(), 50, 50, 0, 360);
	}
	
	
	
}