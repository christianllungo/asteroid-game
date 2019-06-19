package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnPSLeftCommand extends Command {
	
	
	private GameWorld gw;

	
	public TurnPSLeftCommand(GameWorld gw) {
		super("PS Left");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnPSLeft();
		System.out.println("Turn PS Left");
	}
	

}
