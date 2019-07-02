package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command {
	
	
	private GameWorld gw;

	
	public QuitCommand(GameWorld gw) {
		super("Quit");
		this.gw = gw;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.quit();
		System.out.println("Quit");
	}
	

}
