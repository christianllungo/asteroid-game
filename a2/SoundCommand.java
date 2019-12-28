package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	
	
	private GameWorld gw;

	
	public SoundCommand(GameWorld gw) {
		super("Sound");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.sound();
		System.out.println("Sound");
	}
	

}
