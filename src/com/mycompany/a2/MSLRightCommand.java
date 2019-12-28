package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MSLRightCommand extends Command {
	
	
	private GameWorld gw;

	
	public MSLRightCommand(GameWorld gw) {
		super("MSL Right");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnMissileLauncherRight();
		System.out.println("MSL Right");
	}
	

}
