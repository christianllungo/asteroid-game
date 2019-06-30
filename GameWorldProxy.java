package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld{
	
	
	private GameWorld gw;
	
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return gw.getScore();
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return gw.getLives();
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return gw.getMissileCount();
	}

	@Override
	public int getTimeElapsed() {
		// TODO Auto-generated method stub
		return gw.getTimeElapsed();
	}

	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return gw.getSound();
	}

	@Override
	public void printMap() {
		// TODO Auto-generated method stub
		gw.printMap();
	}

	
	
}
