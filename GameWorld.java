package com.mycompany.a2;

import java.util.Observable;
import java.util.Vector;

/**
 * 
 * GameWorld small description
 * MVC architecture: This class is the model that contains all data and state
 * Observer design pattern: This class is the observable. MapView, PointsView are the observers.
 * 
 */

public class GameWorld extends Observable{
	
	// fields and state values
	private Vector<GameObject> store = new Vector<GameObject>();
	private int score;
	private int lives;
	private int timeElapsed;
	private boolean soundOn;
	
	// player reference variable to store the only player
	private PlayerShip player;
	
	// initial setup
	public void init() {
		this.score = 0;
		this.lives = 3;
		this.timeElapsed = 0;
	}
	
	
	public void addAsteroid() {
		Asteroids asteroid = new Asteroids();
		store.add(asteroid);
		System.out.println("A new ASTEROID has been created");
	}
	
	
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip();
		store.add(nps);
		System.out.println("A new NON-PLAYER SHIP has been created");
	}
	
	
	public void addStation() {
		SpaceStation station = new SpaceStation();
		store.add(station);
		System.out.println("A new SPACE STATION has been created");
	}
	
	
	public void addPlayerShip() {
		if (player == null) {
			this.player = new PlayerShip();
			store.add(player);
			System.out.println("A new PLAYER SHIP has been created");
		} else {
			System.out.println("PLAYER SHIP already exists");
		}
	}
	
	
	public void increaseSpeed() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.increaseSpeed();
			System.out.println("PLAYER SHIP speed increased by 3");
		}
	}
	
	
	public void decreaseSpeed() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.decreaseSpeed();
			System.out.println("PLAYER SHIP speed decreased by 3");
		}
	}
	
	
	public void turnPSLeft(){
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnLeft();
			System.out.println("PLAYER SHIP turned left by 45");
		}
	}
	
	
	public void turnPSRight(){
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnRight();
			System.out.println("PLAYER SHIP turned right by 45");
		}
	}
	
	
	public void turnMissileLauncher() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnLauncherRight();
			System.out.println("PLAYER SHIP MISSILE LAUNCHER turned right by 45");
		}
	}
	
	
	public void firePSMissile() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			int missilesLeft = this.player.getMissileCount();
			if (missilesLeft == 0) {
				System.out.println("Error Message: No more missiles.");
			} else {
				PSMissileLauncher plauncher = this.player.getPlayerLauncher();
				Missiles missile = new Missiles(plauncher.getLocation(), plauncher.getHeading(), plauncher.getSpeed());
				store.add(missile);
				missilesLeft--;
				player.setMissileCount(missilesLeft);
				System.out.println("MISSILE fired from PLAYER SHIP. Missiles remaining: " + missilesLeft);
			}
		}
	}
	
	
	public void fireNPSMissile() {
		boolean npsOrNot = false;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (gameObject instanceof NonPlayerShip && npsOrNot == false) {
				MissileLauncher nLauncher = ((NonPlayerShip) gameObject).getnLauncher();
				Missiles missile = new Missiles(nLauncher.getLocation(), nLauncher.getHeading(), nLauncher.getSpeed());
				store.add(missile);
				System.out.println("MISSILE fired from NON-PLAYER SHIP");
				npsOrNot = true;
			}
		}
		if (npsOrNot == false) {
			System.out.println("NON-PLAYER SHIP does not exist");
		}
	}
	
	
	public void jump() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.setLocation(512.0, 384.0);
			System.out.println("PLAYER SHIP jumped through hyperspace");
		}
	}
	
	
	public void newSupplies() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.setMissileCount(10);
			System.out.println("PLAYER SHIP supplies loaded to maximum 10");
		}
	}
	
	
	public void psKillAsteroid() {
		Boolean asteroidOrNot = false;
		Boolean missileOrNot = false;
		Asteroids ast = null;
		Missiles mis = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!asteroidOrNot && gameObject instanceof Asteroids) {
				ast = (Asteroids) gameObject;
				asteroidOrNot = true;
			}
			if (!missileOrNot && gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				missileOrNot = true;
			}
		}
		if (asteroidOrNot && missileOrNot) {
			store.remove(ast);
			store.remove(mis);
			score = score + 5;
			System.out.println("PLAYER SHIP MISSILE has destroyed an ASTEROID");
		} else {
			System.out.println("Error: Either PLAYER SHIP MISSILE or ASTEROID does not exist");
		}
	}
	
	
	public void psKillNPS() {
		Boolean npsOrNot = false;
		Boolean missileOrNot = false;
		NonPlayerShip nps = null;
		Missiles mis = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!npsOrNot && gameObject instanceof NonPlayerShip) {
				nps = (NonPlayerShip) gameObject;
				npsOrNot = true;
			}
			if (!missileOrNot && gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				missileOrNot = true;
			}
		}
		if (npsOrNot && missileOrNot) {
			store.remove(nps);
			store.remove(mis);
			score = score + 20;
			System.out.println("PLAYER SHIP MISSILE has destroyed a NON-PLAYER SHIP");
		} else {
			System.out.println("Error: Either PLAYER SHIP MISSILE or NON-PLAYER SHIP does not exist");
		}
	}
	
	
	public void npsKillPS() {
		Boolean missileOrNot = false;
		Missiles mis = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!missileOrNot && gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				missileOrNot = true;
			}
		}
		if (missileOrNot && player != null) {
			store.remove(mis);
			store.remove(player);
			player = null;
			lives--;
			if (lives == 0) {
				System.out.println("Game Over!");
				this.quit();
			}
			System.out.println("PLAYER SHIP has been destroyed by a NON-PLAYER SHIP MISSILE. Lives: " + lives);
		} else {
			System.out.println("Error: Either PLAYER SHIP or NON-PLAYER SHIP MISSILE does not exist");
		}
	}
	
	
	public void psCrashAsteroid() {
		Boolean asteroidOrNot = false;
		Asteroids ast = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!asteroidOrNot && gameObject instanceof Asteroids) {
				ast = (Asteroids) gameObject;
				asteroidOrNot = true;
			}
		}
		if (asteroidOrNot && player != null) {
			store.remove(ast);
			store.remove(player);
			player = null;
			lives--;
			if (lives == 0) {
				System.out.println("Game Over!");
				this.quit();
			}
			System.out.println("PLAYER SHIP has crashed an ASTEROID. Lives: " + lives);
		} else {
			System.out.println("Error: Either PLAYER SHIP or ASTEROID does not exist");
		}
	}
	
	
	public void psCrashNPS() {
		Boolean npsOrNot = false;
		NonPlayerShip nps = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!npsOrNot && gameObject instanceof NonPlayerShip) {
				nps = (NonPlayerShip) gameObject;
				npsOrNot = true;
			}
		}
		if (npsOrNot && player != null) {
			store.remove(nps);
			store.remove(player);
			player = null;
			lives--;
			if (lives == 0) {
				System.out.println("Game Over!");
				this.quit();
			}
			System.out.println("PLAYER SHIP has hit a NON-PLAYER SHIP. Lives: " + lives);
		} else {
			System.out.println("Error: Either PLAYER SHIP or NON-PLAYER SHIP does not exist");
		}
	}
	
	
	public void asteroidsCollide() {
		int asteroidsToDestroy = 2;
		Asteroids ast1 = null;
		Asteroids ast2 = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (asteroidsToDestroy != 0 && gameObject instanceof Asteroids) {
				if (ast1 == null) {
					ast1 = (Asteroids) gameObject;
					asteroidsToDestroy--;
				} else {
					ast2 = (Asteroids) gameObject;
					asteroidsToDestroy--;
				}
			}
		}
		if (ast1 != null && ast2 != null) {
			store.remove(ast1);
			store.remove(ast2);
			System.out.println("Two ASTEROIDS have collided!");
		} else {
			System.out.println("Error: There needs to be two ASTEROIDS");
		}
	}
	
	
	public void asteroidCrashNPS() {
		Boolean asteroidOrNot = false;
		Boolean npsOrNot = false;
		Asteroids ast = null;
		NonPlayerShip nps = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (!asteroidOrNot && gameObject instanceof Asteroids) {
				ast = (Asteroids) gameObject;
				asteroidOrNot = true;
			}
			if (!npsOrNot && gameObject instanceof NonPlayerShip) {
				nps = (NonPlayerShip) gameObject;
				npsOrNot = true;
			}
		}
		if (asteroidOrNot && npsOrNot) {
			store.remove(ast);
			store.remove(nps);
			System.out.println("An ASTEROID has impacted a NON-PLAYER SHIP");
		} else {
			System.out.println("Error: Either ASTEROID or NON-PLAYER SHIP does not exist");
		}
	}
	
	
	public void clockTicked() {
		// move all movableObjects
		MovableObject movObject = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (gameObject instanceof MovableObject) {
				movObject = (MovableObject) gameObject;
				movObject.move();
			}
		}
		// update missiles
		Missiles mis = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				mis.setFuelLevel(mis.getFuelLevel() - 1);
				if (mis.getFuelLevel() == 0) {
					store.remove(mis);
				}
			}
		}
		// update spaceStation
		/*SpaceStation station = null;
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			if (gameObject instanceof SpaceStation) {
				station = (SpaceStation) gameObject;
				movObject.move();
			}
		}*/
		// update timeElapsed
		timeElapsed++;
		System.out.println("Clock has ticked");
	}
	
	
	public void printDisplay() {
		System.out.println();
		System.out.println("CURRENT STATE VALUES");
		System.out.println();
		System.out.println("Current Score: " + this.score);
		if (player == null) {
			System.out.println("Missiles Remaining: 0");
		} else {
			System.out.println("Missiles Remaining: " + this.player.getMissileCount());
		}
		System.out.println("Current Elapsed Time: " + this.timeElapsed);
		System.out.println("Number of lives " + this.lives);
		System.out.println();
	}
	
	
	public void quit() {
		System.exit(0);
	}
	
	
	public void printMap() {
		System.out.println();
		System.out.println("CURRENT WORLD STATE");
		System.out.println();
		for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			System.out.println(gameObject.toString());
		}
		System.out.println();
	}
	

	
	
}
