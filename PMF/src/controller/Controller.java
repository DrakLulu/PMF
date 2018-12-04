package controller;

import model.readArduino;
import view.Window;

public class Controller {
	
	Window win = new Window();
	readArduino AA = new readArduino(this);

	public Controller() throws InterruptedException {
	    
		Thread read = new Thread(new readArduino(this));
		read.start();

	}



	public void update(String tempInt, String tempExt, String humi, String onOff) {
		
		win.pan.setTemperaturext(tempExt);
		win.pan.setTemperature(tempInt);
		win.pan.setHumidite(humi);
		if(onOff == "1") {
		win.pan.setAllume(1);
		}else win.pan.setAllume(0);
		
		win.pan.repaint();
		
	}



	
	
}
