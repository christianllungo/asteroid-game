package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSMissileHitsAsteroidCommand extends Command {
	
	
	private GameWorld gw;

	
	public PSMissileHitsAsteroidCommand(GameWorld gw) {
		super("PS Missile (Asteroid)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.psKillAsteroid();
		System.out.println("PS missile hits an asteroid");
	}
	

}
