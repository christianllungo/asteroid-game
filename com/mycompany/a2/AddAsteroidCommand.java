package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command {
	
	
	private GameWorld gw;

	
	public AddAsteroidCommand(GameWorld gw) {
		super("+ Asteroid");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addAsteroid();
		System.out.println("Add Asteroid");
	}
	

}
