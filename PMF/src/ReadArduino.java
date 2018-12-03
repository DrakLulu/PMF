import java.util.Scanner;

import arduino.Arduino;

public class readArduino implements Runnable {
	Arduino frigo = new Arduino();

	public readArduino() {
	}

	@Override
	public void run() {
		int i = 0;
		String a;
		frigo.setPortDescription("/dev/cu.usbmodem14101");
		frigo.openConnection();
		System.out.println("connecte");

		while (i == 0) {
			frigo.serialRead(0);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		frigo.closeConnection();
	}

}