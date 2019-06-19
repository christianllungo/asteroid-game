package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddSpaceStationCommand extends Command {
	
	
	private GameWorld gw;

	
	public AddSpaceStationCommand(GameWorld gw) {
		super("+ Space Station");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addStation();
		System.out.println("Add Station");
	}
	

}
