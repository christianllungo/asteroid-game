package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSHitsNPSCommand extends Command {
	
	
	private GameWorld gw;

	
	public PSHitsNPSCommand(GameWorld gw) {
		super("PS (NPS)");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.psCrashNPS();
		System.out.println("PS hits an NPS");
	}
	

}
