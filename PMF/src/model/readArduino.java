package model;

import controller.controller;
import view.Window;
import arduino.Arduino;

public class readArduino implements Runnable {
	Arduino frigo = new Arduino();
	private String tempInt, tempExt, humi, onOff;
	String vrac;
	private controller control; 

	public readArduino(controller cont) {
		
		this.control = cont; 
		
	}

	@Override
	public void run() {
		int i = 0;
		frigo.setPortDescription("/dev/cu.usbmodem14101");
		frigo.openConnection();

		while (i == 0) {

			vrac = frigo.serialRead(0);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Split();
			System.out.println(tempInt);
			System.out.println(humi);

		}

		frigo.closeConnection();
	}

	public void Split() {
		String[] values = vrac.split(";");
		int size = values.length;
		System.out.println(size);

		if (size != 4) {
			size = 0;
		} else {
			tempExt = values[2];
			tempInt = values[0];
			humi = values[1];
			onOff = values[3];
			
			
			control.run(tempExt, tempInt, humi, onOff); 
		}

	}
	
	public String getVrac() {
		return vrac;
	}

	public void setVrac(String vrac) {
		this.vrac = vrac;
	}

	public String getTempInt() {
		return tempInt;
	}

	public void setTempInt(String tempInt) {
		this.tempInt = tempInt;
	}

	public String getTempExt() {
		return tempExt;
	}

	public void setTempExt(String tempExt) {
		this.tempExt = tempExt;
	}

	public String getHumi() {
		return humi;
	}

	public void setHumi(String humi) {
		this.humi = humi;
	}

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}


}
