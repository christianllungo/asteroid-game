package com.mycompany.a2;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable {

	
	private Media media;
	
	
	public BGSound(String fileName){
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
			media = MediaManager.createMedia(is, "audio/mp3", this);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void play() {
		media.play();
	}
	
	
	public void pause() {
		media.pause();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		media.setTime(0);
		media.play();
	}
	
	
}
