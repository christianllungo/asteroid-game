package com.mycompany.a2;

public class SpaceStation extends FixedObject {

	private int blinkRate;
	
	
	public SpaceStation(int width, int height) {
		super(width,height);
		setLocationRandom();
		setColor(128, 0, 0); // color: maroon
		setId();
		setBlinkRateRandom();
	}

	
	/* setters and getters */
	public int getBlinkRate() {
		return blinkRate;
	}
	
	
	public void setBlinkRate(int blinkRate) {
		this.blinkRate = blinkRate;
	}
	
	
	public void setBlinkRateRandom() {
		this.blinkRate = r.nextInt(5);
	}


	@Override
	public String toString() {
		return "Station: " + super.toString() + " rate=" + blinkRate;
	}
	
	
}
