package com.mycompany.a2;

import java.util.Observable;
import java.util.Vector;

/**
 * 
 * GameWorld small description
 * MVC architecture: This class is the model that contains all data and state
 * Observer design pattern: This class is the observable. MapView, PointsView are the observers.
 * 
 * All GameWorld methods call setChanged() and notifyObservers()
 * Whenever a GameWorld method is called, all observers will run their update() method
 * 
 */

public class GameWorld extends Observable implements IGameWorld{
	
	// fields and state values
	private Vector<GameObject> store = new Vector<GameObject>(); // CHECK LATER TO REMOVE IT
	private GameObjectCollection gameCollection;
	private int score;
	private int lives;
	private int mCount;
	private int timeElapsed;
	private boolean soundOn;

	
	// player reference variable to store the only player
	private PlayerShip player;
	
	// sounds 
	private static final BGSound bgSound = new BGSound("background.mp3");
	private Sound fireSound;
	private Sound rotationSound;
	private Sound gameOverSound;
	
	// dimensions
	private int height;
	private int width;
	
	// initial setup
	public void init(int w, int h) {
		gameCollection = new GameObjectCollection();
		this.width = w;
		this.height = h;
		this.score = 0;
		this.lives = 3;
		this.mCount = getMissileCount();
		this.timeElapsed = 0;
		this.soundOn = true;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		bgSound.play();
		fireSound = new Sound("fire.wav");
		rotationSound = new Sound("rotation.wav");
		gameOverSound = new Sound("gameOver.wav");
	}
	
	
	public void addAsteroid() {
		Asteroids asteroid = new Asteroids(this.width, this.height);
		gameCollection.add(asteroid);
		System.out.println("A new ASTEROID has been created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip(this.width, this.height);
		gameCollection.add(nps);
		System.out.println("A new NON-PLAYER SHIP has been created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void addStation() {
		SpaceStation station = new SpaceStation(this.width, this.height);
		gameCollection.add(station);
		System.out.println("A new SPACE STATION has been created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void addPlayerShip() {
		if (player == null) {
			this.player = new PlayerShip(this.width, this.height);
			gameCollection.add(player);
			gameCollection.add(player.getPlayerLauncher());
			System.out.println("A new PLAYER SHIP has been created");
		} else {
			System.out.println("PLAYER SHIP already exists");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void increaseSpeed() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.increaseSpeed();
			System.out.println("PLAYER SHIP speed increased by 3");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void decreaseSpeed() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.decreaseSpeed();
			System.out.println("PLAYER SHIP speed decreased by 3");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void turnPSLeft(){
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnLeft();
			System.out.println("PLAYER SHIP turned left by 45");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void turnPSRight(){
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnRight();
			System.out.println("PLAYER SHIP turned right by 45");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void turnMissileLauncherRight() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnLauncherRight();
			System.out.println("PLAYER SHIP MISSILE LAUNCHER turned right by 45");
			rotationSound.play();
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void turnMissileLauncherLeft() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.turnLauncherLeft();
			System.out.println("PLAYER SHIP MISSILE LAUNCHER turned right by 45");
			rotationSound.play();
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
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
				Missiles missile = new Missiles(plauncher.getLocation(), plauncher.getHeading(), plauncher.getSpeed(), this.width, this.height);
				gameCollection.add(missile);
				missilesLeft--;
				player.setMissileCount(missilesLeft);
				System.out.println("MISSILE fired from PLAYER SHIP. Missiles remaining: " + missilesLeft);
				fireSound.play();
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void fireNPSMissile() {
		IIterator theElements = gameCollection.getIterator();
		boolean npsOrNot = false;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			if (gameObject instanceof NonPlayerShip && npsOrNot == false) {
				MissileLauncher nLauncher = ((NonPlayerShip) gameObject).getnLauncher();
				Missiles missile = new Missiles(nLauncher.getLocation(), nLauncher.getHeading(), nLauncher.getSpeed(), this.width, this.height);
				gameCollection.add(missile);
				System.out.println("MISSILE fired from NON-PLAYER SHIP");
				npsOrNot = true;
			}
		}
		if (npsOrNot == false) {
			System.out.println("NON-PLAYER SHIP does not exist");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void jump() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.setLocation(512.0, 384.0);
			System.out.println("PLAYER SHIP jumped through hyperspace");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void newSupplies() {
		if (player == null) {
			System.out.println("PLAYER SHIP does not exist");
		} else {
			this.player.setMissileCount(10);
			System.out.println("PLAYER SHIP supplies loaded to maximum 10");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void psKillAsteroid() {
		IIterator theElements = gameCollection.getIterator();
		Boolean asteroidOrNot = false;
		Boolean missileOrNot = false;
		Asteroids ast = null;
		Missiles mis = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
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
			gameCollection.remove(ast);
			gameCollection.remove(mis);
			score = score + 5;
			System.out.println("PLAYER SHIP MISSILE has destroyed an ASTEROID");
		} else {
			System.out.println("Error: Either PLAYER SHIP MISSILE or ASTEROID does not exist");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void psKillNPS() {
		IIterator theElements = gameCollection.getIterator();
		Boolean npsOrNot = false;
		Boolean missileOrNot = false;
		NonPlayerShip nps = null;
		Missiles mis = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
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
			gameCollection.remove(nps);
			gameCollection.remove(mis);
			score = score + 20;
			System.out.println("PLAYER SHIP MISSILE has destroyed a NON-PLAYER SHIP");
		} else {
			System.out.println("Error: Either PLAYER SHIP MISSILE or NON-PLAYER SHIP does not exist");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void npsKillPS() {
		IIterator theElements = gameCollection.getIterator();
		Boolean missileOrNot = false;
		Missiles mis = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			if (!missileOrNot && gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				missileOrNot = true;
			}
		}
		if (missileOrNot && player != null) {
			gameCollection.remove(mis);
			gameCollection.remove(player);
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
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void psCrashAsteroid() {
		IIterator theElements = gameCollection.getIterator();
		Boolean asteroidOrNot = false;
		Asteroids ast = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			if (!asteroidOrNot && gameObject instanceof Asteroids) {
				ast = (Asteroids) gameObject;
				asteroidOrNot = true;
			}
		}
		if (asteroidOrNot && player != null) {
			gameCollection.remove(ast);
			gameCollection.remove(player);
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
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void psCrashNPS() {
		IIterator theElements = gameCollection.getIterator();
		Boolean npsOrNot = false;
		NonPlayerShip nps = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			if (!npsOrNot && gameObject instanceof NonPlayerShip) {
				nps = (NonPlayerShip) gameObject;
				npsOrNot = true;
			}
		}
		if (npsOrNot && player != null) {
			gameCollection.remove(nps);
			gameCollection.remove(player);
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
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void asteroidsCollide() {
		IIterator theElements = gameCollection.getIterator();
		int asteroidsToDestroy = 2;
		Asteroids ast1 = null;
		Asteroids ast2 = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
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
			gameCollection.remove(ast1);
			gameCollection.remove(ast2);
			System.out.println("Two ASTEROIDS have collided!");
		} else {
			System.out.println("Error: There needs to be two ASTEROIDS");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void asteroidCrashNPS() {
		IIterator theElements = gameCollection.getIterator();
		Boolean asteroidOrNot = false;
		Boolean npsOrNot = false;
		Asteroids ast = null;
		NonPlayerShip nps = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
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
			gameCollection.remove(ast);
			gameCollection.remove(nps);
			System.out.println("An ASTEROID has impacted a NON-PLAYER SHIP");
		} else {
			System.out.println("Error: Either ASTEROID or NON-PLAYER SHIP does not exist");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// START HERE
		/*while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			System.out.println(gameObject.toString());
		}*/
	public void clockTicked() {
		IIterator theElements1 = gameCollection.getIterator();
		
		// move all movableObjects
		MovableObject movObject = null;
		while(theElements1.hasNext()) {
			GameObject gameObject = (GameObject) theElements1.getNext();
			if (gameObject instanceof MovableObject) {
				movObject = (MovableObject) gameObject;
				movObject.move();
			}
		}
		
		if (player != null) {
			PSMissileLauncher plauncher = player.getPlayerLauncher();
			plauncher.setLocation(player.getLocation());
		}
		
		updateMissiles();
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
		//System.out.println("Clock has ticked");
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void updateMissiles() {
		IIterator theElements = gameCollection.getIterator();
		Missiles mis = null;
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			if (gameObject instanceof Missiles) {
				mis = (Missiles) gameObject;
				int fuelLevel = mis.getFuelLevel();
				if (fuelLevel < 1) {
					gameCollection.remove(mis);
				} else {
					mis.setFuelLevel(fuelLevel - 1);
				}
			}
		}
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
		IIterator theElements = gameCollection.getIterator();
		System.out.println();
		System.out.println("CURRENT WORLD STATE");
		System.out.println();
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			System.out.println(gameObject.toString());
		}
		System.out.println();
		/*for(int i = 0; i < store.size(); i++) {
			GameObject gameObject = store.get(i);
			System.out.println(gameObject.toString());
		}
		System.out.println();*/
	}


	
	// getters for the views to access attributes
	public int getScore() {
		return score;
	}


	public int getLives() {
		return lives;
	}


	public int getTimeElapsed() {
		return timeElapsed;
	}


	public boolean getSound() {
		return soundOn;
	}
	

	public int getMissileCount() {
		if (player == null) {
			return 0;
		} else {
			return player.getMissileCount();
		}
	}


	public IIterator getGwIterator() {
		return gameCollection.getIterator();
	}
	
	
}
