package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Point;

public class MapView extends Container implements Observer {

	private IGameWorld gw;
	
	/*
	public void paint(Graphics g) {
		
		super.paint(g);
		//this.gw.printMap();
		/*IIterator theElements = gw.getGwIterator();
		
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			Point pCmpRelPrnt = new Point(this.getX(), this.getY());
			if (gameObject instanceof IDrawable) {
				((IDrawable) gameObject).draw(g, pCmpRelPrnt);
			}
		}*/
		
	public MapView(GameWorld gw) {
		this.gw = new GameWorldProxy(gw);
	}
	
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
		this.gw = (IGameWorld) data;
		//gw.printMap();
		this.repaint();
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		IIterator theElements = gw.getGwIterator();
		while(theElements.hasNext()) {
			GameObject gameObject = (GameObject) theElements.getNext();
			Point pCmpRelPrnt = new Point(this.getX(), this.getY());
			if (gameObject instanceof IDrawable) {
				((IDrawable) gameObject).draw(g, pCmpRelPrnt);
			}
		}
	}

	
}
