package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsteroidHitsNPSCommand extends Command {
	
	
	private GameWorld gw;

	
	public AsteroidHitsNPSCommand(GameWorld gw) {
		super("Asteroid (NPS)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.asteroidCrashNPS();
		System.out.println("Asteroid hits an NPS");
	}
	

}
