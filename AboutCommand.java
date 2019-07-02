package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
	
	
	private GameWorld gw;
	String description = "";

	
	public AboutCommand(GameWorld gw) {
		super("About");
		this.gw = gw;
		description = "Asteroid Game for CSC 133 by Christian Llungo and Seleny Guzman";
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		Dialog.show("About",description,"Done","Cancel");
	}
	

}
