package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 * 
 * PointsView
 * Works as a view and observer.
 * This class is responsible for displaying the state values about the game
 * It displays: points, lives, missiles, sound, time
 * 
 * Contains two labels for each data: TextLabel(a string description), and ValueLabel(actual data)
 * 
 * This class will get notified through the update() method whenever GameWorld changes any state
 * It will catch the new data from GameWorld and update the ValueLabels for a new display
 *
 */

public class PointsView extends Container implements Observer {

	GameWorld gw;
	
	// ValueLabel field to hold data
	private Label pointsValueLabel;
	private Label livesValueLabel;
	private Label missilesValueLabel;
	private Label soundValueLabel;
	private Label timeValueLabel;
	
	
	public PointsView(GameWorld gw) {
		
		this.gw = gw;
		
		// create container for horizontal display
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		
		// create TextLabels
		Label pointsTextLabel = new Label("Points:");
		Label livesTextLabel = new Label("Lives:");
		Label missilesTextLabel = new Label("Missiles:");
		Label soundTextLabel = new Label("Sound:");
		Label timeTextLabel = new Label("Time Elapsed:");
		
		// create ValueLabels
		pointsValueLabel = new Label("00");
		livesValueLabel = new Label("00");
		missilesValueLabel = new Label("00");
		soundValueLabel = new Label("00");
		timeValueLabel = new Label("00");
		
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255)); // color: blue
		
		
		// add all labels to container in order
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		myContainer.add(livesTextLabel);
		myContainer.add(livesValueLabel);
		myContainer.add(missilesTextLabel);
		myContainer.add(missilesValueLabel);
		myContainer.add(soundTextLabel);
		myContainer.add(soundValueLabel);
		myContainer.add(timeTextLabel);
		myContainer.add(timeValueLabel);
		
		
		// add the container to this class(also a container)
		this.add(myContainer);
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
		IGameWorld gw = (IGameWorld) data;
		
		this.pointsValueLabel.setText("" + gw.getScore());
		this.livesValueLabel.setText("" + gw.getLives());
		this.soundValueLabel.setText("" + gw.isSoundOn());
		this.timeValueLabel.setText("" + gw.getTimeElapsed());
		
		this.repaint();
	}

	
	
}
