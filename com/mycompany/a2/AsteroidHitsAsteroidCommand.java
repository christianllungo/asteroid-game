package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsteroidHitsAsteroidCommand extends Command {
	
	
	private GameWorld gw;

	
	public AsteroidHitsAsteroidCommand(GameWorld gw) {
		super("Asteroid (Asteroid)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.asteroidsCollide();
		System.out.println("Asteroid hits asteroid");
	}
	

}
