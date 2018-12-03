import java.util.Scanner;

import arduino.Arduino;

public class ReadArduino {
	private int temp,humi,rose;
	public ReadArduino() {}

		public void read(Arduino frigo) {
			int i=0;
			frigo.setPortDescription("/dev/cu.usbmodem14101");
			frigo.openConnection();
			Scanner sc= new Scanner(System.in);
			
			    while (i<20) {
				System.out.println(frigo.serialRead());
				frigo.serialWrite(sc.nextLine());
			    i++;			
		}
			frigo.closeConnection();
		}
	

		public int getTemp() {
			return temp;
		}

		public void setTemp(int temp) {
			this.temp = temp;
		}

		public int getHumi() {
			return humi;
		}

		public void setHumi(int humi) {
			this.humi = humi;
		}

		public int getRose() {
			return rose;
		}

		public void setRose(int rose) {
			this.rose = rose;
		}

}