package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;

public class PointsView extends Container implements Observer {

	GameWorld gw;
	
	public PointsView(GameWorld gw) {
		this.gw = gw;
		
		add(new Label("PointsView"));
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

	
	
}
