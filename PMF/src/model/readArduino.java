package model;


import java.util.ArrayList;
import java.util.List;

import arduino.Arduino;

import controller.Controller;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class readArduino implements Runnable, Observable {
	Arduino frigo = new Arduino();
	private String tempInt, tempExt, humi, onOff, rosee;
	String vrac; 
	private Controller control;
	private int state;

	public readArduino(Controller controller) {
		this.control = controller; 
	}
	
	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		
	}


	@Override
	public void run() {
		int i = 0;
		frigo.setPortDescription("COM6");
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
			
			

		}

		frigo.closeConnection();
	}

	public void Split() {
		String[] values = vrac.split(",");
		int size = values.length;
		System.out.println(size);

		if (size != 4) {
			size = 0;
		} else {
			this.setTempExt(values[0]);
			this.setTempInt(values[1]);
			this.setHumi(values[2]);
			this.setOnOff(values[3]);
			System.out.println(values[0]);
			System.out.println(values[1]);
			System.out.println(values[2]);
			System.out.println(values[3]);
			
		 
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
		control.update(tempInt, tempExt, humi, onOff);
	}

	public String getTempExt() {
		return tempExt;
	}

	public void setTempExt(String tempExt) {
		this.tempExt = tempExt;
		control.update(tempInt, tempExt, humi, onOff);
	}

	public String getHumi() {
		return humi;
	}

	public void setHumi(String humi) {
		this.humi = humi;
		control.update(tempInt, tempExt, humi, onOff);
	}

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
		control.update(tempInt, tempExt, humi, onOff);
	}




	


}
