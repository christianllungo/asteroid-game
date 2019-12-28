package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LoadMissilesPSCommand extends Command {
	
	
	private GameWorld gw;

	
	public LoadMissilesPSCommand(GameWorld gw) {
		super("Load PS");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.newSupplies();
		System.out.println("Load PS missiles");
	}
	

}
