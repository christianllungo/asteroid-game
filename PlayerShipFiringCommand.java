package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PlayerShipFiringCommand extends Command {
	
	
	private GameWorld gw;

	
	public PlayerShipFiringCommand(GameWorld gw) {
		super("PS Fire");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.firePSMissile();
		System.out.println("PS fire missile");
	}
	

}
