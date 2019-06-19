package com.mycompany.a2;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class Game extends Form{
	
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;

	
	public Game() {
		
		// set the main layout as BorderLayout
		setLayout(new BorderLayout());
		
		// create the buttons container
		Container buttonsContainer = new Container();
		buttonsContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		buttonsContainer.add(new Label("Buttons!"));
		
		// create the GameWorld
		gw = new GameWorld();
		gw.init();
		
		// create the views
		mv = new MapView();
		pv = new PointsView(gw);
		
		// connect the observers(views) with the GameWorld
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		// add the views to the main layout
		add(BorderLayout.NORTH,pv);
		add(BorderLayout.CENTER,mv);
		add(BorderLayout.WEST, buttonsContainer);
		
		// show it on the screen
		this.show();
		
		//play();
	}
	
	
	/*
	public void play() {
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch(sCommand.charAt(0)) {
					case 'a':
						gw.addAsteroid();
						break;
					case 'y':
						gw.addNPS();
						break;
					case 'b':
						gw.addStation();
						break;
					case 's':
						gw.addPlayerShip();
						break;
					case 'i':
						gw.increaseSpeed();
						break;
					case 'd':
						gw.decreaseSpeed();
						break;
					case 'l':
						gw.turnPSLeft();
						break;
					case 'r':
						gw.turnPSRight();
						break;
					case '>':
						gw.turnMissileLauncher();
						break;
					case 'f':
						gw.firePSMissile();
						break;
					case 'L':
						gw.fireNPSMissile();
						break;
					case 'j':
						gw.jump();
						break;
					case 'n':
						gw.newSupplies();
						break;
					case 'k':
						gw.psKillAsteroid();
						break;
					case 'e':
						gw.psKillNPS();
						break;
					case 'E':
						gw.npsKillPS();
						break;
					case 'c':
						gw.psCrashAsteroid();
						break;
					case 'h':
						gw.psCrashNPS();
						break;
					case 'x':
						gw.asteroidsCollide();
						break;
					case 'I':
						gw.asteroidCrashNPS();
						break;
					case 't':
						gw.clockTicked();
						break;
					case 'p':
						gw.printDisplay();
						break;
					case 'q':
						gw.quit();
					    break;
					case 'm':
						gw.printMap();
						break;
					default:
						System.out.println("Invalid input. Try again.");
				} // switch
			} // actionPerformed
		} // new ActionListener()
		); // addActionListener
	} // play()
	*/
	
	
}
