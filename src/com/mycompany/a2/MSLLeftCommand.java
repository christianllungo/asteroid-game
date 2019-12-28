package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MSLLeftCommand extends Command {
	
	
	private GameWorld gw;

	
	public MSLLeftCommand(GameWorld gw) {
		super("MSL Left");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnMissileLauncherLeft();
		System.out.println("MSL Left");
	}
	

}
