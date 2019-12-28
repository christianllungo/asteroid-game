package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSHitsAsteroidCommand extends Command {
	
	
	private GameWorld gw;

	
	public PSHitsAsteroidCommand(GameWorld gw) {
		super("PS (Asteroid)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.psCrashAsteroid();
		System.out.println("PS hits an asteroid");
	}
	

}
