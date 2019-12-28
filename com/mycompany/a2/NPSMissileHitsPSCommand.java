package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NPSMissileHitsPSCommand extends Command {
	
	
	private GameWorld gw;

	
	public NPSMissileHitsPSCommand(GameWorld gw) {
		super("NPS Missile (PS)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.npsKillPS();
		System.out.println("NPS missiles hits PS");
	}
	

}
