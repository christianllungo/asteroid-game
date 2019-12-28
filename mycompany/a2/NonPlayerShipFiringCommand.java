package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NonPlayerShipFiringCommand extends Command {
	
	
	private GameWorld gw;

	
	public NonPlayerShipFiringCommand(GameWorld gw) {
		super("NPS Fire");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.fireNPSMissile();
		System.out.println("NPS Fire");
	}
	

}
