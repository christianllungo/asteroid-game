package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnPSRightCommand extends Command {
	
	
	private GameWorld gw;

	
	public TurnPSRightCommand(GameWorld gw) {
		super("PS Right");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnPSRight();
		System.out.println("Turn PS Right");
	}
	

}
