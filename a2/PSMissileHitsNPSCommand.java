package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSMissileHitsNPSCommand extends Command {
	
	
	private GameWorld gw;

	
	public PSMissileHitsNPSCommand(GameWorld gw) {
		super("PS Missile (NPS)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.psKillNPS();
		System.out.println("PS missile hits an NPS");
	}
	

}
