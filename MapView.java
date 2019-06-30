package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;

public class MapView extends Container implements Observer {

	
	public MapView() {
		this.add(new Label("MapView"));
	}
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
		IGameWorld igw = (IGameWorld) data;
		igw.printMap();
		this.repaint();
	}

	
	
}
