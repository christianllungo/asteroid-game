package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;

/**
 * 
 * Game
 * This class is the controller and the main class. The game starts here.
 * It creates the views(MapView, PointsView) and the model(GameWorld) and connects them together by addObserver() method
 * 
 * The main layout (BorderLayout) consists of 3 areas:
 * NORTH: PointsView(Container) + ToolBar(Container)
 * WEST: A Container for displaying buttons on the left side
 * CENTER: MapView(Container)
 * 
 * It creates all command objects and the invokers(buttons) which have a setCommand() method
 * All commands are connected to their respective buttons which will trigger when pressed and call actionPerformed() on command objects
 *
 */

public class Game extends Form implements Runnable{ // ask professor about sysout on command objects, bug space bar, missile luncher now can do both < >, ps turn right has bugs
	
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private UITimer timer;

	private Toolbar menu;
	
	
	public Game() {
		
		// set the main layout as BorderLayout
		setLayout(new BorderLayout());

		sideMenu();
		
		// create the model(GameWorld)
		gw = new GameWorld();
		gw.init();
		
		
		// create the views(MapView, PointsView)
		mv = new MapView();
		pv = new PointsView(gw);
		
		
		// connect the observers(views) with the GameWorld
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		
		// create the container for displaying buttons on the left side
		Container buttonsContainer = new Container();
		buttonsContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		buttonsContainer.add(new Label("Commands"));
		
		
		// create all commands
		AddAsteroidCommand myAddAsteroidCommand = new AddAsteroidCommand(gw);
		AddNonPlayerShipCommand myAddNPSCommand = new AddNonPlayerShipCommand(gw);
		AddSpaceStationCommand myAddSpaceStationCommand = new AddSpaceStationCommand(gw);
		AddPlayerShipCommand myAddPSCommand = new AddPlayerShipCommand(gw);
		PlayerShipFiringCommand myPSFireCommand = new PlayerShipFiringCommand(gw);
		JumpCommand myJumpCommand = new JumpCommand(gw);
		IncreaseSpeedCommand myIncreaseSpeedCommand = new IncreaseSpeedCommand(gw);
		DecreaseSpeedCommand myDecreaseSpeedCommand = new DecreaseSpeedCommand(gw);
		TurnPSLeftCommand myTurnPSLeftCommand = new TurnPSLeftCommand(gw);
		TurnPSRightCommand myTurnPSRightCommand = new TurnPSRightCommand(gw);
		NonPlayerShipFiringCommand myNPSFireCommand = new NonPlayerShipFiringCommand(gw);
		LoadMissilesPSCommand myLoadMissilesCommand = new LoadMissilesPSCommand(gw);
		PSMissileHitsAsteroidCommand myPSMissileHitsAsteroidCommand = new PSMissileHitsAsteroidCommand(gw);
		PSMissileHitsNPSCommand myPSMissileHitsNPSCommand = new PSMissileHitsNPSCommand(gw);
		NPSMissileHitsPSCommand myNPSMissileHitsPSCommand = new NPSMissileHitsPSCommand(gw);
		PSHitsAsteroidCommand myPSHitsAsteroidCommand = new  PSHitsAsteroidCommand(gw);
		PSHitsNPSCommand myPSHitsNPSCommand = new PSHitsNPSCommand(gw);
		AsteroidHitsAsteroidCommand myAsteroidHitsAsteroidCommand = new AsteroidHitsAsteroidCommand(gw);
		AsteroidHitsNPSCommand myAsteroidHitsNPSCommand = new AsteroidHitsNPSCommand(gw);
		RunTickCommand myRunTickCommand = new RunTickCommand(gw);
		
		
		// create all buttons or invokers
		Button addAsteroidButton = new Button("TesterButton");
		Button addNPSButton = new Button("TesterButton");
		Button addSpaceStationButton = new Button("TesterButton");
		Button addPSButton = new Button("TesterButton");
		Button psFireButton = new Button("TesterButton");
		Button jumpButton = new Button("TesterButton");
		
		
		// register the commands to buttons
		addAsteroidButton.setCommand(myAddAsteroidCommand);
		addNPSButton.setCommand(myAddNPSCommand);
		addSpaceStationButton.setCommand(myAddSpaceStationCommand);
		addPSButton.setCommand(myAddPSCommand);
		psFireButton.setCommand(myPSFireCommand);
		jumpButton.setCommand(myJumpCommand);
		
		
		// register the commands to key listeners
		addKeyListener(-90, myPSFireCommand); // -90 space bar BUG HERE
		addKeyListener('j', myJumpCommand);
		addKeyListener(-91, myIncreaseSpeedCommand); // -91 up arrow
		addKeyListener('i', myIncreaseSpeedCommand);
		addKeyListener(-92, myDecreaseSpeedCommand); // -92 down arrow
		addKeyListener('d', myDecreaseSpeedCommand);
		addKeyListener(-93, myTurnPSLeftCommand); // -93 left arrow
		addKeyListener('l', myTurnPSLeftCommand);
		addKeyListener(-94, myTurnPSRightCommand); // -94 right arrow
		addKeyListener('r', myTurnPSRightCommand);
		addKeyListener('L', myNPSFireCommand);
		addKeyListener('n', myLoadMissilesCommand);
		addKeyListener('k', myPSMissileHitsAsteroidCommand);
		addKeyListener('e', myPSMissileHitsNPSCommand);
		addKeyListener('E', myNPSMissileHitsPSCommand);
		addKeyListener('c', myPSHitsAsteroidCommand);
		addKeyListener('h', myPSHitsNPSCommand);
		addKeyListener('x', myAsteroidHitsAsteroidCommand);
		addKeyListener('I', myAsteroidHitsNPSCommand);
		addKeyListener('t', myRunTickCommand);
		
		
		// add buttons to left container for displaying buttons
		buttonsContainer.add(addAsteroidButton);
		buttonsContainer.add(addNPSButton);
		buttonsContainer.add(addSpaceStationButton);
		buttonsContainer.add(addPSButton);
		buttonsContainer.add(psFireButton);
		buttonsContainer.add(jumpButton);
		
		
		// add the views to the main layout
		add(BorderLayout.NORTH,pv);
		add(BorderLayout.CENTER,mv);
		add(BorderLayout.WEST, buttonsContainer);
				
		
		// show the main layout on the screen
		this.show();
		
		//play();
		
		timer = new UITimer(this);
		timer.schedule(20, true, this);
	}
	
	private void sideMenu() {		
		menu = new Toolbar();
		this.setToolbar(menu);
		menu.setTitle("Asteroid Game");
		
		Command sideMenuItem1 = new Command("New");
		menu.addCommandToSideMenu(sideMenuItem1);
		
		Command sideMenuItem2 = new Command("Save");
		menu.addCommandToSideMenu(sideMenuItem2);
		
		Command sideMenuItem3 = new Command("Undo");
		menu.addCommandToSideMenu(sideMenuItem3);
		
		Command sideMenuItem4 = new Command("Sound");
		menu.addCommandToSideMenu(sideMenuItem4);
		
		Command sideMenuItem5 = new Command("About");
		menu.addCommandToSideMenu(sideMenuItem5);
		
		Command sideMenuItem6 = new Command("Quit");
		menu.addCommandToSideMenu(sideMenuItem6);
	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		gw.clockTicked();
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
