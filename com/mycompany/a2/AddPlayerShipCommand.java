package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddPlayerShipCommand extends Command {
	
	
	private GameWorld gw;

	
	public AddPlayerShipCommand(GameWorld gw) {
		super("+ PS (1)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addPlayerShip();
		System.out.println("Add Player Ship");
	}
	

}
