package controller;

import arduino.Arduino;
import model.readArduino;
import view.Panel;
import view.Window;

public class controller {
	Window win = new Window();
	readArduino AA = new readArduino(this);

	public controller() throws InterruptedException {

		Thread read = new Thread(new readArduino(this));
		read.start();

	}

	
	public void run(String tempExt, String tempInt, String humi, String onOff) {
		win.pan.setTemperaturext(tempExt);
		win.pan.setTemperature(tempInt);
		win.pan.setHumidite(humi);
		
	}

	
	
}
